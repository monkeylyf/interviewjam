/*4Sum

Given an array S of n integers, are there elements a, b, c, and d in S such
that a + b + c + d = target? Find all unique quadruplets in the array which
gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order.
(ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
For example, given array S = {1, 0, -1, 0, -2, 2}, and target = 0.

A solution set is:
(-1,  0, 0, 1)
(-2, -1, 1, 2)
(-2,  0, 0, 2)
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Collections;


class leetcode_4Sum {
    public static void main(String[] args) {
        for (ArrayList<Integer> i : fourSum(new int[] {2, 1, 0, -1}, 2)) System.out.println(i);
    }
    // Since we've know how to implement 3Sum.
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length -3; ++i) {
            if (i > 0 && num[i - 1] == num[i]) {
                // Latter threeSum either has no or the same solution as previous.
                continue;
            }
            int[] arr = Arrays.copyOfRange(num, i + 1, num.length);
            ArrayList<ArrayList<Integer>> threeSum = threeSum(arr, target - num[i]);
            for (ArrayList<Integer> list : threeSum) {
                list.add(0, num[i]);
                all.add(list);
            }
        }
        return all;
    }
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num, int target) {
        // Difference between original 3sum question: args num is already sorted.
        HashSet<ArrayList<Integer>> all = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i < num.length - 2; ++i) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                if (num[j] + num[k] > target - num[i]) {
                    --k;
                } else if (num[j] + num[k] < target - num[i]) {
                    ++j;
                } else {
                    Collections.addAll(tmp, num[i], num[j++], num[k--]);
                    all.add(tmp);
                    tmp = new ArrayList<Integer>();
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(all);
    }
    // O(N^3), way too slow.
    public static ArrayList<ArrayList<Integer>> fourSumTooSlow(int[] num, int target) {
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> all = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length - 3; ++i) {
            for (int j = i + 1; j < num.length - 2; ++j) {
                int h = j + 1;
                int k = num.length -1;
                int part = target - num[i] - num[j];
                while (h < k) {
                    int cur = num[h] + num[k];
                    if (part < cur) --k;
                    else if (part > cur) ++h;
                    else {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        Collections.addAll(tmp, num[i], num[j], num[h], num[k]);
                        if (all.add(tmp)) res.add(tmp);
                        tmp = new ArrayList<Integer>();
                    }
                }
            }
        }
        return res;
    } 
}
