/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode unique binary search trees
 */

#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  int numTrees(int n) {
    if (n < 0) {
      throw 1;
    }
    if (n <= 2) {
      return n;
    }

    vector<int> dp (n + 1, 0);
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; ++i) {
      dp[i] = 2 * dp[i - 1];
      for (int j = 2; j < i; ++j) {
        dp[i] += dp[j - 1] * dp[i - j];
      }
    }

    return dp.back();
  }
};


int main() {
  Solution sol;
  for (int i = 0; i < 10; ++i) {
    printf("i: %d num: %d\n", i, sol.numTrees(i));
  }
}
