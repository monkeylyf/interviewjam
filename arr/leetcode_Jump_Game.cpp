/**
 * Copyright 2016
 * author: madarfacar
 *
 * 7:50pm
 *
 * leetcode jump game
 */

#include <stdio.h>
#include <stdlib.h>
#include <vector>

using std::vector;


class Solution {
 public:
  bool canJump(vector<int>& nums) {
    int max_reach_dist = 0;
    int i = 0;
    while (i < nums.size() && max_reach_dist >= i) {
      max_reach_dist = std::max(max_reach_dist, i + nums.at(i));
      if (max_reach_dist >= nums.size() - 1) {
        return true;
      }
      ++i;
    }

    return false;
  }
};


int main() {
  Solution sol;

  vector<int> nums {1, 0, 0, 0};
  bool res = sol.canJump(nums);

  printf("result: %c\n", res ? 't' : 'f');
}
