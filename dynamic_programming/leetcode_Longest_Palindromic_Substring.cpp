/*
 * Copyright 2015
 * Author: ouroboros
 *
 * leetcode Longest Palindromic Substring
 */

#include <stdio.h>
#include <string>

using std::string;


class Solution {
 public:
  string longestPalindrome(string s) {
    int length = s.size();
    if (length <= 1) {
      return s;
    }

    // Init dp state matrix. Note that default value is true when
    // you init a bool[][]
    bool dp[length][length];
    for (int i = 0; i < length; ++i) {
      for (int j = 0; j < length; ++j) {
        dp[i][j] = i == j;
      }
    }
    int localMax = 0;
    int ret_start = 0;
    int ret_end = 0;

    for (int span = 1; span <= length; ++span) {
      for (int start = 0; start + span < length; ++start) {
        int end = start + span;
        if (s[start] == s[end]) {
            dp[start][end] = (span == 1) ? true : dp[start + 1][end - 1];
        }
        if (dp[start][end] && end > localMax) {
          // Update local max variables.
          localMax = span;
          ret_start = start;
          ret_end = end;
        }
      }
    }

    return s.substr(ret_start, ret_end - ret_start + 1);
  }
};


int main() {
  Solution sol;
  string res = sol.longestPalindrome("bbc");
  printf("Result: %s\n", res.c_str());
  return 0;
}
