/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode edit distance
 */

#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <vector>

using std::string;
using std::vector;


class Solution {
 public:
  int minDistance(string word1, string word2) {
    vector<int> prev (word2.length() + 1, 0);
    vector<int> dp (word2.length() + 1, 0);
    for (int i = 0; i <= word2.length(); ++i) {
      prev[i] = i;
    }

    for (int i = 0; i < word1.length(); ++i) {
      dp[0] = i + 1;
      for (int j = 1; j <= word2.length(); ++j) {
        if (word1[i] == word2[j - 1]) {
          dp[j] = prev[j - 1];
        } else {
          // Update operation: prev[j - 1] -> dp[j]
          // Insert operation: prev[j] -> dp[j] or dp[j - 1] -> dp[j]
          dp[j] = std::min(prev[j - 1], std::min(prev[j], dp[j - 1])) + 1;
        }
      }
      prev = dp;
    }
    return prev.back();
  }
};


int main() {
  Solution sol;
  int min_dist = sol.minDistance("git", "shit");
  printf("result: %d\n", min_dist);
}
