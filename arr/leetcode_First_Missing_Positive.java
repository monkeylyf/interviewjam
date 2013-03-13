/*First_Missing_Positive

Given an unsorted integer array, find the first missing positive integer.
For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.
Your algorithm should run in O(n) time and uses constant space.
*/

class leetcode_First_Missing_Positive {
    public static void main(String[] args) {
        firstMissingPositive(new int[] {1});
    }
    public static int firstMissingPositive(int[] A) {
        // The idea is declare a boolean array with length A.length + 2
        // bool[0] is wasted because here the index is considered as potential missing int.
        // bool[len + 1] is for the case that {1,2,3,4,5} the missing one is 6.
        boolean[] arr = new boolean[A.length + 2];
        for (int i = 0; i < A.length; ++i) {
            if (A[i] <= A.length && A[i] > 0) {
                arr[A[i]] = true;
            }
        }
        for (int i = 1; i < arr.length; ++i) {
            if (!arr[i]) {
                return i;
            }
        }
        return 1;
    }
}
