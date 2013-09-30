/*Search_in_Rotated_Sorted_Array_II
leetcode

Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?
Write a function to determine if a given target is in the array.
*/

public class leetcode_Search_in_Rotated_Sorted_Array_II {

    public static void main(String[] args) {

    }

    public static boolean search(int[] A, int target) {
        return binarySearch(A, 0, A.length - 1, target);
    }

    public static boolean binarySearch(int[] A, int start, int end, int target) {
        // The idea behind this is basically the same as Search_in_Rotated_Sorted_Array.
        while (start <= end) {
			int middle = (end - start) / 2 + start;
            if (target == A[middle]) {
                return true;
            } else if (A[start] < A[middle]) {
                // [3 3 4 6 6 1 1 2] middle 6 > start 3
                if (A[start] <= target && target <= A[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else if (A[start] > A[middle]){
                // [6 6 1 1 2 3 3 4] middle 1 < start 6
                if (A[middle] <= target && target <= A[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            } else {
                // A[middle] == A[start] [1 3 1 1 1]
                return binarySearch(A, start, middle - 1, target) || binarySearch(A, middle + 1, end, target);
            }
        }
        return false;
    }
}
