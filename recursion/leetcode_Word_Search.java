/*Word_Search

Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, where
"adjacent" cells are those horizontally or vertically neighboring. The same
letter cell may not be used more than once.
For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/


import java.util.ArrayList;

public class leetcode_Word_Search {

    public static void main(String[] args) {
    }

    public static boolean exist(char[][] board, String word) {
        return findNextChar(-1, -1, board, word);
    }

    public static boolean findNextChar(int row, int col, char[][] board, String word) {
        if (word.length() == 0) {
            return true; // Reach the end of string, return true.
        } else {
            char cur = word.charAt(0);
            if (row != -1 && col != -1) {
                // check four ajadents.
                int[][] shift = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
                for (int k = 0; k < shift.length; ++k) {
                    int i = row + shift[k][0];
                    int j = col + shift[k][1];
                    if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                        if (board[i][j] == cur) {
                            board[i][j] = '.'; // '.' means used.
                            if (findNextChar(i, j, board, word.substring(1, word.length()))) {
                                return true;
                            } else {
                                // Reset the current char and keep iterating.
                                board[i][j] = cur;
                            }
                        }
                    }
                }
            } else {
                // get the locations of initial.
                for (int i = 0; i < board.length; ++i) {
                    for (int j = 0; j < board[i].length; ++j) {
                        if (board[i][j] == cur) {
                            board[i][j] = '.';
                            if (findNextChar(i, j, board, word.substring(1, word.length()))) {
                                return true;
                            } else {
                                board[i][j] = cur;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }
}
