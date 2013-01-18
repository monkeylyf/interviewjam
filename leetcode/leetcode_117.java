/*Unique Paths II

Follow up for "Unique Paths":
Now consider if some obstacles are added to the grids. How many unique paths
would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.
For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]

The total number of unique paths is 2.
Note: m and n will be at most 100.
*/

class leetcode_117 {
    public static void main(String[] args) {
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev = new int[n];
        int[] next = new int[n];
        int fill = 1;
        for (int i = 0; i < n; ++i) {
            if (obstacleGrid[0][i] == 1) {
                fill = 0;
            }
            prev[i] = fill;
        }
        for (int i = 1; i < m; ++i) {
            for (int j  = 0; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    next[j] = 0;
                } else if (j == 0) {
                    next[j] = prev[j];
                } else {
                    next[j] = next[j - 1] + prev[j];
                } 
            }
            prev = next;
            next = new int[n];
        }
        return prev[prev.length - 1];
    }
}
