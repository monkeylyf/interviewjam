/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode valid sudoku
 */


#include <stdio.h>
#include <vector>

using std::vector;


class Solution {
 public:
  bool isValidSudoku(vector<vector<char>>& board) {
    bool mask[10] {};

    // Check vertical.
    for (int i = 0; i < 9; ++i) {
      for (int j = 0; j < 9; ++j) {
        if (board[i][j] != '.') {
          int idx = board[i][j] - '0';
          if (mask[idx]) {
            return false;  // Dups found.
          } else {
            mask[idx] = true;
          }
        }
      }
      memset(mask, false, sizeof(mask));
    }

    // Check horizontal.
    for (int j = 0; j < 9; ++j) {
      for (int i = 0; i < 9; ++i) {
        if (board[i][j] != '.') {
          int idx = board[i][j] - '0';
          if (mask[idx]) {
            return false;  // Dups found.
          } else {
            mask[idx] = true;
          }
        }
      }
      memset(mask, false, sizeof(mask));
    }

    // Check sub square.
    for (int x = 1; x < 9; x += 3) {
      for (int y = 1; y < 9; y += 3) {
        for (int dx = -1; dx <= 1; ++dx) {
          for (int dy = -1; dy <= 1; ++dy) {
            int i = x + dx;
            int j = y + dy;
            if (board[i][j] != '.') {
              int idx = board[i][j] - '0';
              if (mask[idx]) {
                return false;
              } else {
                mask[idx] = true;
              }
            }
          }
        }
        memset(mask, false, sizeof(mask));
      }
    }

    return true;
  }
};


int main() {
  Solution sol;

  vector<vector<char>> board {
    {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
    {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
    {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
    {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
    {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
    {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
    {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
    {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
    {'9', '.', '.', '.', '.', '.', '.', '.', '.'},
  };

  bool res = sol.isValidSudoku(board);
  printf("Result: %s\n", res ? "true" : "false");
}
