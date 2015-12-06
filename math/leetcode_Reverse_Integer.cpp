/*
 * Copyright 2015
 *
 * leetcode reverse integer
 */

#include <stdio.h>
#include <limits>


class Solution {
 public:
  int reverse(int x) {
    if (x == std::numeric_limits<int>::min()) {
      // -2147483648 can not even do abs.
      return 0;
    }
    bool is_neg = x < 0;
    bool overflow = false;
    int divident = 10;
    int ret = 0;

    // abs value.
    if (is_neg) {
      x = -x;
    }

    while (!overflow && x > 0) {
      int digit = x % divident;
      if (ret > std::numeric_limits<int>::max() / divident) {
        // Check if shifting will cause overflow.
        overflow = true;
      }
      ret = ret * divident + digit;
      x = x / divident;
    }

    if (overflow) {
      return 0;
    } else {
      return (is_neg) ? -ret : ret;
    }
  }
};


int main() {
  Solution sol;
  printf("result: %d\n", sol.reverse(1534236469));
}
