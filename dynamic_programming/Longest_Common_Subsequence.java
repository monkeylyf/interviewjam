/*Longest_Common_Subsequence

Input:
ABCDGH
AEDFHR
Output:
3
*/


class Longest_Common_Subsequence {
    public static void main(String[] args) {
        System.out.println(LCS("ABCDGH", "AEDFHR"));
    }

    public static int LCS(String a, String b) {
        // Time complexity O(mn)
        // Space complexity O(m)
        int n = a.length(), m = b.length(), i, j;
        int[] dp = new int[m + 1], next;
        char curA, curB;
        for (i = 0; i < n; ++i) {
            next = new int[m + 1];
            curA = a.charAt(i);
            for (j = 0; j < m; ++j) {
                curB = b.charAt(j);
                if (curA == curB) {
                    next[j + 1] = dp[j] + 1;
                } else {
                    next[j + 1] = Math.max(next[j], dp[j + 1]);
                }
            }
            dp = next;
        }
        return dp[m];
    }
}
