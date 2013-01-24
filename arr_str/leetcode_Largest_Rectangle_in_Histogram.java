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
        largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3});
    }
    public static int largestRectangleArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int result = 0;
        Stack<Integer> indexes = new Stack<Integer>();
        Stack<Integer> heights = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            if (heights.isEmpty() || height[i] > heights.peek()) {
                heights.push(height[i]);
                indexes.push(i);
            } else if (height[i] < heights.peek()) {
                int lastIndex = 0;
                int lastHeight = 0;
                while (!heights.isEmpty() && heights.peek() > height[i]) {
                    lastIndex = indexes.pop();
                    lastHeight = heights.pop();
                    result = Math.max(result, lastHeight * (i - lastIndex));
                }
                heights.push(height[i]);
                indexes.push(lastIndex);
            }
        }
        while (!heights.isEmpty()) {
            result = Math.max(result, heights.pop() * (height.length - indexes.pop()));
        }
        return result;
    }
}
