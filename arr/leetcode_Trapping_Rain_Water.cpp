/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode wrapping rain water
 */

#include <stdio.h>
#include <stdlib.h>
#include <vector>

using std::vector;


class Solution {
 public:
  /**
   * Monotone descending way. Fancy fancy...
   *
   * Scan all the idx from left to right. When you see a potentioal V shape
   * that can holds some water, calulate the volumn of water it holds. In order
   * to detect a V shape, a descending trend need to be recorded using a stack
   * (vector) with idx in it. With this you have \. When a new val larger than
   * previous value, then you have \/.
   *
   * To be honest, I might not be able to code this in a on-site interview. The
   * code below is quite condensed with some thoughts in it.
   */
  int trap(const vector<int>& height) {
    vector<int> monotone_desc;
    int acc_water = 0;

    for (int i = 0; i < height.size(); ++i) {
      while (!monotone_desc.empty() && height[i] > height[monotone_desc.back()]) {
        int bottom = height[monotone_desc.back()];
        monotone_desc.pop_back();

        if (!monotone_desc.empty()) {
          int left_idx = monotone_desc.back();
          int min_bank = std::min(height.at(i), height.at(left_idx));
          acc_water += (min_bank - bottom) * (i - left_idx - 1);
        }
      }
      monotone_desc.push_back(i);
    }

    return acc_water;
  }
};


int main() {
  Solution sol;
  vector<int> height {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
  int res = sol.trap(height);
  printf("Result: %d\n", res);
}
