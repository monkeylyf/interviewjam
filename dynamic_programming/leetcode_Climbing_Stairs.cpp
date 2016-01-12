/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode climbing stairs
 */

#include <stdio.h>


class Solution {
 public:
  /**
   * Ok, this is basically fibonacci seq.
   */
  int climbStairs(int n) {
    if (n <= 1) {
      return 1;
    }

    int prev = 1;
    int prev_prev = 0;
    for (int i = 1; i <= n; ++i) {
      int cur = prev + prev_prev ;
      prev_prev = prev;
      prev = cur;
    }

    return prev;
  }
};


int main() {
  Solution sol;
  for (int n = 0; n < 11; ++n) {
    int res = sol.climbStairs(n);
    printf("%d:  %d\n", n, res);
  }
}
