/*Trapping_Rain_Water

Given n non-negative integers representing an elevation map where the width of
each bar is 1, compute how much water it is able to trap after raining.
For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/


import java.util.Stack;


class leetcode_Trapping_Rain_Water {
    public static void main(String[] args) {
        trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
    }
    public static int trap(int[] A) {
        // Time complexity is O(n) since pop() and push() operation happens once each.
        // The idea behind this is find the right higher bank first then mark the lower.
        // Then find the left higher bank, trapped water = (Math.min(left high, right high) - lower) * width.
        Stack<Integer> s = new Stack<Integer>();
        int res = 0;
        int prev, lowBank, highBank;
        for (int i = 0; i < A.length; ++i) {
            // The while loop here makes sure that stack s contains only decreasing int sequence
            // increasing sequence means water might be trapped.
            while (!s.isEmpty() && A[i] > A[s.peek()]) { // right higher bank detected
                lowBank = A[s.pop()]; // lower bottom
                if (!s.isEmpty()) {
                    prev = s.peek();
                    highBank = Math.min(A[i], A[prev]); // left hihger bank
                    res += (highBank - lowBank) * (i - prev - 1);
                }
            }
            s.push(i);
        }
        return res; 
    }
}
