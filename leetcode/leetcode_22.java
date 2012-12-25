/*Given n non-negative integers a1, a2, ..., an, where each represents a point
at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

import java.util.Arrays;

class leetcode_22 {
    public static void main(String[] args) {
    }
    // O(N)
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        if (height[i] < height[j]) max = height[i++] * j;
        else max = height[j] * j--;
        while(i < j) {
            int cur = Math.min(height[i], height[j]) * (j - i);
            if (cur > max) max = cur;
            if (height[i] < height[j]) i++;
            else j--;
        }
        return max;
    }
    // O(N^2) too simple sometimes naive...way too slow.
    public static int maxA(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                int cur = (j - i) * Math.min(height[i], height[j]);
                if (cur > max) max = cur;
            }
        }
        return max;
    }
}
