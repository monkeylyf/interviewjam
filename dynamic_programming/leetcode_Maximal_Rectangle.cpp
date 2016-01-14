/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode maximal rectangle
 */

#include <stdio.h>
#include <algorithm>
#include <utility>
#include <vector>

using std::max;
using std::pair;
using std::vector;

class Solution {
 public:
  int maximalRectangle(const vector<vector<char>>& matrix) {
    if (matrix.size() == 0) {
      return 0;
    }
    vector<int> height;
    for (char c : matrix[0]) {
      height.push_back(c - '0');
    }
    int area = largestRectangleArea(height);
    for (int i = 1; i < matrix.size(); ++i) {
      for (int j = 0; j < matrix[i].size(); ++j) {
        if (matrix[i][j] == '0') {
          height[j] = 0;
        } else {
          height[j] += 1;
        }
      }
      area = max(area, largestRectangleArea(height));
    }

    return area;
  }

 private:
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

  vector<vector<char>> matrix {
    {'1', '0', '1', '0', '1', '0'},
    {'1', '0', '1', '1', '1', '0'},
    {'1', '1', '1', '1', '1', '0'},
    {'1', '0', '1', '0', '1', '0'},
  };

  int area = sol.maximalRectangle(matrix);
  printf("result: %d\n", area);
}
