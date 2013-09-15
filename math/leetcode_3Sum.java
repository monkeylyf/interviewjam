/*3Sum

Given an array S of n integers, are there elements a, b, c in S such that
a + b + c = 0? Find all unique triplets in the array which gives the sum of
zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.

For example, given array S = {-1, 0, 1, 2, -1, -4},
A solution set is:
(-1, 0, 1)
(-1, -1, 2)
*/

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

public class leetcode_3Sum {

    public static void main(String[] args) {
        int[] S = new int[] {-1, 0, 1, 2, -1, -4};
        threeSum(S);
    }

    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num); // O(n logn).
        HashSet<ArrayList<Integer>> all = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i < num.length - 2; ++i) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                if (num[j] + num[k] > -num[i]) {
                    --k;
                } else if (num[j] + num[k] < -num[i]) {
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
}
