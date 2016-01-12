/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode sort colors
 */

#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  /**
   * Three pointer. one for zeros idx, one for twos idx. last one for cursor
   * if 0, swap cursor and zeros idx. move both cursor and zeros idx forward
   * if 1, just move cursor forward
   * if 2, swap cursor and twos idx, move cursor forward and twos idx backward.
   */
  void sortColors(vector<int>& nums) {
    int zero_idx = 0;
    int two_idx = nums.size() - 1;
    int i = 0;
    while (i  <= two_idx) {
      if (nums[i] == 0) {
        swap(&nums, i, zero_idx);
        ++i;
        ++zero_idx;
      } else if (nums[i] == 1) {
        ++i;
      } else if (nums[i] == 2) {
        swap(&nums, i, two_idx);
        --two_idx;
      } else {
        throw 1;
      }
    }
  }

  void swap(vector<int>* nums, int i, int j) {
    int tmp = (*nums)[i];
    (*nums)[i] = (*nums)[j];
    (*nums)[j] = tmp;
  }
};


void printVector(const vector<int>& v) {
  for (int val : v) {
    printf("%d ", val);
  }
  printf("\n");
}


int main() {
  Solution sol;

  //vector<int> nums {1, 2, 0, 1, 2, 2, 1, 0};
  vector<int> nums {1, 0};

  printf("Before:\n");
  printVector(nums);
  sol.sortColors(nums);
  printf("After:\n");
  printVector(nums);
}
