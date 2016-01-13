/**
 * Subsets.
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class leetcode_Subsets {

  public static void main(String[] args) {
    // Test case.
    System.out.println(subsets(new int[] {1, 2, 3}));
  }

  public static List<List<Integer>> subsets(int[] S) {
    Arrays.sort(S);
    List<List<Integer>> all = new ArrayList<>();
    all.add(new ArrayList<Integer>());
    List<Integer> acc = new ArrayList<>();
    nextSubset(S, 0, all, acc);
    return all;
  }

  public static void nextSubset(int[] S, int start, List<List<Integer>> all, List<Integer> acc) {
    for (int i = start; i < S.length; ++i) {
      // With S[i].
      acc.add(S[i]);
      all.add(new ArrayList<Integer>(acc));
      nextSubset(S, i + 1, all, acc);
      acc.remove(acc.size() - 1);
    }
  }
}


/* Python Version
def subsets(self, S):
    def dfs(idx, S, acc, container):
        if idx == len(S):
            container.add(':'.join(acc))
        else:
            # Use it
            acc.append(str(S[idx]))
            dfs(idx + 1, S, acc, container)
            acc.pop()
            # Do not use it
            dfs(idx + 1, S, acc, container)

    S = sorted(S)
    container = set()
    dfs(0, S, [], container)

    ret = [[]]
    for item in container:
        if item:
            ret.append(map(int, item.split(':')))
    return ret
*/
