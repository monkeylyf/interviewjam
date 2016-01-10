/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode N queen
 */

#include <stdio.h>
#include <string>
#include <vector>

using std::string;
using std::vector;


class Solution {
 public:
  vector<vector<string>> solveNQueens(int n) {
    vector<vector<string>> solutions;
    vector<int> board (n, 0);
    solve(&board, &solutions, 0, n);
    return solutions;
  }

 private:
  void solve(vector<int>* board, vector<vector<string>>* solutions, int row, int n) {
    if (row == n) {
      solutions->push_back(boardToString(*board));
    } else {
      for (int i = 1; i <= n; ++i) {
        (*board)[row] = i;
        if (isValidSolution(*board, row)) {
          solve(board, solutions, row + 1, n);
        }
      }

      // Reset board at row 'row'.
      (*board)[row] = 0;
    }
  }

  vector<string> boardToString(const vector<int>& board) {
    vector<string> boardStr;
    vector<char> row (board.size(), '.');

    for (int i = 0; i < board.size(); ++i) {
      int idx = board[i] - 1;
      row[idx] = 'Q';
      boardStr.push_back(string (row.begin(), row.end()));
      row[idx] = '.';
    }
    return boardStr;
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

  vector<vector<string>> solutions = sol.solveNQueens(8);

  for (const vector<string> solution : solutions) {
    for (string row : solution) {
      printf("%s\n", row.c_str());
    }
    printf("\n");
  }
}
