/**
 * Word_Break.
 * leetcode
 *
 * Given a string s and a dictionary of words dict, determine if s can be segmented
 * into a space-separated sequence of one or more dictionary words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 */

import java.util.Set;
import java.util.Collections;
import java.util.HashSet;


public class leetcode_Word_Break {

  public static void main(String[] args) {
    Set<String> dict = new HashSet<String>();
    Collections.addAll(dict, "leet", "code");
    // Test case 1.
    System.out.println(wordBreak("leetcode", dict));
    // Test case 2.
    dict = new HashSet<String>();
    Collections.addAll(dict, "a", "b");
    System.out.println(wordBreak("ab", dict));
  }

  /**
   * DP solution.
   *
   * O(n^2) time complexity. O(n) space complexity.
   */
  public static boolean wordBreak(String s, Set<String> dict) {
    int n = s.length();
    boolean[] dp = new boolean[n];
    // DP.
    for (int i = 0; i < n; ++i) {
      // Check if s[:i + 1] is in dict.
      if (dict.contains(s.substring(0, i + 1))) {
        dp[i] = true;
      }
      // Check anys[j : i + 1], if in the dict, if yes, then check dp[j - i]
      for (int j = 1; j <= i && !dp[i]; ++j) {
        if (dict.contains(s.substring(j, i + 1))) {
          dp[i] = dp[j - 1];
        }
      }
    }

    return dp[n - 1];
  }

  // Exponential time complexity.
  public static boolean wordBreakRecursive(String s, Set<String> dict) {
    if (s.length() == 0) {
      return true;
    } else {
      for (int i = 1; i < s.length(); ++i) {
        if (dict.contains(s.substring(0, i))) {
          if (wordBreak(s.substring(i), dict)) {
            return true;
          }
        }
      }
      return false;
    }
  }
}


/*Python Version
def wordBreak(self, s, dict):
    dp = [ False for _ in xrange(len(s)) ]

    for i in xrange(len(s)):
        for j in xrange(i + 1):
            if s[j : i + 1] in dict and (j == 0 or dp[j - 1]):
                dp[i] = True
                break
    return dp[-1]

*/
