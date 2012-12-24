/*Given two integers n and k, return all possible combinations of k numbers out
of 1 ... n.
For example,
If n = 4 and k = 2, a solution is:
[
    [2,4],
    [3,4],
    [2,3],
    [1,2],
    [1,3],
    [1,4],
]
*/

import java.util.ArrayList;


class leetcode_19 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> retval = new ArrayList<ArrayList<Integer>>();
        retval = combine(7, 3);
        for (ArrayList<Integer> k: retval) {
            for (int i : k) System.out.print(i + " ");
            System.out.println("");
        }
    }
    // IMO it is permutation rather than combination...
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        nextCombine(1, n, k, tmp, all);
        return all;
    }
    public static void nextCombine(int s, int n, int k, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> all) {
        if (tmp.size() == k) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            for (int i : tmp) res.add(i);
            all.add(res);
        } else {
            for (int i = s; i <= n; ++i) {
                tmp.add(i);
                nextCombine(i + 1, n, k, tmp, all);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
