/**
 * The Floyd Warshall Algorithm.
 *
 * The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path
 * problem. The problem is to find shortest distances between every pair of
 * vertices in a given edge weighted directed Graph.
 */

public class Floyd_Warshall_Algo {

  public static void main(String[] args) {
    solve(new int[][] { {0,    5,    9999, 10},
                        {9999, 0,    3,    9999},
                        {9999, 9999, 0,    1},
                        {9999, 9999, 9999, 0} });
  }

  /**
   * Time complexity O(n^3) and Space complexity O(n^2).
   */
  public static void solve(int[][] graph) {
    int n = graph.length;
    int[][] shortest = new int[n][n];
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        shortest[i][j] = graph[i][j];
      }
    }
    printMatrix(shortest);
    for (int i = 0; i < n; ++i) {
      // Connecting points. i to j => i to k then k to j
      for (int j = 0; j < n; ++j) { // starting point
        for (int k = 0; k < n; ++k) { // destination point
          shortest[j][k] = (shortest[j][i] + shortest[i][k] < shortest[j][k]) ? shortest[j][i]
            + shortest[i][k]
            : shortest[j][k];
        }
      }
    }
    printMatrix(shortest);
  }

  public static void printArray(int[] arr) {
    for (int i : arr) { System.out.print(i + " "); }
    System.out.println();
  }

  public static void printMatrix(int[][] m) {
    for (int[] i : m) { printArray(i); }
    System.out.println();
  }
}
