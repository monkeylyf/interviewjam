/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode spiral matrix
 */

#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  /**
   * To avoid overpeeling, conditionally peel lower and left.
   */
  vector<int> spiralOrder(const vector<vector<int>>& matrix) {
    vector<int> res;
    if (matrix.size() == 0) {
      return res;
    }
    peel(&res, matrix, 0, 0, matrix.size() - 1, matrix[0].size() - 1);
    return res;
  }

 private:
  void peel(vector<int>* res, const vector<vector<int>>& matrix, int i , int j, int h, int k) {
    if (i <= h && j <= k) {
      // Peel upper.
      for (int ii = j; ii <= k; ++ii) {
        res->push_back(matrix[i][ii]);
      }

      // Peel right.
      for (int ii = i + 1; ii <= h; ++ii) {
        res->push_back(matrix[ii][k]);
      }

      if (i < h && j < k) {
        // Peel lower.
        for (int ii = k - 1; ii >= j; --ii) {
          res->push_back(matrix[h][ii]);
        }
        // Peel left.
        for (int ii = h - 1; ii > i; --ii) {
          res->push_back(matrix[ii][j]);
        }
        peel(res, matrix, i + 1, j + 1, h - 1, k - 1);
      }
    }
  }
};


int main() {
  Solution sol;
  vector<vector<int>> matrix {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9},
    {10, 11, 12},
  };
  vector<int> res = sol.spiralOrder(matrix);

  for (int val : res) {
    printf("%d ", val);
  }
  printf("\n");
}
