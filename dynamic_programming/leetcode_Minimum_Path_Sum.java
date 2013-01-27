/*Minimum_Path_Sum

Given a m x n grid filled with non-negative numbers, find a path from top left
to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
*/

class leetcode_Minimum_Path_Sum {
    public static void main(String[] args) {
    }
    public static int minPathSum(int[][] grid) {
        int[] cost = grid[0];
        int[] nextCost = grid[0];
        for (int i = 1; i < cost.length; ++i) cost[i] += cost[i - 1];
        for (int i = 1; i < grid.length; ++i) {
            nextCost[0] = grid[i][0] + cost[0];
            for (int j = 1; j < grid[i].length; ++j) {
                nextCost[j] = Math.min(cost[j], nextCost[j - 1]) + grid[i][j];
            }
            cost = nextCost;
        }
        return nextCost[nextCost.length - 1];
    }
}
