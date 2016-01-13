/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode subsets II
 */


#include <stdio.h>
#include <algorithm>
#include <vector>

using std::vector;


class Solution {
 public:
  vector<vector<int>> subsetsWithDup(vector<int>& nums) {
    sort(nums.begin(), nums.end());
    vector<vector<int>> container {vector<int> (0)};
    vector<int> acc;
    subsetsRecursive(&acc, &container, 0, nums);
    return container;
  }

 private:
  void subsetsRecursive(vector<int>* acc, vector<vector<int>>* container,
    int start, const vector<int>& nums) {
    for (int i = start; i < nums.size(); ++i) {
      if (start < i && nums[i - 1] == nums[i]) {
        continue;
      }
      // Don't pick current val
      acc->push_back(nums[i]);
      container->push_back(vector<int> (acc->begin(), acc->end()));
      // Pick current val
      subsetsRecursive(acc, container, i + 1, nums);
      acc->pop_back();
    }
  }
};


int main() {
  Solution sol;
  //vector<int> nums {1, 2, 2};
  vector<int> nums {1, 1, 1};

  vector<vector<int>> subsets = sol.subsetsWithDup(nums);
  for (const vector<int> subset : subsets) {
    for (int i : subset) {
      printf("%d ", i);
    }
    printf("\n");
  }
}
