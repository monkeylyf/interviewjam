/*Maximum_Subarray

Find the contiguous subarray within an array (containing at least one number)
which has the largest sum.
For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
More practice:
If you have figured out the O(n) solution, try coding another solution using
the divide and conquer approach, which is more subtle.
*/


class leetcode_Maximum_Subarray {
    public static void main(String[] args) {
    }
    public static int maxSubArray(int[] A) {
        boolean noPositive = true;
        int sum = 0;
        int max = 0;
        int localMax = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] > 0 && noPositive) {
                // Flag if true indicating all elements <= 0.
                noPositive = false;
            }
            localMax = Math.max(localMax, A[i]);
            sum += A[i];
            if (sum > max) {
                max = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }
        if (noPositive) {
            // if all element are negtive, return the maximum element.
            return localMax;
        } else {
            return max;
        }
    }
}
