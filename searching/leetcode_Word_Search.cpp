/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode word search
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 *
 */

#include <stdio.h>
#include <string>
#include <utility>
#include <vector>

using std::string;
using std::pair;
using std::vector;


class Solution {
 public:
  bool exist(const vector<vector<char>>& board, string word) {
    if (word.length() == 0) {
      return false;
    }

    vector<vector<bool>> visited (board.size(), vector<bool> (board[0].size(), false));

    for (int i = 0; i < board.size(); ++i) {
      for (int j = 0; j < board[i].size(); ++j) {
        // Start recursion only when:
        // 1. current char is same as first char of word, and
        // 2. length of the word is longer than 1.
        if (board[i][j] == word[0] && (word.length() == 1 || dfs(&visited, pair<int, int> (i, j), board, 0, word))) {
          return true;
        }
      }
    }

    return false;
  }

 private:
  bool dfs(vector<vector<bool>>* visited, pair<int, int> p,
    const vector<vector<char>>& board, int i, string word) {
    if (p.first < 0 || p.first >= visited->size() ||
        p.second < 0 || p.second >= (*visited)[0].size()) {
      // Check point is out of boundary.
      return false;
    } else if (i == word.length()) {
      return true;
    } else if (!(*visited)[p.first][p.second] && word[i] == board[p.first][p.second]) {
      (*visited)[p.first][p.second] = true;
      if (dfs(visited, pair<int, int>(p.first - 1, p.second), board, i + 1, word) ||
          dfs(visited, pair<int, int>(p.first + 1, p.second), board, i + 1, word) ||
          dfs(visited, pair<int, int>(p.first, p.second - 1), board, i + 1, word) ||
          dfs(visited, pair<int, int>(p.first, p.second + 1), board, i + 1, word)) {
        return true;
      }
      // Reset visited bool matrix.
      (*visited)[p.first][p.second] = false;
      return false;
    } else {
      return false;
    }
  }
};


int main() {
  Solution sol;

  vector<vector<char>> board {
    {'A', 'B', 'C', 'E'},
    {'S', 'F', 'C', 'S'},
    {'A', 'D', 'E', 'E'},
  };

  bool exist = sol.exist(board, "ABCCED");
  printf("Exist: %c\n", exist ? 't' : 'f');
}
