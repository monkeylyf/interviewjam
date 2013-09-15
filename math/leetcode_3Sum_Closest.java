/*3Sum Closest

Given an array S of n integers, find three integers in S such that the sum is
closest to a given number, target. Return the sum of the three integers. You
may assume that each input would have exactly one solution.

For example, given array S = {-1, 2, 1, -4}, and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

*/

import java.util.Arrays;

public class leetcode_3Sum_Closest {

    public static void main(String args[]) {
        for (int i : threeSumClosest(new int[] {-1, 2, 1, -4, 1}, 2)) System.out.println(i);
        for (int i : threeSumClosest(new int[] {-3, -2, -5, 3, -4}, -1)) System.out.println(i);
    }

    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int cur_sum = num[0] + num[1] + num[2];
        for (int i = 0; i < num.length - 2; ++i) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sum = num[i] + num [j] + num[k];
                if (Math.abs(sum - target) < Math.abs(cur_sum - target)) {
                    cur_sum = sum;
                }
                if (sum > target) {
                    --k;
                } else if (sum < target) {
                    ++j;
                } else {
                    break; // If sum == target, we've found the closest
                }
            }
        }
        return cur_sum;
    }
}
