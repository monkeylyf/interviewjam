/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode majority element
 */


#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  int majorityElement(vector<int>& nums) {
    if (nums.size() == 0) {
      throw 1;
    }

    int count = 1;
    int majority_element = nums[0];

    for (int i = 1; i < nums.size(); ++i) {
      if (nums[i] == majority_element) {
        ++count;
      } else {
        if (count > 0) {
          --count;
        } else {
          majority_element = nums[i];
          count = 1;
        }
      }
    }

    return majority_element;
  }
};


int main() {
  Solution sol;
  vector<int> nums {2, 2, 1, 1, 2};
  int res = sol.majorityElement(nums);

  printf("Results: %d\n", res);
}
