/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode scamble string
 */

#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <vector>

using std::string;
using std::vector;
using std::min;


class Solution {
 public:
  /**
   * dp[i][j][k] represents if s1.substr(i, k) is scramble of s2.substr(j, k)
   * Then dp[0][0][n] is what we want eventually.
   * Down-to-top. Staring from i = j = n - 1. k = 1.
   */
  bool isScramble(string s1, string s2) {
    int n = s1.length();

    vector<vector<vector<bool>>> dp = vector<vector<vector<bool>>> (
      n, vector<vector<bool>> (n, vector<bool> (n + 1, false))
    );

    for (int i = n - 1; i >= 0; --i) {
      for (int j = n - 1; j >= 0; --j) {
        for (int k = 1; k <= min(n - i, n - j); ++k) {
          if (s1.substr(i, k) == s2.substr(j, k)) {
            dp[i][j][k] = true;
          } else {
            bool found_scamble = false;
            for (int l = 1; l < k && !found_scamble; ++l) {
              if ((dp[i][j][l] && dp[i + l][j + l][k - l]) ||
                  (dp[i][j + k - l][l] && dp[i + l][j][k - l])) {
                found_scamble = true;
                dp[i][j][k] = true;
              }
            }
          }
        }
      }
    }

    return dp[0][0][n];
  }
};


int main() {
  Solution sol;
  bool res = sol.isScramble("rgtae", "great");
  printf("result: %c\n", res ? 't' : 'f');
}
