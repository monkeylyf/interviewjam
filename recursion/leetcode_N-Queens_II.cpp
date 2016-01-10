/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode N queen II
 */

#include <stdio.h>
#include <string>
#include <vector>

using std::string;
using std::vector;


class Solution {
 public:
  int totalNQueens(int n) {
    vector<vector<string>> solutions;
    vector<int> board (n, 0);
    return solve(&board, &solutions, 0, n);
  }

 private:
  int solve(vector<int>* board, vector<vector<string>>* solutions, int row, int n) {
    if (row == n) {
      return 1;
    } else {
      int sum = 0;
      for (int i = 1; i <= n; ++i) {
        (*board)[row] = i;
        if (isValidSolution(*board, row)) {
          sum += solve(board, solutions, row + 1, n);
        }
      }

      // Reset board at row 'row'.
      (*board)[row] = 0;
      return sum;
    }
  }

  bool isValidSolution(const vector<int>& board, int row) {
    for (int i = 0; i < row; ++i) {
      if (board[i] == board[row]) {
        return false;  // Same column.
      }

      if (row - i == board[row] - board[i]) {
        return false;  // Same diagnal \.
      }

      if (i - row == board[row] - board[i]) {
        return false;  // Same diagnal /.
      }
    }
    return true;
  }
};


int main() {
  Solution sol;

  int total = sol.totalNQueens(8);
  printf("Total queens: %d\n", total);
}
