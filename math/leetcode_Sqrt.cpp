/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode sqrt
 */

#include <stdio.h>


class Solution {
 public:
  int mySqrt(int x) {
    int root = x;
    while (root * root > x) {
      root = (root + x / root) / 2;
    }
    return root;
  }

  int mySqrtSlow(int x) {
    if (x == 0) {
      return 0;
    }
    int root = 1;
    bool found = false;
    while (!found) {
      if (root <= x / root && root + 1 > x / (root + 1)) {
        // root ^ 2 <= x && (root + 1) ^ 2 > x, root is the answer.
        found = true;
      } else if (x / root >= 4 * root) {
        root *= 2; // x > (2 * root) ^ 2, base can be doubled.
      } else {
        ++root; // (root + 1)^ 2 < x < (2 * root) ^ 2. Very closed.
      }
    }
    return root;
  }
};


int main() {
  Solution sol;
  int root = sol.mySqrt(4);
  printf("result: %d\n", root);
}
