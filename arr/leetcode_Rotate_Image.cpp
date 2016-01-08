/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode rotate image
 */

#include <stdio.h>
#include <vector>

using std::vector;


void printMatrix(const vector<vector<int>>& matrix) {
  for (const vector<int>& row : matrix) {
    for (int cell : row) {
      printf("%d ", cell);
    }
    printf("\n");
  }
}


class Solution {
 public:
  void rotate(vector<vector<int>>& matrix) {
    int n = matrix.size();
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {

        swap(&matrix, i, j, j, i);
      }
    }

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n / 2; ++j) {
        swap(&matrix, i, n - 1 - j, i, j);
      }
    }
  }

  void swap(vector<vector<int>>* matrix, int i, int j, int h, int k) {
    int tmp = matrix->at(i).at(j);
    (*matrix).at(i)[j] = matrix->at(h).at(k);
    (*matrix).at(h)[k] = tmp;
  }
};


int main() {
  Solution sol;
  vector<vector<int>> matrix {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12},
    {13, 14, 15, 16},
  };

  printf("Before:\n");
  printMatrix(matrix);
  sol.rotate(matrix);
  printf("After:\n");
  printMatrix(matrix);
}
