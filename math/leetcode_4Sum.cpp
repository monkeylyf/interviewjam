/*
 * Copyright 2015
 * Author: madarfacar
 *
 * leetcode foursome
 *
 */

#include <stdio.h>
#include <algorithm>
#include <set>
#include <unordered_map>
#include <vector>

using std::set;
using std::vector;
using std::unordered_map;


class Solution {
 public:
  /*
   * Breaking the problem down to 2sum. Using set to dedup.
   *
   * Time complexity: O(nlgn) + O(n^3)
   * Space complexity: O(n)
   *
   */
  vector<vector<int> > fourSum(vector<int> &nums, int target) {
    sort(nums.begin(), nums.end());
    set<vector<int>> res;
    int n = nums.size();
    for (int i = 0; i < n - 3; ++i) {
      for (int j = i + 1; j < n - 2; ++j) {
        int head = j + 1;
        int tail = n - 1;

        while (head < tail) {
          int sum = nums[i] + nums[j] + nums[head] + nums[tail];
          if (sum == target) {
            vector<int> tmp {nums[i], nums[j], nums[head], nums[tail]};
            res.insert(tmp);
            ++head;
            --tail;
          } else if (sum < target) {
            ++head;
          } else {
            --tail;
          }
        }
      }
    }
    vector<vector<int>> ret(res.begin(), res.end());
    return ret;
  }
};


int main() {
  Solution sol;

  vector<int> nums {1, 0, -1, 0, -2, 2};
  int target = 0;

  vector<vector<int>> res = sol.fourSum(nums, target);
}
