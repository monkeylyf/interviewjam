/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode search for a range.
 */

#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  vector<int> searchRange(const vector<int>& nums, int target) {
    int head = 0;
    int tail = nums.size() - 1;

    // Search left_boundary.
    int left_boundary = -1;
    bool found_left_boundary = false;
    while (!found_left_boundary && head <= tail) {
      int mid = (tail - head) / 2 + head;
      if (nums.at(mid) > target) {
        tail = mid - 1;
      } else if (nums.at(mid) < target) {
        head = mid + 1;
      } else {
        if (mid == 0 || nums.at(mid - 1) != target) {
          found_left_boundary = true;
          left_boundary = mid;
        } else {
          tail = mid - 1;
        }
      }
    }
    head = 0;
    tail = nums.size() - 1;

    // Search right_boundary.
    int right_boundary = -1;
    bool found_right_boundary = false;
    while (!found_right_boundary && head <= tail) {
      int mid = (tail - head) / 2 + head;
      if (nums.at(mid) > target) {
        tail = mid - 1;
      } else if (nums.at(mid) < target) {
        head = mid + 1;
      } else {
        if (mid == nums.size() - 1 || nums.at(mid + 1) != target) {
          found_right_boundary = true;
          right_boundary = mid;
        } else {
          head = mid + 1;
        }
      }
    }

    return vector<int> {left_boundary, right_boundary};
  }
};


int main() {
  Solution sol;

  vector<int> nums {7, 7, 8, 8};
  int target = 8;
  vector<int> pair = sol.searchRange(nums, target);

  printf("[%d, %d]\n", pair.at(0), pair.at(1));
}
