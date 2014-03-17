/*Longest_Palindrome_Substring

Given a string s, find the longest palindrome substring in s.
*/


class Longest_Palindrome_Substring {
  public static void main(String[] args) {
	System.out.println(longestPalindromeSubstring(""));
	System.out.println(manacher(""));
	System.out.println(longestPalindromeSubstring("a"));
	System.out.println(manacher("a"));
	System.out.println(longestPalindromeSubstring("abbac"));
	System.out.println(manacher("abbac"));
  }

  public String longestPalindrome(String s) {
	if (s.length() == 0 || s.length() == 1) {
	  return s;
	}

	int n = s.length();
	int longest = 1;
	String ret = "";

	boolean[][] status = new boolean[n][n];
	// Init.
	for (int i = 0; i < n; ++i) {
	  status[i][i] = true;
	}

	for (int i = n - 2; i >= 0; --i) {
	  for (int j = i + 1; j < n; ++j) {
		status[i][j] = (s.charAt(i) == s.charAt(j)) && (j == i + 1 || status[i + 1][j - 1]);

		// Update.
		if (status[i][j] && j - i + 1 > longest) {
		  longest = j - i + 1;
		  ret = s.substring(i, j + 1);
		}
	  }
	}

	return ret;
  }

  // Manacher algorithm.
  public static String manacher(String A) {
	if (A.length() == 0) {
	  return A;
	}
	// Pre-processing: "abba" ==> "^#a#b#b#a#$".
	int n = A.length();
	if (n == 0) {
	  return "";
	}
	String T = "^"; // Starting with "^"
	for (int i = 0; i < n; ++i) {
	  T += "#" + A.substring(i, i + 1);
	}
	T += "#$"; // Ending with "$". Pre-processing finished.
	n = T.length();
	int longestRadius = 1;
	int longestPivot = 2;
	int[] status = new int[n]; 
	int pivot = 0; // pivot of the longest palindrome substring found so far.
	int rightEdge = 0; // right edge of longest palindrome substring found so far.
	for (int i = 1; i < n - 1; ++i) {
	  // pivot = (i + mirror) / 2. Find the symmetry point of i against on pivot.
	  int mirror = 2 * pivot - i;
	  // 1. rightEdge > i, 
	  // why status[i] = Math.min(stats[mirror], rightEdge - i) ?
	  // if (rightEdge - i > status[mirror]) status[i] = status[mirror];
	  // else /* P[j] >= mx - i */    status[i] = rightEdge - i;
	  // 2. rightEdge <= i, the range of current longest palindrome substring outreaches i. Symmetric info can no be reused. set statuc[i] = 0. 
	  status[i] = (rightEdge > i) ? Math.min(rightEdge - i, status[mirror]) : 0;
	  while (T.charAt(i + 1 + status[i]) == T.charAt(i - 1 - status[i])) {
		// expand if symmetry chars are equal.
		++status[i];
	  }
	  if (i + status[i] > rightEdge) { // Updating pivot and rightEdge.
		pivot = i;
		rightEdge = status[i] + i;
	  }
	  if (status[i] > longestRadius) {
		longestRadius = status[i];
		longestPivot = i;
	  }
	}
	return A.substring((longestPivot - longestRadius) / 2 , (longestPivot + longestRadius) / 2);
  }
}


/* Python Version (TLE!?)
def longestPalindrome(self, s):
    if not s or len(s) == 1:
        return s
        
    ret = ''
    local_max = 1
    
    dp = [ [ False for _ in xrange(len(s)) ] for _ in xrange(len(s)) ]
    # Init
    for i in xrange(len(s)):
        dp[i][i] = True
    
    for i in reversed(xrange(len(s) - 1)):
        for j in xrange(i + 1, len(s)):
            dp[i][j] = (s[i] == s[j]) and (j == i + 1 or dp[i + 1][j - 1])
            if dp[i][j] and j - i + 1 > local_max:
                ret = s[i : j + 1]
                local_max = j - i + 1

    return ret
*/
