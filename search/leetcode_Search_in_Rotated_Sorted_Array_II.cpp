/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode search in rotated sorted array II
 */

#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  bool search(const vector<int>& nums, int target) {
    return searchRecursive(nums, 0, nums.size() - 1, target);
  }

 private:
  bool searchRecursive(const vector<int>& nums, int start, int end, int target) {
    while (start <= end) {
      int mid = (end - start) / 2 + start;
      if (nums[mid] == target) {
        return true;
      } else if (nums[start] < nums[mid]) {
        // nums[start:mid] is sorted
        if (nums[start] <= target && target <= nums[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else if (nums[start] > nums[mid]) {
        // nums[mid:end] is sorted
        if (nums[mid] <= target && target <= nums[end]) {
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      } else {
        return searchRecursive(nums, start, mid - 1, target) ||
               searchRecursive(nums, mid + 1, end, target);
      }
    }
    return false;
  }
};


int main() {
  Solution sol;
  vector<int> nums {2, 4, 5, 5, 6, 7, 7, 8, 1, 2, 3};
  int target = 2;
  bool res = sol.search(nums, target);
  printf("result: %c\n", res ? 't' : 'f');
}
