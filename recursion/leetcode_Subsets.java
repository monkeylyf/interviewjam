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
import java.util.List;
import java.util.Collections;


public class leetcode_Subsets {

  public static void main(String[] args) {
    // Test case.
    System.out.println(subsets(new int[] {1, 2, 3}));
  }

  public static List<ArrayList<Integer>> subsets(int[] S) {
    // The idea behind this is all(1,2,3) = set contains 1 + set contains no 1.
    // When we recurse through the array, we do two steps.
    // 1: Put the current element in the pocket, move on.
    // 2: Pass the current element, move on. (You have to remove the element you put in your pocket in step 1
    // since var acc is used as the pocket, which is called by reference.)
    List<ArrayList<Integer>> all = new ArrayList<>();
    List<Integer> acc = new ArrayList<>();
    nextSubset(S, 0, all, acc);
    return all;
  }

  public static void nextSubset(int[]S, int n, List<ArrayList<Integer>> all, List<Integer> acc) {
    if (S.length == n) {
      List<Integer> res = new ArrayList<>(acc);
      Collections.sort(res);
      all.add(res);
    } else {
      // With S[n].
      acc.add(S[n]);
      nextSubset(S, n + 1, all, acc);
      acc.remove(acc.size() - 1);
      // Withough S[n].
      nextSubset(S, n + 1, all, acc);
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
