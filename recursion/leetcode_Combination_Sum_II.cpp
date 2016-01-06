/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode combination sum II
 */

#include <stdio.h>
#include <algorithm>
#include <vector>

using std::vector;


class Solution {
 public:
  vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
    sort(candidates.begin(), candidates.end());

    vector<vector<int>> container;
    vector<int> acc;
    combinationSum2Recursive(
      &acc, &container, candidates.begin(), candidates.end(), target);

    return container;
  }

 private:
  void combinationSum2Recursive(vector<int>* acc, vector<vector<int>>* container,
    vector<int>::iterator begin, vector<int>::iterator end, int target) {
    if (target < 0) {
      return;
    } else if (target == 0) {
      container->push_back(vector<int> (acc->begin(), acc->end()));
    } else {
      for (auto it = begin; it != end; ++it) {
        acc->push_back(*it);
        combinationSum2Recursive(acc, container, it + 1, end, target - *it);
        acc->pop_back();

        // Because vector candidate is already sorted and dup elements cause
        // dup combinations, move ptr it to the next closest different element.
        while (it + 1 != end && *it == *(it + 1)) {
          ++it;
        }
      }
    }
  }
};


int main() {
  Solution sol;

  vector<int> candidates {10, 1, 2, 7, 6, 1, 5};
  int target = 8;
  vector<vector<int>> container = sol.combinationSum2(candidates, target);
  for (const vector<int>& answer : container) {
    for (int val : answer) {
      printf("%d ", val);
    }
    printf("\n");
  }
}
