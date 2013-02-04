/*Sudoku_Solver

Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'.
You may assume that there will be only one unique solution.
A sudoku puzzle...
...and its solution numbers marked in red.
*/

import java.util.HashSet;


class leetcode_Sudoku_Solver {
    public static void main(String[] args) {
        char[][] board = new char[][] {{'.', '4', '.', '.', '.', '5', '1', '2', '7'},
                                       {'.', '.', '.', '1', '.', '.', '3', '9', '4'},
                                       {'.', '.', '1', '4', '9', '.', '6', '5', '8'},
                                       {'3', '1', '7', '9', '2', '8', '4', '6', '5'},
                                       {'5', '9', '2', '7', '4', '6', '8', '1', '3'},
                                       {'8', '6', '4', '5', '3', '1', '9', '7', '2'},
                                       {'.', '5', '.', '3', '1', '4', '7', '8', '6'},
                                       {'4', '7', '6', '2', '8', '9', '5', '3', '1'},
                                       {'1', '3', '8', '6', '5', '7', '2', '4', '9'}
                                      };
        solveSudoku(board);
    }
    public static void solveSudoku(char[][] board) {
        resolveNext(board, 0, 0);
    }
    public static boolean resolveNext(char[][] board, int row, int col) {
        int[] pos = nextPosition(board, row, col);
        int nextRow = pos[0];
        int nextCol = pos[1];
        printBoard(board);
        if (nextRow == -1 && nextCol == -1) {
            return true;
        } else {
            for (int k = 1; k <= 9; ++k) {
                boolean result = false;
                board[nextRow][nextCol] = Character.forDigit(k, 10);
                if (isValidSudoku(board, nextRow, nextCol)) {
                    result = resolveNext(board, nextRow, nextCol);
                }
                if (result) {
                    return true;
                } else {
                    board[nextRow][nextCol] = '.'; // Reset on backtrack.
                }
            }
            return false;
        }
    }
    public static int[] nextPosition(char[][] board, int row, int col) {
        // Check cur row.
        for (int i = col; i < board[row].length; ++i) {
            if (board[row][i] == '.') {
                System.out.println(row + " " + i);
                return new int[] {row, i};
            }
        }
        // Check rest of rows.
        for (int i = row + 1; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == '.') {
                    System.out.println(i + " " + j);
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j< board[i].length; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean isValidSudoku(char[][] board, int row, int col) {
        HashSet<Character> set = new HashSet<Character>();
        // Check col.
        for (int i = 0; i < board.length; ++i) {
            char cur = board[i][col];
            if (cur != '.') {
                if (set.contains(cur)) {
                    return false;
                } else {
                    set.add(cur);
                }
            }
        }
        set = new HashSet<Character>();
        // Check row.
        for (int i = 0; i < board[row].length; ++i) {
            char cur = board[row][i];
            if (cur != '.') {
                if (set.contains(cur)) {
                    return false;
                } else {
                    set.add(cur);
                }
            }
        }
        set = new HashSet<Character>();
        // Check subbox.
        int i = row / 3 * 3; 
        int j = col / 3 * 3; // (i, j) is the upper-left point of the subbox containing (row, col). 
        for (int h = 0; h < 3; ++h) {
            for (int k = 0; k < 3; ++k) {
                char cur = board[i + h][j + k];
                if (cur != '.') {
                    if (set.contains(cur)) {
                        return false;
                    } else {
                        set.add(cur);
                    }
                }
            }
        }
        return true;
    }
}
