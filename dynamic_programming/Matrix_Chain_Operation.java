/*Matrix_Chain_Operation
*/

class Matrix_Chain_Operation {

    /***
     * Given a sequence of matrices, find the most efficient way to multiply
     * these matrices together.
     * 
     * For example, suppose A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C
     * is a 5 × 60 matrix. Then,
     * 
     * (AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations A(BC) =
     * (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations. Clearly the
     * first method is the more efficient.
     * 
     * Given an array p[] which represents the chain of matrices such that the
     * ith matrix Ai is of dimension p[i-1] x p[i]. We need to write a function
     * MatrixChainOrder() that should return the minimum number of
     * multiplications needed to multiply the chain.
     * 
     * 
     * @param args
     */
    public static void main(String[] args) {
        solve(new int[] { 10, 30, 5, 60, 10 });
        //solve(new int[] { 1, 2, 3, 4 });
        System.out.println(solve(new int[] {10, 30, 5, 60}));
    }

    public static int solve(int[] dim) {
        int n = dim.length; // dim contains n - 1 matrixes.
        int[][] dp = new int[n][n];
        int i, j, k, L, q;
        for (L = 2; L < n; ++L) { // length of span.
            for (i = 1; i < n - L + 1; ++i) { // row 0 will not be used to make index easily understood.
                j = i + L - 1; // index of last in cur span.
                dp[i][j] = Integer.MAX_VALUE; // Set default to max for further min operation.
                for (k = i; k <= j - 1; ++k) {
                    // dp relationship:
                    // dp[i][j] = min(dp[i][k] + dp[k + 1][j] + dim[i - 1] * dim[k] * dim[j]) for all k in [i, j-1]
                    // @param dp[i][j]: min calculation operation from matrix i to matrix j.
                    // dim[i - 1] * dim[k] * dim[j]: the operation needed formatrix [i, k] multiplied by matrix[k + 1][j]
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + dim[i - 1] * dim[k] * dim[j]);
                }
            }
        }
        printMatrix(dp);
        return dp[1][n - 1];
    }

    public static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void printMatrix(int[][] m) {
        for (int[] i : m)
            printArray(i);
        System.out.println();
    }
}
