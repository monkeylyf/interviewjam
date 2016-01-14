/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode decode ways
 */

#include <stdio.h>
#include <string>

using std::string;


class Solution {
 public:
  /**
   * 'A' -> 1
   * ...
   * 'Z' -> 26
   */
  int numDecodings(string s) {
    if (s.length() == 0 || s[0] == '0') {
      return 0;
    }
    int cur_char_dp = 1;
    int pre_char_dp = 1;
    for (int i = 1; i < s.length(); ++i) {
      // Check take two. 10 -> 19 || 20 -> 26.
      bool can_take_two = i > 0 &&
        ((s[i - 1] == '1') || (s[i - 1] == '2' && '0' <= s[i] && s[i] <= '6'));
      // Check take one. 1 -> 9.
      bool can_take_one = s[i] != '0';

      int new_cur_char_dp = 0;
      if (can_take_one) {
        if (can_take_two) {
          // Fibonacci...
          new_cur_char_dp = cur_char_dp + pre_char_dp;
        } else {
          new_cur_char_dp = cur_char_dp;
        }
      } else {
        if (can_take_two) {
          new_cur_char_dp = pre_char_dp;
        } else {
          return 0;
        }
      }
      pre_char_dp = cur_char_dp;
      cur_char_dp = new_cur_char_dp;
    }
    return cur_char_dp;
  }
};


int main() {
  Solution sol;
  int res = sol.numDecodings("227");
  printf("result: %d\n", res);
}
