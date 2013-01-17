/*Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of
each bar is 1, compute how much water it is able to trap after raining.
For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/


import java.util.Stack;


class leetcode_111 {
    public static void main(String[] args) {
    
    }
    public static int trap(int[] A) {
        Stack<Integer> s = new Stack<Integer>();
        int res = 0;
        int left, oldLevel, newLevel;
        for (int i = 0; i < A.length; ++i) {
            while (!s.isEmpty() && (i == A.length || A[i] > A[s.peek()])) {
                // Can hold some water.
                oldLevel = A[s.peek()];
                s.pop();
                // Remember to check if the stack is empty or not
                // also, only add water when i < n.
                if (!s.isEmpty() && i < A.length) {
                    left = s.peek();
                    newLevel = Math.min(A[i], A[left]);
                    res += (newLevel - oldLevel) * (i - left - 1);
                }
            }
            if (i < A.length) {
                s.push(i);
            }
        }
        return res;
    }
}
