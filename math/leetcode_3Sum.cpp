/*
 * Copyright 2015
 * Author: madarfacar
 *
 * leetcode threesome
 */

#include <algorithm>
#include <stdio.h>
#include <vector>

using std::vector;
using std::sort;


void printVector(const vector<int>& v) {
  for (int i : v) {
    printf("%d ", i);
  }
  printf("\n");
}


class Solution {
 public:
  vector<vector<int>> threeSum(vector<int>& nums) {
    vector<vector<int>> res;
    if (nums.size() < 3) {
      return res;
    }

    sort(nums.begin(), nums.end());
    int min = nums.at(0);
    int max = nums.at(nums.size() - 1);

    for (int i = 0; i < nums.size() - 2; ++i) {
      // Move to closest num that is not the same number as previous one.
      while (i != 0 && i < nums.size() - 2 && nums.at(i) == nums.at(i - 1)) {
        ++i;
      }
      for (int j = i + 1; j < nums.size() - 1; ++j) {
        // Move to closest num that is not the same number as previous one.
        while (j != i + 1 && j < nums.size() - 1 && nums.at(j) == nums.at(j - 1)) {
          ++j;
        }

        int target = -(nums.at(i) + nums.at(j));
        if (target > max || target < min) {
          // target does not exit in this vector.
          continue;
        } else {
          int idx = binarySearch(nums, j + 1, nums.size() - 1, target);
          if (idx != -1) {
            vector<int> combination {nums.at(i), nums.at(j), nums.at(idx)};
            res.push_back(combination);
          }
        }
      }
    }

    return res;
  }

  int binarySearch(vector<int>& nums, int head, int tail, int target) {
    int idx = -1;
    bool found = false;
    while (!found && head <= tail) {
      int mid = (tail - head) / 2 + head; // Avoid int overflow.
      if (nums.at(mid) == target) {
        found = true;
        idx = mid;
      } else if (nums.at(mid) > target) {
        tail = mid - 1;
      } else {
        head = mid + 1;
      }
    }

    return idx;
  }
};



int main() {
  Solution sol;

  //vector<int> nums {-1, 0, 0, 1, 2, -1, -4, -4};
  //vector<int> nums {0, 0, 0};
  vector<int> nums {0, 0, 0, 0};
  //printVector(nums);
  //printVector(sol.dedup(nums));
  vector<vector<int>> res = sol.threeSum(nums);

  printf("Results:\n");
  for (auto vv : res) {
    printVector(vv);
  }
}
