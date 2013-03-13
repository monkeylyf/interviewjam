/*Container_With_Most_Water

Given n non-negative integers a1, a2, ..., an, where each represents a point
at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/


import java.util.Arrays;


class leetcode_Container_With_Most_Water {
    public static void main(String[] args) {
    }
    // O(N)
    public static int maxArea(int[] height) {
        int head = 0;
        int tail = height.length - 1;
        int max = 0;
        if (height[head] < height[tail]) {
            max = height[head] * tail;
            ++head;
        } else {
            max = height[tail] * tail;
            --tail;
        }
        while(head < tail) {
            int cur = Math.min(height[head], height[tail]) * (tail - head);
            if (cur > max) {
                max = cur;
            }
            if (height[head] < height[tail]) {
                // No matter what value height[tail - 1] is,
                // cur >= Math.min(height[head], height[tail - 1]) * (tail - head -1)
                // So move the index of min value.
                head++;
            } else {
                tail--;
            }
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
