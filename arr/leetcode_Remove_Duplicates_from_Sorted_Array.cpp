/*
 * Copyright 2015
 * Author: madarfacar
 *
 * leetcode remove duplicates from sorted array
 */

#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  int removeDuplicates(vector<int>& nums) {
    if (nums.size() <= 1) {
      return nums.size();
    }
    int noDupIdx = 1;
    for (int j = 1; j < nums.size(); ++j) {
      if (nums.at(j) != nums.at(j - 1)) {
        nums[noDupIdx] = nums[j];
        ++noDupIdx;
      }
    }
    return noDupIdx;
  }
};


int main() {
  Solution sol;
  vector<int> nums {1, 1, 2};
  //vector<int> nums {1, 2};

  int res = sol.removeDuplicates(nums);
  printf("Result: %d\n", res);
}
