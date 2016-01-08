/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode permutations II
 */

#include <stdio.h>
#include <algorithm>
#include <vector>

using std::vector;


class Solution {
 public:
  vector<vector<int>> permuteUnique(vector<int>& nums) {
    sort(nums.begin(), nums.end());
    vector<vector<int>> container;
    vector<bool> used (nums.size(), false);
    vector<int> acc;

    permuteUniqueRecursive(&acc, &container, &used, nums);
    return container;
  }

 private:
  void permuteUniqueRecursive(vector<int>* acc, vector<vector<int>>* container,
    vector<bool>* used, const vector<int>& nums) {
    if (acc->size() == used->size()) {
      container->push_back(vector<int> (acc->begin(), acc->end()));
      return;
    }
    for (int i = 0; i < used->size(); ++i) {
      if (!used->at(i)) {
        acc->push_back(nums.at(i));
        (*used)[i] = true;
        permuteUniqueRecursive(acc, container, used, nums);
        (*used)[i] = false;
        acc->pop_back();

        while (i < nums.size() - 1 && nums.at(i) == nums.at(i + 1)) {
          ++i;
        }
      }
    }
  }
};


int main() {
  Solution sol;
  vector<int> nums {1, 1, 2};
  vector<vector<int>> res = sol.permuteUnique(nums);

  for (const vector<int>& v : res) {
    for (int val : v) {
      printf("%d ", val);
    }
    printf("\n");
  }
}
