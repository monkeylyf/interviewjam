/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode first missing positive
 */

#include <stdio.h>
#include <vector>

using std::vector;


void printVector(const vector<int>& v) {
  for (int val : v) {
    printf("%d ", val);
  }
  printf("\n");
}

class Solution {
 public:
  /**
   * The space O(1) and time O(n) solution is tricky.
   *
   * For a perfect sorted array like {1, 2, 3, 4}, where arr[i] = i + 1,
   * every one element belongs to its cell with the best effort. That being
   * said, {1, -4, 7, 4} is also a perfect array because: both -4 and 7 is
   * out of range.
   * With such kind of arrays, the only thing needs to be done is to scan
   * from left to right and find the first element that arr[i] =! i + 1
   *
   * The problem is how to rearrange a random array into such 'perfect' form?
   * We swap.
   * Keep swaping it where it belongs until until arr[i] belongs to i,
   * Avoid to swap two same values because it causes infinite loop.
   */
  int firstMissingPositive(vector<int>& nums) {
    int len = nums.size();
    for (int i = 0; i < len; ++i) {
      int belonging_idx = nums.at(i) - 1;
      while (0 <= belonging_idx &&
             belonging_idx < len &&
             nums.at(i) != nums.at(belonging_idx)) {
        swap(&nums, i, belonging_idx);
        belonging_idx = nums.at(i) - 1;
      }
    }

    int idx = 0;
    while (idx < len && idx == nums.at(idx) - 1) {
      ++idx;
    }

    return idx + 1;
  }

  void swap(vector<int>* nums, int i, int j) {
    int tmp = nums->at(i);
    (*nums)[i] = nums->at(j);
    (*nums)[j] = tmp;
  }
};


int main() {
  Solution sol;

  vector<int> nums {3, 4, -1, 1};
  int res = sol.firstMissingPositive(nums);

  printf("result: %d\n", res);
}
