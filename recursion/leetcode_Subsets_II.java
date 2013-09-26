/*Subsets_II

Given a collection of integers that might contain duplicates, S, return all
possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class leetcode_Subsets_II {

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] {1, 2, 2, 3, 4, 4}));
        System.out.println(subsetsWithDup(new int[] {1, 2, 2}));
    }

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // The idea behind this is almost same as Subsets.
        // The only different is we used HashSet as the accumulator to avoid duplicates.
        HashSet<ArrayList<Integer>> all = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        nextSubset(num, 0, all, tmp);
        return new ArrayList<ArrayList<Integer>>(all);
    }

    public static void nextSubset(int[]num, int n, HashSet<ArrayList<Integer>> all, ArrayList<Integer> tmp) {
        if (num.length == n) {
            ArrayList<Integer> res = new ArrayList<Integer>(tmp);
            Collections.sort(res);
            all.add(res);
        } else {
            // With num[n].
            tmp.add(num[n]);
            nextSubset(num, n + 1, all, tmp);
            tmp.remove(tmp.size() - 1);
            // Withough num[n].
            nextSubset(num, n + 1, all, tmp);
        }
    }
}
