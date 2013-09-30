/*Binary_Search
google

Miss target: return i, which A[i] > target and A[i - 1] < target;
If duplicate target exist, return i, where i is the max index among all duplicates. 

*/

public class google_Binary_Search {

    public static void main(String[] args) {
       System.out.println(binarySearch(new int[] {1, 2, 2, 4}, 3) == 3);
        //assert binarySearch(new int[] {1, 2, 2, 4}, 2) == 2;
        //assert binarySearch(new int[] {1, 2, 2, 2, 4}, 3) == 3;
        //assert binarySearch(new int[] {1, 2, 2, 4}, 1) == 0;
        //assert binarySearch(new int[] {1, 2, 2, 4}, 5) == 3;
    }

    public static int binarySearch(int[] A, int target) {
        return binarySearch(A, target, 0, A.length - 1);
    }

    public static int binarySearch(int[] A, int target, int head, int tail) {
        while (head <= tail) {
			int middle = (tail - head) / 2 + head;
            int med = A[middle];
            if (med > target) {
                tail = middle - 1; 
            } else if (med < target) {
                head = middle + 1;
            } else {
                // med == target. Check if target exists between [med + 1, tail].
                int index = binarySearch(A, target, middle + 1, tail);
                if (A[index] == target) {
                    return index;
                } else {
                    return middle;
                }
            }
        }
		// If it reaches here, target does not exit in this array, return head. 
        return head;
    }
}
