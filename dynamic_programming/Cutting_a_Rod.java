class Cutting_a_Rod {
    /*
     * Given a rod of length n inches and an array of prices that contains
     * prices of all pieces of size smaller than n. Determine the maximum value
     * obtainable by cutting up the rod and selling the pieces. For example, if
     * length of the rod is 8 and the values of different pieces are given as
     * following, then the maximum obtainable value is 22
     */
    public static void main(String[] args) {
        solve(new int[] { 0, 1, 5, 8, 9, 10, 17, 17, 20 }, 8);
    }

    public static void solve(int[] prices, int len) {
        // dp: dp[i] = max(dp[i - k] + prices[k]) for all k in [1, i - 1]
        int[] dp = new int[len + 1]; // prices[0] will not be used. prices[1] represents the price of length equal to 1.
        int i, j;
        for (i = 1; i < dp.length; ++i) {
            dp[i] = (i < prices.length) ? prices[i] : 0;
            for (j = 1; j < Math.min(i, prices.length); ++j) {
                dp[i] = Math.max(dp[i], dp[i - j] + prices[j]);
            }
        }
        printArray(dp);
        System.out.println(dp[dp.length - 1]);
    }

    public static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}
