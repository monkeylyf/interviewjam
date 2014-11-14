/**
 * Minimum_Number_Of_Square_Sum.
 *
 * Given a positive integer n, it can be the sum of several square number.
 * Find out the minimum number of square number that can be the sum of it.
 *
 * Hint: four square sum theorem can make it O(n) time complexity.
 */

import java.util.Arrays;

public class Minimum_Number_Of_Square_Sum {

  public static void main(String[] args) {
    Minimum_Number_Of_Square_Sum solution = new Minimum_Number_Of_Square_Sum();
    System.out.println(solution.solve(10));
  }

  /**
   * Standard DP solution.
   *
   * O(n ** 1.5) time complexity.
   */
  public int solve(int n) {
    int[] dp = new int[n + 1];
    for (int i = 0; i <= n; ++i) {
      if (isSquare(i)) {
        dp[i] = 1;
      } else {
        int root = squareRoot(i);
        int localMin = Integer.MAX_VALUE;
        for (int j = 1; j <= root; ++j) {
          localMin = Math.min(localMin, dp[i - j * j] + 1);
        }
        dp[i] = localMin;
      }
    }

    return dp[n];
  }

  private int squareRoot(int n) {
    return (int) Math.sqrt(n);
  }

  private boolean isSquare(int n) {
    int root = squareRoot(n);

    return root * root == n;
  }
}

