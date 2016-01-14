/**
 * Scramble_String.
 *
 * Given a string s1, we may represent it as a binary tree by partitioning it to
 * two non-empty substrings recursively.
 * Below is one possible representation of s1 = "great":

 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t

 * To scramble the string, we may choose any non-leaf node and swap its two
 * children.
 * For example, if we choose the node "gr" and swap its two children, it
 * produces a scrambled string "rgeat".

 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t

 * We say that "rgeat" is a scrambled string of "great".
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it
 * produces a scrambled string "rgtae".

 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a

 * We say that "rgtae" is a scrambled string of "great".
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled
 * string of s1.
 */

class leetcode_Scramble_String {

  public static void main(String[] args) {
	//System.out.println(isScramble("abcde", "bacdef"));
	System.out.println(isScramble("great", "rgtae") == isScramble1("great", "rgtae"));
	System.out.println(isScramble("a", "a"));
  }

  /**
   * This solution is dp-based.
   *
   * dp[i][j][k] represents if s1.substr(i, i + k) is scramble of s2.substr(j, j + k)
   * Then dp[0][0][n] is what we want eventually.
   * Down-to-top. Staring from i = j = n - 1. k = 1.
   */
  public static boolean isScramble(String s1, String s2) {
	int n = s1.length();
	boolean[][][] dp = new boolean[n][n][n + 1];
	for (int i = n - 1; i >= 0; --i) {
	  for (int j = n - 1; j >= 0; --j) {
		for (int k = 1; k <= n - Math.max(i, j); ++k) {
		  if (s1.substring(i, i + k).equals(s2.substring(j, j + k))) {
			// substrings are equal => is scramble based on definition.
			dp[i][j][k] = true;
		  } else {
			for (int l = 1; l < k; ++l) {
			  // index l is a pivot, which parts the string into two substring.
			  // s1.substr(i,i+l) is scramble of s2.substr(j,j+l) and
			  // s1.substr(i+l) is scramble of s2.substr(j+l)
			  if ((dp[i][j][l] && dp[i + l][j + l][k - l]) ||
				  // s1.substr(i,i+l) is scramble of s2.substr(j+k-l) and
				  // s1.substr(j+l) is cramble of s2.substr(j)
				  (dp[i][j + k - l][l] && dp[i + l][j][k - l]))	 {
				dp[i][j][k]	= true;
				break;
			  }
			}
		  }
		}
	  }
	}
	return dp[0][0][n];
  }

  public static boolean isScramble1(String s1, String s2) {
	// The idea behind is swapping.
	int n = s1.length(), i;
	if (n == 1) {
	  return s1.equals(s2);
	} else {
	  for (i = 1; i <= s2.length() / 2; ++i) {
		if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
			isScramble(s1.substring(i), s2.substring(i))) {
		  return true;
		}
		if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
			isScramble(s1.substring(i), s2.substring(0, n - i))) {
		  return true;
		}
		if (isScramble(s1.substring(n - i), s2.substring(0, i)) &&
			isScramble(s1.substring(0, n - i), s2.substring(i))) {
		  return true;
		}
		if (isScramble(s1.substring(n - i), s2.substring(n - i)) &&
			isScramble(s1.substring(0, n - i), s2.substring(0, n - i))) {
		  return true;
		}
	  }
	  return false;
	}
  }
}

/* Python Version

def isScramble(self, s1, s2):
    n = len(s1)
    # 3-dimension dp. dp[i][j][k] represents that if s1[i : i + k] is scramble of s2[j : j + k]
    # dp[0][0][n] is what we want to know. s1[0 : n] is scramble of s2[0 : k]
    dp = [ [ [ False for _ in xrange(n + 1) ] for _ in xrange(n) ] for _ in xrange(n) ]

    for i in reversed(xrange(n)):
        for j in reversed(xrange(n)):
            for k in xrange(1, n - max(i, j) + 1):
				# Straight forward, equal means yes.
                if s1[i : i + k] == s2[j : j + k]:
                    dp[i][j][k] = True
                else:
					# Using l as pivot.
					# aaa|bb    aaa|bb
					# ccc|dd    cc|ddd
                    for l in xrange(1, k):
                        if (dp[i][j][l] and dp[i + l][j + l][k - l]) or (dp[i][j + k - l][l] and dp[i + l][j][k - l]):
                            dp[i][j][k] = True
                            break

    return dp[0][0][n]
*/
