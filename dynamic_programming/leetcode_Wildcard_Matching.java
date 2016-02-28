/**
 * Wildcard_Matching.
 * leetcode
 *
 * Implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") -> false
 * isMatch("aa","aa") -> true
 * isMatch("aaa","aa") -> false
 * isMatch("aa", "*") -> true
 * isMatch("aa", "a*") -> true
 * isMatch("ab", "?*") -> true
 * isMatch("aab", "c*a*b") -> false
 * */


class leetcode_Wildcard_Matching {

  public static void main(String[] args) {
    isMatch("", "*");
  }

  public static boolean isMatch(String s, String p) {
    int ss = 0;
    int pp = 0;
    int prevS = 0;
    int prevP = 0;
    boolean seenStar = false;

    while (ss < s.length()) {
      char S = s.charAt(ss);
      char P = (pp < p.length()) ? p.charAt(pp) : '\0';
      if (S == P || P == '?') {
        // If two char are equal move both index.
        // '?' match any single char.
        ++ss;
        ++pp;
      } else {
        if (P == '*') {
          seenStar = true;
          while (pp < p.length() && p.charAt(pp) == '*') {
            // Star match any sequence of character. Mutliple stars is same as one start.
            ++pp;
          }
          if (pp == p.length()) {
            // If p has one or many stars at the end, it will match what's left in s.
            return true;
          }
          // Mark the last seen star index.
          prevS = ss;
          prevP = pp;
        } else if (seenStar) {
          ++prevS;
          ss = prevS;
          pp = prevP;
        } else {
          return false;
        }
      }
    }

    while (pp < p.length() && p.charAt(pp) == '*') {
      ++pp;
    }

    return pp == p.length();
  }

  /*Obsolete.*/
  public static boolean isMatch(String s, String p) {
    // The idea behind this is basically same as Regular_Expression_Matching.
    boolean[] prev = new boolean[p.length() + 1];
    prev[0] = true;
    for (int i = 0; i < p.length(); ++i) {
      if (p.charAt(i) == '*') {
        prev[i + 1] = true;
      } else {
        break;
      }
    }
    for (int i = 0; i < s.length(); ++i) {
      char charS = s.charAt(i);
      boolean[] next = new boolean[p.length() + 1];
      for (int j = 0; j < p.length(); ++j) {
        char charP = p.charAt(j);
        if (charS == charP || charP == '?') {
          // '?' Matches any single character.
          next[j + 1] = prev[j];
        } else if (charP == '*') {
          // '*' Matches any sequence of characters (including the empty sequence).
          next[j + 1] = next[j] || prev[j] || prev[j + 1];
        } else {
          // Mismatch. This else is not necessary because the default is false.
          next[j + 1] = false;
        }
      }
      prev = next;
    }
    return prev[prev.length - 1];
  }
}
