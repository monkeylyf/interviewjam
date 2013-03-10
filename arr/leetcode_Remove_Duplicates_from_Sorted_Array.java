/*Remove_Duplicates_from_Sorted_Array

Given a sorted array, remove the duplicates in place such that each element
appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with
constant memory.
For example,
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2].
*/


class leetcode_Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        removeDuplicates(new int[] {1, 1, 1, 2});
        removeDuplicates(new int[] {1, 2, 2, 3});
        removeDuplicates(new int[] {1, 2, 3, 3});
    }
    public static int remove(int[] A) {
        // Complexity O(n). if array is sorted.
        if (A == null || A.length = 0) {
            return  0;
        }
        int processed = 1;
        for (int i = 1; i < A.length; ++i) {
            if (A[i] != A[i - 1]) {
                A[processed++] = A[i];
            }
        }
        return processed;
    }
}
