/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode maximum subarray
 */

#include <stdio.h>
#include <limits>
#include <vector>

using std::vector;
using std::numeric_limits;


class Solution {
 public:
  int maxSubArray(vector<int>& nums) {
    if (nums.size() == 0) {
      throw 1;
    }

    int all_neg = true;
    int max_element = numeric_limits<int>::min();
    int max = nums[0];
    int acc = 0;

    for (int i = 0; i < nums.size(); ++i) {
      // Accumulated max.
      acc += nums[i];
      if (acc < 0) {
        acc = 0;
      }
      max = std::max(max, acc);

      // Individual max.
      max_element = std::max(max_element, nums[i]);
      if (all_neg && nums[i] >= 0) {
        all_neg = false;
      }
    }

    return (all_neg) ? max_element : max;
  }
};


int main() {
  Solution sol;
  vector<int> nums {-2, 1};
  int res = sol.maxSubArray(nums);
  printf("result: %d\n", res);
}
