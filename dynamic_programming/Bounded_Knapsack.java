/*Bounded_Knapsack

Classic dynamic programming.

Given items weight [1, 2, 3, 4, ...n] (unit: kilogram), and given a knapsack
which can hold only k kilogram. How many ways are there to exactly fill your
knapsack (weights of all items sumed up to k). And Each Item can be used only
once. How many ways are there to fill the knapsack at its maximum weight limit?


Followup:
Given a set of items, each with a weight and a value, determine the number of
each item to include in a collection so that the total weight is less than or
equal to a given limit and the total value is as large as possible?
*/


import java.util.*;


class Knapsack{
    public static void main(String[] args) {
        System.out.println(number(new int[] {1,2,3,4,5}, 6));
    }

    public static int value(int[] weight, int[] value, int k) {
        // Followup.
        // Init state: dp[0][0] = 0
        // dp[i, w] = dp[i-1, w] if weight[i] > w
        //            max(dp[i-1, w], dp[i-1, w - weight[i]] + value[i]) else
        assert(weight.length == value.length);
        int n = weight.length, i, j, curWeight, curVal;
        int[][] dp = new int[n + 1][k + 1];
        for (i = 1; i <= n; ++i) {
            curWeight = weight[i - 1];
            curVal = value[i - 1];
            for (j = 1; j <= k; ++j) {
                if (curWeight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - curWeight] + curVal);
                }
            }
        }
        printMatrix(dp);
        return dp[n][k];
    }

    public static int number(int[] arr, int k) {
        // dp[i, w] represent how many way arr[0:i] can add up to w.
        // Init state: dp[0, 0] = 1;
        // dp[i, w] = dp[i-1, w] if arr[i] > w
        //            dp[i-1, w] + dp[i-1, w-arr[i]] else
        int n = arr.length, i, j, cur;
        int[][] dp = new int[n + 1][k + 1];
        for (i = 0; i <= n; ++i) {
            dp[i][0] = 1;
        }
        for (i = 1; i <= n; ++i) { // index of arr.
            cur = arr[i - 1];
            for (j = 1; j <= k; ++j) { // Sum.
                if (cur > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - cur];
                }
            }
        }
        printMatrix(dp);
        return dp[n][k];
    }

    // Helper function.
    public static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }

    public static void printMatrix(int[][] m) {
        for (int[] i : m) printArray(i);
        System.out.println();
    }
}
