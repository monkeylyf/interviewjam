/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode pow
 */

#include <stdio.h>


class Solution {
 public:
  double myPow(double x, int n) {
    double ret = 1.0;
    bool is_neg = false;

    if (n < 0) {
      is_neg = true;
      n = -n;
    }

    while (n > 0) {
      if (n % 2 == 1) {
        ret *= x;
      }
      n = n / 2;
      x = x * x;
    }

    return is_neg ? 1 / ret : ret;
  }
};


int main() {
  Solution sol;
  double res = sol.myPow(-2, 3);

  printf("result: %f\n", res);
}
