/*Combination_Sum

Given a set of candidate numbers (C) and a target number (T), find all unique
combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.
Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order.
(ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;


public class leetcode_Combination_Sum {

	/**
	 * Brutal force enumeration.
	 * Sort the array first so we can prune when the rest of values are
	 * large than remain.
	 */

    public static void main(String[] args) {
		// Test case.
        combinationSum(new int[] {1, 2}, 4);
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<ArrayList<Integer>> all = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        nextInt(candidates, all, tmp, 0, target);
        for (ArrayList<Integer> i : all) {
			System.out.println(i);
		}
        return new ArrayList<ArrayList<Integer>>(all);
    }

    public static void nextInt(int[] candidates, HashSet<ArrayList<Integer>> all, ArrayList<Integer> tmp, int sum, int target) {
        if (sum == target) {
            ArrayList<Integer> res = new ArrayList<Integer>(tmp);
            Collections.sort(res);
			all.add(res);
        } else if (sum < target) {
            for (int i = 0; i < candidates.length; ++i) {
                tmp.add(candidates[i]); // Looks like we can do prune here.
                nextInt(candidates, all, tmp, sum + candidates[i], target);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
