/*Given an unsorted integer array, find the first missing positive integer.
For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.
Your algorithm should run in O(n) time and uses constant space.
*/

class leetcode_30 {
    public static void main(String[] args) {
        firstMissingPositive(new int[] {1});
    }
    public static int firstMissingPositive(int[] A) {
        boolean[] arr = new boolean[A.length + 2];
        int res = 1;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] <= A.length && A[i] > 0) arr[A[i]] = true;
        }
        for (int i = 1; i < arr.length; ++i) {
            if (!arr[i]) {
                res = i;
                break;
            }
        }
        return res;
    }
}
