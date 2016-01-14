/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode largest rectangle in histogram
 */

#include <stdio.h>
#include <algorithm>
#include <utility>
#include <vector>

using std::pair;
using std::max;
using std::vector;


class Solution {
 public:
  /**
   * Monotone ascending stack...
   */
  int largestRectangleArea(const vector<int>& height) {
    vector<pair<int, int>> stack;
    int area = 0;

    for (int i = 0; i < height.size(); ++i) {
      int cur_height = height[i];
      if (stack.empty() || cur_height > stack.back().second) {
        // Acsending order.
        stack.push_back(pair<int, int> (i, cur_height));
      } else if (cur_height < stack.back().second) {
        int last_idx = 0;
        int last_height = 0;
        while (!stack.empty() && stack.back().second > cur_height) {
          last_idx = stack.back().first;
          last_height = stack.back().second;
          stack.pop_back();
          area = max(area, last_height * (i - last_idx));
        }
        stack.push_back(pair<int, int> (last_idx, cur_height));
      } else {
        // Same height as previous one, do nothing.
      }
    }

    while (!stack.empty()) {
      int idx = stack.back().first;
      int hght = stack.back().second;
      stack.pop_back();
      int width = height.size() - idx;
      area = max(area, hght * width);
    }

    return area;
  }
};


int main() {
  Solution sol;

  //vector<int> height {2, 1, 5, 6, 2, 3};
  vector<int> height {1};
  int res = sol.largestRectangleArea(height);

  printf("result: %d\n", res);
}
