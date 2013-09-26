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
