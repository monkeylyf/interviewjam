/*Balanced_Partition

You have a set of n integers each in the range 0 ... K. Partition these
integers into two subsets such that you minimize |S1 - S2|, where S1 and S2
denote the sums of the elements in each of the two subsets.
*/

class Balanced_Partition {
    public static void main(String[] args) {
        partition(new int[] {3, 1, 1, 2, 2, 1});
    
    }
    public static void partition(int[] arr) {
        // If sum is even, each set should sum up to N/2
        // if sum is odd, one set should sum up to N/2 and another N/2 + 1.
        int sum = 0;
        for (int i  : arr) {
            sum += i;
        }
        boolean[][] status = new boolean[sum / 2 + 1][arr.length + 1];
        for (int i = 0; i < arr.length; ++i) {
            status[0][i] = true;
        }
        for (int i = 1; i <= sum / 2; ++i) {
            for (int j = 1; j <= arr.length; ++j) {
                // if status[i][j - 1] == true, then status[i][j] == true.
                // else status[i][j] == status[i - arr[j]][j - 1]
                if (status[i][j - 1]) {
                    status[i][j] = true;
                } else {
                    status[i][j] = (i - arr[j - 1] >= 0) ? status[i - arr[j - 1]][j - 1] : false;
                }
            }
        }
        printMatrix(status);
    }
    public static void printMatrix(boolean[][] status) {
        for (int i = 0; i < status.length; ++i) {
            for (int j = 0; j < status[i].length; ++j) {
                System.out.print(status[i][j] + " ");
            }
            System.out.println();
        }
    }
}
