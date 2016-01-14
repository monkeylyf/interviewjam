/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode gray code
 */

#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  vector<int> grayCode(int n) {
    vector<int> code;

    for (int i = 0; i <= n; ++i) {
      code.push_back(i ^ (i >> 1));
    }
    return code;
  }
};


int main() {
  Solution sol;
  vector<int> code = sol.grayCode(4);
  for (int i : code) {
    printf("%d ", i);
  }
  printf("\n");
}
