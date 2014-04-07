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
        System.out.println(combinationSum(new int[] {1, 2}, 4));
        System.out.println(combinationSum(new int[] {2, 3, 6, 7}, 7));
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> container = new ArrayList<ArrayList<Integer>>();
        
        if (candidates == null || candidates.length == 0) {
            return container;
        }        
		// Sort the int array to dups will be skipped later in dfs.        
        Arrays.sort(candidates);
        ArrayList<Integer> acc = new ArrayList<Integer>();
        dfs(0, target, acc, container, candidates);
        return container;
    }
    
    public static void dfs(int idx, int target, ArrayList<Integer> acc, ArrayList<ArrayList<Integer>> container, int[] candidates) {
        if (target == 0) {
			// All val in acc sums up to target. Collect!
            ArrayList<Integer> token = new ArrayList<Integer>();
            for (int i : acc) {
                token.add(i);
            }
            container.add(token);
        } else if (target > 0) {
            int i = idx;
            while (i < candidates.length) {
				// Standard dfs.
                acc.add(candidates[i]);
                dfs(i, target - candidates[i], acc, container, candidates);
                acc.remove(acc.size() - 1);
                i += 1;
               	// Skip dups after jumped out of previous dfs recursion.  
                while (i < candidates.length && candidates[i - 1] == candidates[i]) {
                    i += 1;
                }
            }
        } else {
			// If target < 0 then prune.
            return;
        }
    }

	/* The solution below is obsolete. HashSet works but does not help reduce time complexity*/
    public static ArrayList<ArrayList<Integer>> combinationSum1(int[] candidates, int target) {
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


/* Python Version

def combinationSum(self, candidates, target):
    def dfs(idx, candidates, target, acc, container):
        if target == 0:
            container.append(acc[::])
        elif target > 0:
            i = idx
            while i < len(candidates):
                acc.append(candidates[i])
                dfs(i, candidates, target - candidates[i], acc, container)
                acc.pop()
                i += 1
                while i < len(candidates) and candidates[i - 1] == candidates[i]:
                    i += 1
        else:
            pass

    container = []
    candidates = sorted(candidates)
    dfs(0, candidates, target, [], container)

    return container
*/
