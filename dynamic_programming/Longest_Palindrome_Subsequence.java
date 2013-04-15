/*Longest_Palindrome_Subsequence

*/

class Longest_Palindrome_Subsequence {
    public static void main(String[] args) {
        solve("BBABCBCAB");
    }
    
    public static void solve(String str) {
        int n = str.length(), L, i, j;
        int[][] dp = new int[n][n];
        char head, tail;
        // init state. For single char, the longest palindrome is the char itself.
        for (i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (L = 1; L <= n; ++L) { // down-to-top. L is the length of string.
            for (j = 0; j < n - L; ++j) { // j is head index of string.
                head = str.charAt(j);
                tail = str.charAt(j + L);
                //System.out.println("L " + L + " j " + j);
                if (head == tail) {
                    // if cur substring's tail equals head, find the longest palindrome subsequence [head + 1, tail -1]
                    dp[j][j + L] = dp[j + 1][j + L - 1] + 2;
                } else {
                    // if not, find the longest palindrome subsequence of [head, tail - 1] and [head + 1, tail]
                    dp[j][j + L] = Math.max(dp[j + 1][j + L], dp[j][j + L - 1]);
                }
            }
        }
        printMatrix(dp);
    }
    
    public static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
    
    public static void printMatrix(int[][] m) {
        for (int[] i : m) printArray(i);
        System.out.println();
    }
}
