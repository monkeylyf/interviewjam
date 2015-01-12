/**
 * Maximum_Submatrix.
 * careercup.
 *
 * Given an NxN matrix of positive and negative integers, write code to find the
 * sub-matrix with the largest possible sum
 */

public class cap_Maximum_Submatrix {

  public static void main(String[] args) {
    cap_Maximum_Submatrix solution = new cap_Maximum_Submatrix();
    solution.test();
  }

  public void test() {
    // test case 1.
    int[][] input = {
      {1, 2, -3},
      {3, -2, 1},
      {1, -1, 1}};
    //System.out.println(getMaxMatrix(input));

    // test case 2.
    int[][] input1 = {
      {1,  1,  1},
      {-1, -1, -1},
      {-2, -2, -2}};
    //System.out.println(getMaxMatrix(input1));

    // test case 3.
    int[][] input2 = {{1, 2, -3},
      {3, -2, 1},
      {1, -1, 1},
      {3, 0, 4}};
    //System.out.println(getMaxMatrix(input2));

    // test case 4.
    int[][] input3 = {
      {1, 2, -1, -4, -20},
      {-8, -3, 4, 2, 1},
      {3, 8, 10, 1, 3},
      {-4, -1, 1, 7, -6},
    };
    System.out.println(getMaxMatrix(input3));
  }

  /** Dynamic programming.
   *
   * Brutal force: O(n^6).
   * O(n^4) to traversal all possible submatrix and O(n^2) to compute the sum
   *
   * O(n^3) as follow
   */
  public int getMaxMatrix(int[][] mtx) {
    int n = mtx.length;
    int m = mtx[0].length;
    int max = 0;
    for (int i = 0; i < n; ++i) {
      int[] accumulator = new int[m];
      for (int j = i; j < n; ++j) {
        // Given the submatrix with upper bound i and lower bound j,
        // calculate the maximum sum.
        for (int it = 0; it < m; ++it) {
          accumulator[it] += mtx[j][it]; // accumulator the value along y axis.
        }

        max = Math.max(max, maxSumOfArray(accumulator));
      }
    }

    return max;
  }

  /**
   * Paradigm: Maximum subarray.
   */
  private int maxSumOfArray(int[] arr) {
    int max = 0;
    int sum = 0;
    for (int i = 0; i < arr.length; ++i) {
      sum += arr[i];
      if (sum > max) {
        max = sum;
      } else if (sum < 0) {
        sum = 0;
      } else {
        continue;
      }
    }

    return max;
  }
}
