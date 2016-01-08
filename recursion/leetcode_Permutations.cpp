/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode permutations
 */

#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  vector<vector<int>> permute(vector<int>& nums) {
    vector<vector<int>> container;
    vector<bool> used (nums.size(), false);
    vector<int> acc;

    permuteRecursive(&acc, &container, &used, nums);
    return container;
  }
 private:
  void permuteRecursive(vector<int>* acc, vector<vector<int>>* container,
    vector<bool>* used, const vector<int>& nums) {
    if (acc->size() == used->size()) {
      container->push_back(vector<int> (acc->begin(), acc->end()));
      return;
    }
    for (int i = 0; i < used->size(); ++i) {
      if (!used->at(i)) {
        acc->push_back(nums.at(i));
        (*used)[i] = true;
        permuteRecursive(acc, container, used, nums);
        (*used)[i] = false;
        acc->pop_back();
      }
    }
  }
};


int main() {
  Solution sol;

  vector<int> nums {1, 2, 3};

  vector<vector<int>> res = sol.permute(nums);

  for (const vector<int>& v : res) {
    for (int val : v) {
      printf("%d ", val);
    }
    printf("\n");
  }
}
