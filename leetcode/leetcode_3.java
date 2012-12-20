/*Given an array S of n integers, are there elements a, b, c, and d in S such
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


class leetcode_3 {
    public static void main(String[] args) {
        mySum(new int[] {0,-1,-4,-1,2,4,6}, 2);
    }
    // O(N^2 logN)
    public static ArrayList<ArrayList<Integer>> mySum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        int[] pair = new int[num.length * (num.length - 1) / 2];
        //Arrays.sort(num);
        int index = 0;
        for (int i = 0; i < num.length; ++i) {
            for (int j = i + 1; j < num.length; ++j) {
                System.out.println(i + " " + j);
                pair[index++] = num[i] + num[j];
            }
        }
        Arrays.sort(pair);
        for (int i : pair) System.out.print(i + " ");
        int start = 0;
        int end = pair.length - 1;
        while (start < end) {
            if (pair[start] + pair[end] > target) --end;
            else if (pair[start] + pair[end] < target) ++start;
            else {
                System.out.println(pair[start++] + " " + pair[end--]);
            }
        }
        return all;
    }
    // O(N^3), way too slow.
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
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
