/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode unique path
 */

#include <stdio.h>
#include <vector>

using std::vector;

class Solution {
 public:
  int uniquePaths(int m, int n) {
    vector<int> prev (n, 1);
    vector<int> dp (n, 0);

    for (int i = 1; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (j == 0) {
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
  //int res = sol.uniquePaths(36, 7);
  int res = sol.uniquePaths(3, 3);

  printf("Result: %d\n", res);
}
