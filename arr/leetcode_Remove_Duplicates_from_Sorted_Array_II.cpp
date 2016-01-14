/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode remove duplicates from sorted array II
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

    int idx = 1;
    int dup_count = 0;
    for (int i = 1; i < nums.size(); ++i) {
      if (nums[i - 1] != nums[i]) {
        nums[idx] = nums[i];
        ++idx;
        dup_count = 0;
      } else {
        ++dup_count;
        if (dup_count <= 1) {
          nums[idx] = nums[i];
          ++idx;
        }
      }
    }
    return idx;
  }
};


int main() {
  Solution sol;
  vector<int> nums {1, 1, 1, 2, 2, 2, 3, 3, 3, 3};
  int idx = sol.removeDuplicates(nums);

  for (int i = 0; i < idx; ++i) {
    printf("%d ", nums[i]);
  }
  printf("\n");
}

