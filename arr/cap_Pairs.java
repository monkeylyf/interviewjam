/**
 * Pairs.
 * careercup
 *
 * Design an algorithm to find all pairs of integers within an array which sum
 * to a specified value
 *
 * arr/hackerrank_Pairs: find pairs with fixed diff.
 *
 * math/leetcode_Two_Sum.java
 * Mark as duplicate.
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class cap_Pairs {

  public static void main(String[] args) {
    int[] input= {0, 3, 5, 14, 6, -1, 7, 8, 13, -2};
    System.out.println(printPair(input, 5));
  }

  public static List<List<Integer>> printPair(int[] arr, int sum) {
    // Find pairs with fixed sum.
    Set<Integer> set = new HashSet<Integer>();
    List<List<Integer>> all = new ArrayList<List<Integer>>();
    for (int i : arr) {
      if (set.contains(sum - i)) {
        List<Integer> tmp = new ArrayList<Integer>();
        Collections.addAll(tmp, i, sum - i);
        all.add(tmp);
      }
      set.add(i);
    }

    return all;
  }
}
