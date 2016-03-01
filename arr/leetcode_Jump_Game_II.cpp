/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode jump game II
 */

#include <stdio.h>
#include <stdlib.h>
#include <limits>
#include <vector>

using std::vector;
using std::numeric_limits;


class Solution {
 public:
  /**
   * The backtrace dp has O(n^2) time complexity, won't pass OJ.
   *
   * The better solution has O(1) time complexity
   * Keep tracking the max distance you can reach from current location,
   * and max distance previous jump can reach. When you current location is
   * far beyong your previous jump can reach, you need to jump.
   */
  int jump(vector<int>& nums) {
    int cur_jump_max_reach = 0;
    int prev_jump_max_reach = 0;
    int num_of_jumps = 0;
    for (int i = 0; i < nums.size(); ++i){
      if (i > prev_jump_max_reach) {
        prev_jump_max_reach = cur_jump_max_reach;
        ++num_of_jumps;
      }
      cur_jump_max_reach = std::max(cur_jump_max_reach, i + nums.at(i));
    }
    return num_of_jumps;
  }
};



int main() {
  Solution sol;
  //                2  4  3  4  8
  vector<int> nums {2, 3, 1, 1, 4};
  //vector<int> nums {0};
  int res = sol.jump(nums);
  printf("Result: %d\n", res);
}
