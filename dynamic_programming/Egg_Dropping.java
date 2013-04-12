public class Egg_Dropping {
    /**
     * You are given k eggs and trying to know which floors are safe to drop
     * eggs. …..An egg that survives a fall can be used again. …..A broken egg
     * must be discarded. …..The effect of a fall is the same for all eggs.
     * …..If an egg breaks when dropped, then it would break if dropped from a
     * higher floor. …..If an egg survives a fall then it would survive a
     * shorter fall. …..It is not ruled out that the first-floor windows break
     * eggs, nor is it ruled out that the 36th-floor do not cause an egg to
     * break.
     */
    public static void main(String[] args) {
        //System.out.println(solve(2, 10));
        dp(2, 10);
    }
    
    public static int solve(int k, int n) {
        // @param: k eggs and n floors.
        // recursion based solution
        // if an egg breaks on floor x, then you have k - 1 eggs for floor 1 to floor x - 1
        // if an egg does not break on floor x, then you have k eggs for floor x + 1 to floor n.
        if (k == 1) { 
            // When you have only one egg left, you have to try one floor by on floor.
            return n;
        } else if (n == 1 || n == 0) {
            // On floor, one trial. No floor, zero trial.
            return n;
        }
        int min = Integer.MAX_VALUE, i, res;
        for (i = 1; i <= n; ++i) {
            res = Math.max(solve(k - 1, i - 1), solve(k, n - i)); // max: assume worst case.
            min = Math.min(min, res);
        }
        return min + 1;
    }
    
    public static void dp(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        int res, i, j, h;
        for (i = 1; i <= n; ++i) {
            dp[1][i] = i;
        }
        for (i = 1; i <= k; ++i) {
            dp[i][1] = 1;
        }
        for (i = 2; i <= k; ++i) {
            for (j = 2; j <= n; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for (h = 1; h <= j; ++h) {
                    res = Math.max(dp[i - 1][h - 1], dp[i][j - h]) + 1;
                    dp[i][j] = Math.min(dp[i][j], res);
                }
            }
        }
        printMatrix(dp);
        System.out.println(dp[k][n]);
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
