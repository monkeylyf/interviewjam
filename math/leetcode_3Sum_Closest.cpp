/*
 * Copyright 2015
 *
 * leetcode threesome closest
 */

#include <stdio.h>
#include <stdlib.h>
#include <algorithm>
#include <limits>
#include <vector>

using std::vector;


class Solution {
 public:
  int threeSumClosest(vector<int>& nums, int target) {
    if (nums.size() < 3) {
      return 0;  // Or throws exception.
    }

    int closest = nums.at(0) + nums.at(1) + nums.at(2);
    if (nums.size() == 3) {
      return closest;
    }

    sort(nums.begin(), nums.end());

    for (int i = 0; i < nums.size() - 2; ++i) {
      if (i != 0 && nums.at(i) == nums.at(i - 1)) {
        // dedup to avoid repeated computation.
        continue;
      }
      for (int j = i + 1; j < nums.size() - 1; ++j) {
        if (j != i + 1 && nums.at(j) == nums.at(j - 1)) {
          continue;
        }

        int idea_match = target - nums.at(i) - nums.at(j);
        int found = binarySearchClosest(
            nums, j + 1, nums.size() - 1, idea_match);
        int candicate = found + nums.at(i) + nums.at(j);
        if (abs(target - candicate) < abs(target - closest)) {
          closest = candicate;
        }
      }
    }

    return closest;
  }

  int binarySearchClosest(const vector<int>& nums, int head, int tail,
      int idea_match) {
    int ret = nums.at(head);
    bool found = false;
    while (!found && head <= tail) {
      int mid = (tail - head) / 2 + head;
      if (abs(nums.at(mid) - idea_match) < abs(ret - idea_match)) {
        ret = nums.at(mid);
      }

      if (nums.at(mid) == idea_match) {
        found = true;
      } else if (nums.at(mid) > idea_match) {
        tail = mid - 1;
      } else {
        head = mid + 1;
      }
    }

    return ret;
  }
};


int main() {
  // vector<int> nums = {-1, 2, 1, -4};
  vector<int> nums = {1, 1, 1, 1};

  Solution sol;
  const int res = sol.threeSumClosest(nums, 0);
  printf("Result: %d\n", res);
}
