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
        int a_tail = m - 1;
        int b_tail = n - 1;
        while (a_tail >= 0 && b_tail >= 0) {
            if (A[a_tail] > B[b_tail]) {
                A[a_tail + b_tail + 1] = A[a_tail];
                --a_tail;
            } else {
                A[a_tail + b_tail + 1] = B[b_tail];
                --b_tail
            }
        }
        // The goal is to merge B into A. If B is done, merging is done.
        // Sanity check for if B is done.
        while (b_tail >= 0) {
            A[b_tail] = B[b_tail--];
        }
    }
}
