/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode sudoku solver
 */


#include <stdio.h>
#include <utility>
#include <vector>

using std::pair;
using std::vector;


void printBoard(const vector<vector<char>>& board) {
  for (const vector<char>& row : board) {
    for (char c : row) {
      printf("%c ", c);
    }
    printf("\n");
  }
}


class Solution {
 public:
  void solveSudoku(vector<vector<char>>& board) {
    pair<int, int> cell {0, -1};
    solveSudokuRecursive(&cell, &board);
  }

 private:
  bool solveSudokuRecursive(pair<int, int>* cell, vector<vector<char>>* board) {
    // Cache the value for later reset.
    pair<int, int> cur_cell {cell->first, cell->second};
    try {
      nextUnfilledCell(cell, *board);
    } catch (int e) {
      // Invalid
      return isValidSudoku(cur_cell, *board);
    }

    for (char i = '1'; i <= '9'; ++i) {
      (*board)[cell->first][cell->second] = i;
      if (isValidSudoku(*cell, *board)) {
        bool res = solveSudokuRecursive(cell, board);
        if (res) {
          // Board is filled, Stop trying.
          return true;
        }
      }
    }
    // Reset to unfilled state.
    (*board)[cell->first][cell->second] = '.';
    cell->first = cur_cell.first;
    cell->second = cur_cell.second;

    return false;
  }

  void nextUnfilledCell(pair<int, int>* cell, const vector<vector<char>>& board) {
    bool found = false;
    // Scan the row current cell is in.
    for (int j = cell->second + 1; !found && j < 9; ++j) {
      if (board[cell->first][j] == '.') {
        cell->second = j;
        found = true;
      }
    }
    // Scan the rest of rows.
    for (int i = cell->first + 1; !found && i < 9; ++i) {
      for (int j = 0; !found && j < 9; ++j) {
        if (board[i][j] == '.') {
          cell->first = i;
          cell->second = j;
          found = true;
        }
      }
    }

    if (!found) {
      throw 399;
    }
  }

  bool isValidSudoku(const pair<int, int>& cell, const vector<vector<char>>& board) {
    bool mask[10] {};
    // Check row.
    for (int j = 0; j < 9; ++j) {
      if (board[cell.first][j] != '.') {
        int idx = board[cell.first][j] - '0';
        if (mask[idx]) {
          return false;  // Dups found.
        } else {
          mask[idx] = true;
        }
      }
    }
    memset(mask, false, sizeof(mask));

    // Check column.
    for (int i = 0; i < 9; ++i) {
      if (board[i][cell.second] != '.') {
        int idx = board[i][cell.second] - '0';
        if (mask[idx]) {
          return false;  // Dups found.
        } else {
          mask[idx] = true;
        }
      }
    }
    memset(mask, false, sizeof(mask));

    // Check sub square.
    int x = cell.first / 3 * 3;
    int y = cell.second / 3 * 3;
    for (int dx = 0; dx <= 2; ++dx) {
      for (int dy = 0; dy <= 2; ++dy) {
        if (board[x + dx][y + dy] != '.') {
          int idx = board[x + dx][y + dy] - '0';
          if (mask[idx]) {
            return false;
          } else {
            mask[idx] = true;
          }
        }
      }
    }
    memset(mask, false, sizeof(mask));

    return true;
  }
};


int main() {
  Solution sol;

  vector<vector<char>> board {
    {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
    {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
    {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
    {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
    {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
    {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
    {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
    {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
    {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
  };

  printf("Before-------\n");
  printBoard(board);
  sol.solveSudoku(board);
  printf("After-------\n");
  printBoard(board);
}
