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

/* Python Version

def minPathSum(self, grid):
    if not grid:
        return 0
        
    n = len(grid)
    m = len(grid[0])
    
    dp = [ 0 ] * m
    for i in xrange(m):
        dp[i] = grid[0][0] if i == 0 else dp[i - 1] + grid[0][i]
    
    for i in xrange(1, n):
        nex = [ 0 ] * m
        nex[0] = dp[0] + grid[i][0]
        for j in xrange(1, m):
            nex[j] = min(nex[j - 1], dp[j]) + grid[i][j]
        dp = nex

    return dp[-1]
*/
