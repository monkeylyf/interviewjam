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
    vector<vector<int>> container {vector<int> (0)};
    vector<int> acc;
    subsetsRecursive(&acc, &container, 0, nums);
    return container;
  }

 private:
  void subsetsRecursive(vector<int>* acc, vector<vector<int>>* container,
    int start, const vector<int>& nums) {
    for (int i = start; i < nums.size(); ++i) {
      // Pick current val.
      acc->push_back(nums[i]);
      container->push_back(vector<int> (acc->begin(), acc->end()));
      subsetsRecursive(acc, container, i + 1, nums);
      // Pop the current val out so next iteration won't include it.
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
