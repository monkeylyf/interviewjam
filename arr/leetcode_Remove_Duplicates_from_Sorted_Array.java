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
    public static int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int len = A.length;
        int processed = 1;
        for (int cur = 1; cur < len; ++cur) {
            int j = 0;
            for (;j < processed; ++j) {
                if (A[cur] == A[j]) {
                    break;
                }
            }
            if (j == processed) {
                A[processed] = A[cur];
                ++processed;
            }
        }
        return processed;
    }
}
