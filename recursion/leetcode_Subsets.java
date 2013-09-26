/*Subsets

Given a set of distinct integers, S, return all possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/


import java.util.ArrayList;
import java.util.Collections;


public class leetcode_Subsets {

    public static void main(String[] args) {
		// Test case.
        System.out.println(subsets(new int[] {1, 2, 3}));
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // The idea behind this is all(1,2,3) = set contains 1 + set contains no 1.
        // When we recurse through the array, we do two steps.
        // 1: Put the current element in the pocket, move on.
        // 2: Pass the current element, move on. (You have to remove the element you put in your pocket in step 1
        // since var tmp is used as the pocket, which is called by reference.)
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        nextSubset(S, 0, all, tmp);
        return all;
    }

    public static void nextSubset(int[]S, int n, ArrayList<ArrayList<Integer>> all, ArrayList<Integer> tmp) {
        if (S.length == n) {
            ArrayList<Integer> res = new ArrayList<Integer>(tmp);
            Collections.sort(res);
            all.add(res);
        } else {
            // With S[n].
            tmp.add(S[n]);
            nextSubset(S, n + 1, all, tmp);
            tmp.remove(tmp.size() - 1);
            // Withough S[n].
            nextSubset(S, n + 1, all, tmp);
        }
    }
}
