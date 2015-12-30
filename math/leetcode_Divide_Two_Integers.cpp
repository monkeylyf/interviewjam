/*
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode divide two integers
 */

#include <stdio.h>
#include <stdlib.h>
#include <limits>

using std::numeric_limits;


class Solution {
 public:
  int divide(int dividend, int divisor) {
    // Some edge cases given the nature of dividing.
    if (divisor == 0) {
      throw -1;  // Divide by zero error.
    }

    if (divisor == 1) {
      return dividend;
    }

    if (dividend == divisor) {
      return 1;
    }

    if (dividend == 0) {
      return 0;
    }

    if (dividend == numeric_limits<int>::min() && divisor == -1) {
      return numeric_limits<int>::max();
    }

    // Hanlde int overflow caused by abs.
    if (divisor == numeric_limits<int>::min()) {
      return 0;
    }

    if (dividend == numeric_limits<int>::min()) {
      // using a / b == (a + b) / b - 1 to make sure a + b is not MIN_INT.
      if (divisor > 0) {
        return divide(dividend + divisor, divisor) - 1;
      }
      if (divisor < 0) {
        return divide(dividend - divisor, divisor) + 1;
      }
    }

    bool negative = (dividend > 0 && divisor < 0) || (dividend < 0  && divisor > 0);

    long dividendLong = abs(dividend);
    long divisorLong = abs(divisor);

    int binaryDigits = 0;

    // Find out the max num of digits in binary.
    while (divisorLong << (binaryDigits + 1) <= dividendLong) {
      ++binaryDigits;
    }

    int res = 0;

    // Substracting in term of binary
    while (binaryDigits >= 0) {
      long substractor = divisorLong << binaryDigits;
      if (substractor <= dividendLong) {
        res = res + (1 << binaryDigits);
        dividendLong -= substractor;
      }
      --binaryDigits;
    }

    return negative ? -res : res;
  }
};


int main() {
  Solution sol;
  int res = sol.divide(2147483647, 2);
  printf("Result: %d\n", res);
}
