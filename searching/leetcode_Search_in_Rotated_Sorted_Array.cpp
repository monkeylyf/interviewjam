/*
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode search in rotated sorted array
 */


#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  /**
   * The approach is based on a variation of binary searhc.
   *
   * The problem is the given array is rotated. Need to check whether
   * array[head:mid] is sorted or array[mid:tail] is sorted. It's impossible
   * that both array[head:mid] and array[mid:tail] is not sorted(why?). Once
   * the sorted range is found, it's quite easy to tell whether target is in
   * this range or not.
   */
  int search(vector<int>& nums, int target) {
    int head = 0;
    int tail = nums.size() - 1;
    int idx = -1;
    bool found = false;

    while (!found && head <= tail) {
      int mid = (tail - head) / 2 + head;
      if (nums.at(mid) == target) {
        found = true;
        idx = mid;
      } else if (nums.at(head) <= nums.at(mid)) {
        // nums[head:mid] is sorted.
        if (nums.at(head) <= target && target <= nums.at(mid)) {
          tail = mid - 1;
        } else {
          head = mid + 1;
        }
      } else {
        // nums[mid:tail] is sorted.
        if (nums.at(mid) <= target && target <= nums.at(tail)) {
          head = mid + 1;
        } else {
          tail = mid - 1;
        }
      }
    }

    return idx;
  }
};


int main() {
  Solution sol;

  vector<int> nums {4, 5, 6, 7, 8, 1, 2, 3};

  for (int target : nums) {
    int res = sol.search(nums, target);
    printf("target: %d index: %d\n", target, res);
  }
}
