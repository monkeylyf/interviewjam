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
        // The problem is is sum / 2 is too large, say then million,
        // we need sum / 2 * arr.length space. TODO: opt for space complexity?
        // If sum is even, each set should sum up to N/2
        // if sum is odd, one set should sum up to N/2 and another N/2 + 1.
        int sum = 0, i;
        for (int j : arr) {
            sum += j; // sum of all element.
        }
        boolean[][] status = new boolean[sum / 2 + 1][arr.length];
        for (i = 0; i < arr.length; ++i) {
            status[0][i] = true;
        }
        for (i = 1; i <= sum / 2; ++i) {
            status[i][0] = arr[0] == i; // if a0 can sum up to i only when a0 = i.
            for (j = 1; j < arr.length; ++j) {
                // Check if (a, a1..aj-1) can sum up to i - j (i - j >= 0).
                boolean oneStepBack = (i - arr[j] >= 0) ? status[i - arr[j]][j - 1] : false;
                // if (a0,a1..aj-1) can sum up to i, then (a0,a1..aj) can sum up to i too.
                // Use OR operation to find out if (a, a1..aj) can sum up to i
                status[i][j] = oneStepBack || status[i][j - 1];
            }
        }
        printMatrix(status);
        for (i = status.length - 1; i >= 0; --i) {
            for (j = 0; j < status[i].length; ++j) {
                if (status[i][j]) {
                    break;  
                }
            }  
        }
        System.out.println(i);
    }
    public static void printMatrix(boolean[][] status) {
        for (int i = 0; i < status.length; ++i) {
            for (int j = 0; j < status[i].length; ++j) {
                if (status[i][j]) {
                    System.out.print("T ");
                } else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
    }
}
