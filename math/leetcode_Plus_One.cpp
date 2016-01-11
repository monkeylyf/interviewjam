/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode plus one
 */

#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  vector<int> plusOne(vector<int>& digits) {
    bool carry = false;

    for (int i = digits.size() - 1; i >= 0; --i) {
      int digit = digits[i] + (i == digits.size() - 1 ? 1 : 0) + (carry ? 1 : 0);
      digits[i] = digit % 10;
      carry = digit >= 10;
    }

    if (carry) {
      digits.insert(digits.begin(), 1);
    }

    return digits;
  }
};


int main() {
  Solution sol;
  vector<int> digits {9, 9, 9, 9};
  vector<int> res = sol.plusOne(digits);

  for (int val : res) {
    printf("%d ", val);
  }
  printf("\n");
}
