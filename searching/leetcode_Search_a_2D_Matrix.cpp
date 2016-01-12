/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode search a 2d matrix
 */

#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  /**
   * Divide and conquer(not really binary search because).
   * Starting at either left-bottom corner or right-upper corner.
   * Compair the value at the corner with target to rule out either one
   * row or column to form a new matrix for next level of divide and conquer.
   */
  bool searchMatrix(const vector<vector<int>>& matrix, int target) {
    if (matrix.size() == 0) {
      return false;
    }

    int n = matrix.size();
    int m = matrix[0].size();
    int i = 0;
    int j = m - 1;
    bool found = false;

    while (!found && i < n && 0 <= j) {
      if (matrix[i][j] > target) {
        --j;
      } else if (matrix[i][j] < target) {
        ++i;
      } else {
        found = true;
      }
    }

    return found;
  }
};


int main() {
  Solution sol;

  vector<vector<int>> matrix {
    {1,   3,  5,  7},
    {10, 11, 16, 20},
    {23, 30, 34, 50},
  };

  bool found = sol.searchMatrix(matrix, 3);
  printf("Result: %c\n", found ? 't' : 'f');
}
