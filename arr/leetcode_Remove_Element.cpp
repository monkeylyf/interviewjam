/*
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode remove element
 */

#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  int removeElement(vector<int>& nums, int val) {
    if (nums.size() == 0) {
      return 0;
    }

    int i = 0;

    for (int j = 0; j < nums.size(); ++j) {
      if (nums.at(j) != val) {
        nums[i] = nums[j];
        ++i;
      }
    }

    return i;
  }
};


int main() {
  Solution sol;

  vector<int> nums {1, 2, 2, 3, 4};

  int res = sol.removeElement(nums, 2);
  for (int i = 0; i < res; ++i) {
    printf("%d ", nums.at(i));
  }
  printf("\n");
  printf("result: %d\n", res);
}
