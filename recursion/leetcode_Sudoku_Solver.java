/*Sudoku_Solver

Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'.
You may assume that there will be only one unique solution.
A sudoku puzzle...
...and its solution numbers marked in red.
*/

import java.util.HashSet;


public class leetcode_Sudoku_Solver {

    public static void main(String[] args) {
		char[][] board;
		// Test case 1.
        board = new char[][] {"...1..394".toCharArray(),
							  "..149.658".toCharArray(),
							  "317928465".toCharArray(),
							  "592746813".toCharArray(),
							  "864531972".toCharArray(),
							  ".5.314786".toCharArray(),
							  "476289531".toCharArray(),
							  "138657249".toCharArray()};
        //solveSudoku(board);
		// Test case 2.
		board1 = new char[][] {"8........".toCharArray(),
							   "..36.....".toCharArray(),
							   ".7..9.2..".toCharArray(),
							   ".5...7...".toCharArray(),
							   "....457..".toCharArray(),
							   "...1...3.".toCharArray(),
							   "..1....68".toCharArray(),
							   "..85...1.".toCharArray(),
							   ".9....4..".toCharArray(),
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
                //boolean result = false;
                board[nextRow][nextCol] = Character.forDigit(k, 10);
                if (isValidSudoku(board, nextRow, nextCol)) {
                    //result = resolveNext(board, nextRow, nextCol);
                    if (resolveNext(board, nextRow, nextCol)) {
                        return true;
                    }
                }
                board[nextRow][nextCol] = '.'; // Reset on backtrack.
            }
            return false;
        }
    }

	// Helper function to get next '.'
	// Return {-1, -1} if all empty spots have been filled.
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
