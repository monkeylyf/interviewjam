/*Largest_Rectangle_in_Histogram

Given n non-negative integers representing the histogram's bar height where
the width of each bar is 1, find the area of largest rectangle in the
histogram.
For example,
Given height = [2,1,5,6,2,3],
return 10.
*/


import java.util.Stack;


class leetcode_Largest_Rectangle_in_Histogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] {2, 1, 5, 6, 5, 2, 3}));
    }
    public static int largestRectangleArea(int[] height) {
        /* 1. Brute force: O(n^2), (i = 0; i < n; ++i) (j = i + 1; j < n; ++j), track localMin and update max.
         * 2. Divide and conquer: O(nlogn). Implement a segment tree to track localMin. extend the localMin to
         *    both right and left as far as possible.
         * 3. Monotone priority stack: O(n)
         */
        int result = 0, lastIndex = 0, lastHeight = 0;
        Stack<Integer> indexes = new Stack<Integer>(); // Monotone priority stack to trace index.
        Stack<Integer> heights = new Stack<Integer>(); // Monotone priority stack to trace height.
        for (int i = 0; i < height.length; ++i) {
            if (heights.isEmpty() || height[i] > heights.peek()) { // Increasing height, push index and height.
                heights.push(height[i]);
                indexes.push(i);
            } else if (height[i] < heights.peek()) { // Decrease    
                while (!heights.isEmpty() && heights.peek() > height[i]) {
                    lastIndex = indexes.pop();
                    lastHeight = heights.pop();
                    result = Math.max(result, lastHeight * (i - lastIndex));
                }
                heights.push(height[i]);
                // Tricky part: instead of pushing(i), it pushes lastIndex, which is min index
                // height[i] can extent leftmost.
                indexes.push(lastIndex);
            }
        }
        while (!heights.isEmpty()) { // Last element as right border, update result.
            result = Math.max(result, heights.pop() * (height.length - indexes.pop()));
        }
        return result;
    }
}
