/*Trapping_Rain_Water

Given n non-negative integers representing an elevation map where the width of
each bar is 1, compute how much water it is able to trap after raining.
For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/


import java.util.Stack;


class leetcode_Trapping_Rain_Water {

  public static void main(String[] args) {
	System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
  }

  /**
   * Monotone decreasing stack solution.
   *
   * Time complexity is O(n) since pop() and push() operation happens once each.
   * The idea behind this is find the right higher bank first then mark the lower.
   * Then find the left higher bank, trapped water = (Math.min(left high, right high) - lower) * width.
   */
  public static int trap(int[] A) {
    // Stack to track index.
	Stack<Integer> s = new Stack<Integer>();
	int res = 0;

	for (int i = 0; i < A.length; ++i) {
	  // The while loop here makes sure that stack s contains only decreasing int sequence
	  // increasing sequence means water might be trapped.
	  while (!s.isEmpty() && A[i] > A[s.peek()]) { // right higher bank detected
		int low = A[s.pop()]; // bottom.
		if (!s.isEmpty()) {
		  int prev = s.peek();
		  int high = Math.min(A[i], A[prev]); // Min of left/right bank.
		  res += (high - low) * (i - prev - 1);
		}
	  }
	  s.push(i);
	}

	return res;
  }
}


/* Python Version

def trap(self, A):
    if not A:
        return 0

    ret = 0
    s = []
    for i in xrange(len(A)):
        while s and A[s[-1]] < A[i]:
            lower = A[s.pop()]
            if s:
                prev = s[-1]
                high = min(A[i], A[prev])
                ret += (high - lower) * (i - prev - 1)
        s.append(i)

    return ret
*/
