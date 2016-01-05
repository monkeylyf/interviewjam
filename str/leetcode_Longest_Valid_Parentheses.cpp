/*
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode longest valid parentheses
 */

#include <stdio.h>
#include <algorithm>
#include <string>

using std::string;
using std::max;
using std::min;


class Solution {
 public:
  int longestValidParentheses(string s) {
    int ret = 0;
    int left_paren = 0;
    int right_paren = 0;

    // Scan from left to right.
    for (int i = 0; i < s.length(); ++i) {
      if (s[i] == '(') {
        left_paren += 1;
      } else if (s[i] == ')') {
        right_paren += 1;
      } else {
        throw -1;
      }

      if (left_paren == right_paren) {
        // Update global max.
        ret = max(ret, left_paren + right_paren);
      } else if (right_paren > left_paren) {
        // Reset.
        right_paren = 0;
        left_paren = 0;
      } else {
        // Do nothing.
      }
    }

    // Reset.
    right_paren = 0;
    left_paren = 0;
    for (int i = s.length() - 1; i >= 0; --i) {
      if (s[i] == '(') {
        left_paren += 1;
      } else if (s[i] == ')') {
        right_paren += 1;
      } else {
        throw -1;
      }
      if (left_paren == right_paren) {
        // Update global max.
        ret = max(ret, left_paren + right_paren);
      } else if (left_paren > right_paren) {
        // Reset.
        right_paren = 0;
        left_paren = 0;
      } else {
        // Do nothing.
      }
    }

    return ret;
  }
};


int main() {
  Solution sol;

  int res = sol.longestValidParentheses("()(()");
  printf("result: %d\n", res);
}
