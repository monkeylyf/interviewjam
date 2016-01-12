/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode minimum path sum
 */


#include <stdio.h>
#include <stdlib.h>
#include <vector>

using std::vector;


class Solution {
 public:
  int minPathSum(vector<vector<int>>& grid) {
    int n = grid.size();
    int m = grid[0].size();

    vector<int> prev (grid[0].begin(), grid[0].end());
    for (int i = 1; i < m; ++i) {
      prev[i] += prev[i - 1];
    }
    vector<int> dp (m, 0);

    for (int i = 1; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (j == 0) {
          dp[j] = prev[j] + grid[i][j];
        } else {
          dp[j] = std::min(prev[j], dp[j - 1]) + grid[i][j];
        }
      }
      prev = dp;
    }

    return prev.back();
  }
};


int main() {
  Solution sol;
  vector<vector<int>> grid {
    {1, 3, 1},
    {1, 5, 1},
    {4, 2, 1},
  };
  int res = sol.minPathSum(grid);
  printf("result: %d\n", res);
}
