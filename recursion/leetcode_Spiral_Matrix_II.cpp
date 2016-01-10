/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode spiral matrix II
 */

#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  vector<vector<int>> generateMatrix(int n) {
    vector<vector<int>> matrix (n, vector<int> (n, 0));

    fill(&matrix, 0, n - 1, 1);
    return matrix;
  }

 private:
  void fill(vector<vector<int>>* matrix, int i, int j, int n) {
    if (i == j) {
      (*matrix)[i][j] = n;
    } else if (i < j) {
      // Fill upper.
      for (int jj = i; jj < j; ++jj) {
        (*matrix)[i][jj] = n;
        ++n;
      }
      // Fill right.
      for (int ii = i; ii < j; ++ii) {
        (*matrix)[ii][j] = n;
        ++n;
      }
      // Fill lower.
      for (int jj = j; jj > i; --jj) {
        (*matrix)[j][jj] = n;
        ++n;
      }
      // Fill left.
      for (int ii = j; ii > i; --ii) {
        (*matrix)[ii][i] = n;
        ++n;
      }
      fill(matrix, i + 1, j - 1, n);
    } else {
      // Do nothing.
    }
  }
};


int main() {
  Solution sol;

  vector<vector<int>> matrix = sol.generateMatrix(3);

  for (const vector<int> row : matrix) {
    for (int val : row) {
      printf("%d ", val);
    }
    printf("\n");
  }
}
