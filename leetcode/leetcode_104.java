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


class leetcode_104 {
    public static void main(String[] args) {
        subsets(new int[] {1, 2, 3});
    }
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        nextSubset(S, 0, all, tmp);
        for (ArrayList<Integer> i : all) System.out.println(i);
        return all;
    }
    public static void nextSubset(int[]S, int n, ArrayList<ArrayList<Integer>> all, ArrayList<Integer> tmp) {
        if (n == S.length) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            for (int i : tmp) res.add(i);
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
