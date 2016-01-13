/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode combinations
 */


#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  vector<vector<int>> combine(int n, int k) {
    vector<vector<int>> combinations;
    vector<bool> used (n, false);
    vector<int> acc;
    combineRecursive(&acc, &used, &combinations, 0, k);
    return combinations;
  }
 private:
  void combineRecursive(vector<int>* acc, vector<bool>* used,
    vector<vector<int>>* combinations, int i, int k) {
    if (k == 0) {
      combinations->push_back(vector<int> (acc->begin(), acc->end()));
    } else {
      for (int h = i; h < used->size(); ++h) {
        if (!(*used)[h]) {
          (*used)[h] = true;
          acc->push_back(h + 1);
          combineRecursive(acc, used, combinations, h, k - 1);
          acc->pop_back();
          (*used)[h] = false;
        }
      }
    }
  }
};


int main() {
  Solution sol;
  vector<vector<int>> combinations = sol.combine(4, 2);

  for (const vector<int> combination : combinations) {
    for (int i : combination) {
      printf("%d ", i);
    }
    printf("\n");
  }
}
