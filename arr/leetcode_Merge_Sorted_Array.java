/*Merge_Sorted_Array

Given two sorted integer arrays A and B, merge B into A as one sorted array.
Note:
You may assume that A has enough space to hold additional elements from B. The
number of elements initialized in A and B are m and n respectively.
*/

class leetcode_Merge_Sorted_Array {
    public static void main(String[] args) {
        merge(new int[] {2, 0}, 1, new int[] {1}, 1);
    }
    public static void merge(int A[], int m, int B[], int n) {
        while (n > 0 && m > 0) {
            if (A[m - 1] > B[n - 1]) A[m + n - 1] = A[m-- - 1];
            else A[m + n - 1] = B[n-- - 1];
        }
        // The goal is to merge B into A. If B is done, merging is done.
        // Sanity check for if B is done.
        while (n > 0) A[n - 1] = B[n-- - 1];
    }
}
