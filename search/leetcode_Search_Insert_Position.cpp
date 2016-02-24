/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode search insert position
 */

#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  int searchInsert(const vector<int>& nums, int target) {
    int head = 0;
    int tail = nums.size() - 1;
    int idx = -1;

    while (idx == -1 && head <= tail) {
      int mid = (tail - head) / 2 + head;
      if (nums.at(mid) > target) {
        if (mid == 0 || nums.at(mid - 1) < target) {
          idx = mid;
        }
        tail = mid - 1;
      } else if (nums.at(mid) < target) {
        if (mid == nums.size() - 1 || target < nums.at(mid + 1)) {
          idx = mid + 1;
        }
        head = mid + 1;
      } else {
        idx = mid;
      }
    }

    return idx;
  }
};


int main() {
  Solution sol;

  vector<int> nums {1, 3};

  int target = 2;
  int res = sol.searchInsert(nums, target);
  printf("target: %d -> res: %d\n", target, res);
}
