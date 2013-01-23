/*Distinct_Subsequences

Given a string S and a string T, count the number of distinct subsequences of
T in S.
A subsequence of a string is a new string which is formed from the original
string by deleting some (can be none) of the characters without disturbing the
relative positions of the remaining characters. (ie, "ACE" is a subsequence of
"ABCDE" while "AEC" is not).
Here is an example:
S = "rabbbit", T = "rabbit"
Return 3.
*/

class leetcode_Distinct_Subsequences {
    public static void main(String[] args) {
        numDistinct("ccc", "c");
    }
    public static int numDistinct(String S, String T) {
        int[] prev = new int[T.length() + 1];
        int[] next = new int[T.length() + 1];
        prev[0] = 1;
        for (int i = 0; i < S.length(); ++i) {
            next[0] = 1;
            for (int j = 0; j <= i && j < T.length(); ++j) {
                if (S.charAt(i) == T.charAt(j)) {
                    next[j + 1] = prev[j + 1] + prev[j];
                } else {
                    next[j + 1] = prev[j + 1];
                }
            }
            prev = next;
            next = new int[T.length() + 1];
        }
        return prev[next.length - 1];
    }
}
