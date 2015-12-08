/*
 * Copyright 2015
 * Author: dumbass
 *
 * leetcode Container W/ Most Water
 *
 */

#include <stdio.h>
#include <vector>
#include <algorithm>

using std::vector;
using std::min;
using std::max;


class Solution {
 public:
  int maxArea(const vector<int>& height) {
    int res = 0;

    if (height.size() <= 1) {
      return res;
    }

    int left = 0;
    int right = height.size() - 1;

    while (left < right) {
      int left_boundary = height.at(left);
      int right_boundary = height.at(right);
      int cur = min(left_boundary, right_boundary) * (right - left);
      res = max(cur, res);

      // water vol = min(left_boundary, right_boundary) * width
      // We start with two pointers with start and end and max width possible
      // then move two pointers towards each other until they meet. So width
      // will be decreasing and we want the max water vol, then try to find the
      // best strategy to find min(left_boundary, right_boundary)
      // 1. always move the smaller one to increase min(a, b)
      // 2. if a == b, move either one is fine:
      //    min(a, b) = a >= min(a, any number)
      //    and this mean moving either one is irrelavant because it has no
      //    impact on global max.
      if (left_boundary > right_boundary) {
        --right;
      } else {
        ++left;
      }
    }

    return res;
  }
};


int main() {
  Solution sol;

  vector<int> height = {1, 2, 3, 4, 5};
  int res = sol.maxArea(height);
  printf("result: %d\n", res);
}
