/*Search_in_Rotated_Sorted_Array

Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., [0 1 2 4 5 6 7] might become [4 5 6 7 0 1 2]).
You are given a target value to search. If found in the array return its index,
otherwise return -1.
You may assume no duplicate exists in the array.
*/


public class leetcode_Search_in_Rotated_Sorted_Array {

    public static void main(String[] args) {

    }

    public static int search(int[] A, int target) {
        int start = 0, end = A.length - 1, middle;
        while (start <= end) {
			middle = (end - start) / 2 + start;
            if (target == A[middle]) {
                return middle;
            } else if (A[start] <= A[middle]) {
                // [3 4 5 6 7 0 1 2] middle 6 > start 3
                if (A[start] <= target && target <= A[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else {
                // A[start] > A[middle] [6 7 0 1 2 3 4 5]
                if (A[middle] <= target && target <= A[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }
}
