/*Combinations

Given two integers n and k, return all possible combinations of k numbers out
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

Mark as duplicate: with ./cap_K_Combination
*/

import java.util.ArrayList;


public class leetcode_Combinations {

    public static void main(String[] args) {
        for (ArrayList<Integer> k: combine(7, 3)) System.out.println(k);
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
            ArrayList<Integer> res = new ArrayList<Integer>(tmp);
            all.add(res);
        } else {
            for (int i = s; i <= n; ++i) {
                tmp.add(i);
                nextCombine(i + 1, n, k, tmp, all);
                tmp.remove(tmp.size() - 1); // Backtracking
            }
        }
    }
}

/* Python Version
def combine(self, n, k):
    def dfs(idx, n, k, acc, container):
        if len(acc) == k:
            container.append(acc[::])
        else:
            for i in xrange(idx, n + 1):
                acc.append(i)
                dfs(i + 1, n, k, acc, container)
                acc.pop()
        
    container = []
    dfs(1, n, k, [], container)
    return container
*/
