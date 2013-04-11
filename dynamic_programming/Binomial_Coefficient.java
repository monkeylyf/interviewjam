/*Binomial_Coefficient

Given n, k, return C(n, k)
*/


class Binomial_Coefficient {
    public static void main(String[] args) {
        solve(5 ,2);
        optSolve(5, 2);
    }

    public static void solve(int n, int k) {
        // DP: C(n, k) = C(n - 1, k - 1) + C(n - 1, k)
        // C(n, 0) = C(n, n) = 1
        // Time complexity O(nk), space complexityO(nk)
        int[][] dp = new int[n + 1][k + 1];
        int i, j;
        for (i = 0; i <= n; ++i) {
            for (j = 0; j <= Math.min(i, k); ++j) {
                dp[i][j] = (j == 0 || j == i) ? 1 : dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        System.out.println(dp[n][k]);
    }
    
    public static void optSolve(int n, int k) {
        // Time complexity O(nk), space complexity O(k).
        // since status of dp[i][j] is only related to dp[i-1][x]
        // we can optimized the status matrix to status array.
        int[] dp = new int[k + 1];
        dp[0] = 1;
        int i, j;
        for (i = 1; i <= n; ++i) {
            printArray(dp);
            for (j = Math.min(i, k); j > 0; --j) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        printArray(dp);
        System.out.println(dp[k]);
    }
    
    public static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
    
    public static void printMmatrix(int[][] m) {
        for (int[] i : m) printArray(i);
        System.out.println();
    }
}
