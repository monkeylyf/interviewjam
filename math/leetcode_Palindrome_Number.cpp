/*
 * Copyright 2015
 *
 * leetcode palindrome number
 */

#include <stdio.h>
#include <limits>

using std::numeric_limits;


class Solution {
 public:
  bool isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    int val = x;
    int digit = 0;

    while (val > 0) {
      val = val / 10;
      ++digit;
    }

    int left = digit;
    int right = 1;

    while (left > right) {
      int left_digit = getDigit(x, left);
      int right_digit = getDigit(x, right);
      if (getDigit(x, left) != getDigit(x, right)) {
        return false;
      }
      --left;
      ++right;
    }

    return true;
  }

  int getDigit(int x, int index) {
    int numerator = 1;
    for (int i = 0; i < index; ++i) {
      if (numerator > numeric_limits<int>::max() / 10) {
        return x / numerator;
      }
      numerator *= 10;
    }

    return (x % numerator) / (numerator / 10);
  }
};


int main() {
  Solution sol;
  bool res = sol.isPalindrome(1000000001);
  printf("result: %s\n", (res) ? "True" : "False");
}
