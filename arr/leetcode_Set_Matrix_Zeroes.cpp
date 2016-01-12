/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode set matrix zeros
 */

#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  void setZeroes(vector<vector<int>>& matrix) {
    int n = matrix.size();
    int m = matrix[0].size();

    bool set_upper = false;
    bool set_left = false;
    if (matrix[0][0] == 0) {
      set_upper = true;
      set_left = true;
    } else {
      for (int j = 1; j < m; ++j) {
        if (matrix[0][j] == 0) {
          set_upper = true;
          break;
        }
      }

      for (int i = 1; i < n; ++i) {
        if (matrix[i][0] == 0) {
          set_left = true;
          break;
        }
      }
    }

    for (int i = 1; i < n; ++i) {
      for (int j = 1; j < m; ++j) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    for (int j = 1; j < m; ++j) {
      if (matrix[0][j] == 0) {
        for (int i = 1; i < n; ++i) {
          matrix[i][j] = 0;
        }
      }
    }

    for (int i = 1; i < n; ++i) {
      if (matrix[i][0] == 0) {
        for (int j = 1; j < m; ++j) {
          matrix[i][j] = 0;
        }
      }
    }

    if (set_upper) {
      for (int j = 0; j < m; ++j) {
        matrix[0][j] = 0;
      }
    }

    if (set_left) {
      for (int i = 0; i < n; ++i) {
        matrix[i][0] = 0;
      }
    }
  }
};


void printMatrix(const vector<vector<int>>& matrix) {
  for (const vector<int> row : matrix) {
    for (int val : row) {
      printf("%d ", val);
    }
    printf("\n");
  }
}


int main() {
  Solution sol;
  vector<vector<int>> matrix {
    {1, 2, 3, 4, 5},
    {1, 2, 3, 0, 5},
    {1, 0, 3, 4, 5},
    {1, 2, 3, 4, 5},
    {1, 2, 3, 4, 5},
  };

  printf("Before------");
  printMatrix(matrix);
  sol.setZeroes(matrix);
  printf("After------");
  printMatrix(matrix);
}
