/*Combination_Sum_II

Given a collection of candidate numbers (C) and a target number (T), find all
unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.
Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order.
(ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;


public class leetcode_Combination_Sum_II {

  public static void main(String[] args) {
	combinationSum2(new int[] {8, 7, 4, 3}, 11);
  }

  public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	ArrayList<ArrayList<Integer>> container = new ArrayList<ArrayList<Integer>>();

	if (num == null || num.length == 0) {
	  return container;
	}

	Arrays.sort(num);
	ArrayList<Integer> acc = new ArrayList<Integer>();
	dfs(0, target, acc, num, container);

	return container;
  }

  public static void dfs(int i, int target, ArrayList<Integer> acc, int[] num, ArrayList<ArrayList<Integer>> container) {
	if (target == 0) {
	  ArrayList<Integer> token = new ArrayList<Integer>();
	  for (int val : acc) {
		token.add(val);
	  }
	  container.add(token);
	} else if (target > 0) {
	  while (i < num.length) {
		acc.add(num[i]);
		dfs(i + 1, target - num[i], acc, num, container);
		acc.remove(acc.size() - 1);
		i += 1;

		while (i < num.length && num[i - 1] == num[i]) {
		  i += 1;
		}
	  }
	} else {
	  return; // target < 0
	}
  }

  /* The solution below is obsolete.*/
  public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	HashSet<ArrayList<Integer>> all = new HashSet<ArrayList<Integer>>();
	ArrayList<Integer> tmp = new ArrayList<Integer>();
	nextInt(num, all, tmp, 0, target);
	for (ArrayList<Integer> i : all) {
	  System.out.println(i);
	}
	return new ArrayList<ArrayList<Integer>>(all);
  }

  public static void nextInt(int[] num, HashSet<ArrayList<Integer>> all, ArrayList<Integer> tmp, int sum, int target) {
	for (int i : num) System.out.print(i + " ");
	System.out.println();
	if (sum == target) {
	  ArrayList<Integer> res = new ArrayList<Integer>(tmp);
	  Collections.sort(res);
	  all.add(res);
	} else if (sum < target) {
	  for (int i = 0; i < num.length; ++i) {
		tmp.add(num[i]);
		// Since every element can be used only once.
		// Remove trim the array and pass it to next recursion.
		nextInt(Arrays.copyOfRange(num, i + 1, num.length), all, tmp, sum + num[i], target);
		tmp.remove(tmp.size() - 1);
	  }
	} 
  }
}


/* Python Version
class Solution:
    # @param candidates, a list of integers
    # @param target, integer
    # @return a list of lists of integers
    def combinationSum2(self, candidates, target):
        def dfs(idx, candidates, target, acc, container):
            if target == 0:
                container.append(acc[::])
            elif target > 0:
                i = idx
                while i < len(candidates):
                    acc.append(candidates[i])
                    dfs(i + 1, candidates, target - candidates[i], acc, container)
                    acc.pop()
                    i += 1
                    
                    while i < len(candidates) and candidates[i - 1] == candidates[i]:
                        i += 1
            else:
                return
        
        if not candidates:
            return []
        
        container = []
        candidates = sorted(candidates)
        dfs(0, candidates, target, [], container)
        
        return container
*/
