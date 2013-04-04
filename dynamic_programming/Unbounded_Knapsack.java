/*Unbounded_Knapsack

Given a set of items, each with a weight and a value, determine the number of
each item to include in a collection so that the total weight is less than or
equal to a given limit and the total value is as large as possible.
For each item you have infinite instances.
*/


class Unbounded_Knapsack {
    public static void main(String[] args) {
      
    }
    public static int unbounded(int[] weight, int[] value, int k) {
        // init state: dp[0] = 0
        // dp[i] = max(dp[i - weight[j]] + value[j]) for all weight[j] <= i.
        assert (weight.length == value.length);
        int n = weight.length, i, j;
        int[] dp = new int[k + 1];
        for (i = 1; i <= k; ++i) { // Sum
            for (j = 0; j < n; ++j) { // index of weight
                if (weight[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }
        printArray(dp);
        return dp[k];
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
