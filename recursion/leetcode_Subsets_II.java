/**
 * Subsets_II.
 *
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class leetcode_Subsets_II {

  public static void main(String[] args) {
    System.out.println(subsetsWithDup(new int[] {1, 2, 2, 3, 4, 4}));
    System.out.println(subsetsWithDup(new int[] {1, 2, 2}));
  }

  public static List<List<Integer>> subsetsWithDup(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> all = new ArrayList<>();
    all.add(new ArrayList<Integer>());
    List<Integer> acc = new ArrayList<>();
    nextSubset(num, 0, all, acc);
    return all;
  }

  public static void nextSubset(int[]num, int start, List<List<Integer>> all, List<Integer> acc) {
    for (int i = start; i < num.length; ++i) {
      if (start < i && num[i - 1] == num[i]) {
        continue;
      }
      // With num[i].
      acc.add(num[i]);
      all.add(new ArrayList(acc));
      nextSubset(num, i + 1, all, acc);
      acc.remove(acc.size() - 1);
    }
  }
}


/* Python Version
*Notes*: since frozenset can not be used, str is used with delimiter ':'
to guarantee the uniqueness.

def subsetsWithDup(self, S):
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
