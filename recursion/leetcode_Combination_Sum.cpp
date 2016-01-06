/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode combination sum
 */

#include <stdio.h>
#include <algorithm>
#include <vector>

using std::vector;

class Solution {
 public:
  vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
    sort(candidates.begin(), candidates.end());
    vector<vector<int>> container;
    vector<int> acc;

    combinationSumRecursive(&acc, &container, candidates.begin(), candidates.end(), target);
    return container;
  }

 private:
  void combinationSumRecursive(vector<int>* acc, vector<vector<int>>* container,
    vector<int>::iterator begin, vector<int>::iterator end, int target) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      container->push_back(vector<int> {acc->begin(), acc->end()});
      return;
    } else {
      for (auto it = begin; it != end; ++it) {
        acc->push_back(*it);
        combinationSumRecursive(acc, container, it, end, target - *it);
        acc->pop_back();
      }
    }
  }
};


int main() {
  Solution sol;

  vector<int> candidates {2,3,6,7};
  int target = 7;

  vector<vector<int>> container = sol.combinationSum(candidates, target);

  for (const vector<int>& answer : container) {
    for (int val : answer) {
      printf("%d ", val);
    }
    printf("\n");
  }
}
