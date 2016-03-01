/**
 * Maximum_Subarray.
 * leetcode
 *
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 */


class leetcode_Maximum_Subarray {

  public static void main(String[] args) {
	System.out.println(maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }

  public static int maxSubArray(int[] A) {
	boolean allNeg = true; // All elem are neg is special case.
	int sum = 0;
	int max = 0;
	int localMax = Integer.MIN_VALUE;
	for (int i = 0; i < A.length; ++i) {
	  allNeg = (A[i] > 0) ? false : allNeg;
	  localMax = Math.max(localMax, A[i]);
	  sum += A[i];
	  if (sum < 0) {
		sum = 0;
	  }
	  max = Math.max(max, sum);
	}

	return (allNeg) ? localMax : max;
  }
}

/* Python Version
def maxSubArray(self, A):
    if not A:
        return 0

    all_neg = True
    max_val = 0
    acc = 0
    for val in A:
        all_neg = False if val > 0 else all_neg
        acc += val
        if acc < 0:
            acc = 0
        max_val = max(max_val, acc)
    return max_val if not all_neg else max(A)
*/
