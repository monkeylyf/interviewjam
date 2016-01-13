/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode subsets
 */


#include <stdio.h>
#include <algorithm>
#include <vector>

using std::vector;


class Solution {
 public:
  vector<vector<int>> subsets(vector<int>& nums) {
    vector<vector<int>> container;
    vector<int> acc;
    subsetsRecursive(&acc, &container, 0, nums);
    return container;
  }

 private:
  void subsetsRecursive(vector<int>* acc, vector<vector<int>>* container,
    int i, const vector<int>& nums) {
    if (i == nums.size()) {
      vector<int> subset (acc->begin(), acc->end());
      sort(subset.begin(), subset.end());
      container->push_back(subset);
    } else {
      // Don't pick current val
      subsetsRecursive(acc, container, i + 1, nums);
      // Pick current val
      acc->push_back(nums[i]);
      subsetsRecursive(acc, container, i + 1, nums);
      acc->pop_back();
    }
  }
};


int main() {
  Solution sol;
  vector<int> nums {1, 2, 3};

  vector<vector<int>> subsets = sol.subsets(nums);
  for (const vector<int> subset : subsets) {
    for (int i : subset) {
      printf("%d ", i);
    }
    printf("\n");
  }
}
