/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode unique path ))
 */

#include <stdio.h>
#include <vector>

using std::vector;

class Solution {
 public:
   int uniquePathsWithObstacles(const vector<vector<int>>& obstacleGrid) {
    int n = obstacleGrid.size();
    int m = obstacleGrid[0].size();

    vector<int> prev (m, 0);
    vector<int> dp (m, 0);
    for (int i = 0; i < m; ++i) {
      if (obstacleGrid[0][i] == 1) {
        break;
      }
      prev[i] = 1;
    }

    for (int i = 1; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (obstacleGrid[i][j] == 1) {
          dp[j] = 0;
        } else if (j == 0) {
          dp[j] = prev[j];
        } else {
          dp[j] = prev[j] + dp[j - 1];
        }
      }
      prev = dp;
    }

    return prev.back();
  }
};


int main() {
  Solution sol;
  vector<vector<int>> obstacleGrid {
    {0, 0, 0},
    {0, 1, 0},
    {0, 0, 0},
  };
  int res = sol.uniquePathsWithObstacles(obstacleGrid);

  printf("Result: %d\n", res);
}
