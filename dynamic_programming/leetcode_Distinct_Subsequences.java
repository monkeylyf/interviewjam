/*Distinct_Subsequences
leetcode

Given a string S and a string T, count the number of distinct subsequences of
T in S.
A subsequence of a string is a new string which is formed from the original
string by deleting some (can be none) of the characters without disturbing the
relative positions of the remaining characters. (ie, "ACE" is a subsequence of
"ABCDE" while "AEC" is not).
Here is an example:
S = "rabbbit", T = "rabbit"
Return 3.

Explanation:
The body of this question confuses me a lot.
Count how many distinct subsequence of S is equal to T.
S has such subsequence "rabb_it", "rab_bit" and "ra_bbit" which equals to T.
*/

class leetcode_Distinct_Subsequences {
    public static void main(String[] args) {
        //numDistinct("ccc", "c");
	//numDistinct("rabbbit", "rabbit");
	num("rabbbit", "rabbit");
    }
    public static int numDistinct(String S, String T) {
        //C(S, T) = C( S.substr(len-1), T.substr(len-1) ) +
	//          C( S.substr(len-1), T )
	// explanation:
	// for each char, there are two states: use it or not.
	// if last char of two string are equal, use it + not use it.
	// if not equal, inherit dp state.
	int i, j, t = T.length(), s = S.length();
        int[] dp = new int[t];
        for (i = 0; i < s; ++i) {
            for (j = t - 1; j >= 0; --j) {
                if (S.charAt(i) == T.charAt(j)) {
		    if (j == 0) {
			dp[0] = dp[0] + 1;
		    } else {
                    	dp[j] = dp[j] + dp[j - 1];
		    }
                }
            }
	    print(dp);
        }
        return dp[t - 1];
    }

    public static int num(String S, String T) {
	// This way we need two dp state array to track but for loop logic is more clear.
	// The method above use only one dp state array.
	int i, j, t = T.length(), s = S.length();
        int[] dp = new int[t], next;
        for (i = 0; i < s; ++i) {
	    next = new int[t];
            for (j = 0; j <= i && j < t; ++j) {
                if (S.charAt(i) == T.charAt(j)) {
		    if (j == 0) {
			next[0] = dp[0] + 1;
		    } else {
                    	next[j] = dp[j] + dp[j - 1];
		    }
                } else {
		    next[j] = dp[j];
		}
            }
	    dp = next;
	    print(dp);
        }
        return dp[t - 1];
    }

    public static void print(int[] arr) {
    	for (int i : arr) System.out.print(i + " ");
	System.out.println();
    }
}
