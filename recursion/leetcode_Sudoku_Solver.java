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

/* Python Version (TLE and I do not know how to optimize it)

class Solution:
    # @param board, a 9x9 2D array
    # Solve the Sudoku by modifying the input board in-place.
    # Do not return any value.
    def solveSudoku(self, board):
        location = []
        for i in xrange(9):
            for j in xrange(9):
                if board[i][j] == '.':
                    location.append((i, j))
                    
        board = [ list(line) for line in board ]
        self.backtrack(0, location, board)
        board = [ ''.join(line) for line in board ]

    def backtrack(self, idx, loc, board):
        if idx == len(loc):
            return True
        else:
            (x, y) = loc[idx]
            for fill in xrange(1, 10):
                board[x][y] = str(fill)
                if self.isValidSudoku(board, x, y):
                    if self.backtrack(idx + 1, loc, board):
                        return True
            board[x][y] = '.'
            return False
            
    def isValidSudoku(self, board, x, y):
        # check row
        s = set()
        for i in xrange(9):
            if board[x][i] == '.':
                continue
            if board[x][i] in s:
                return False
            else:
                s.add(board[x][i])
        
        # check column
        s = set()
        for i in xrange(9):
            if board[i][y] == '.':
                continue
            if board[i][y] in s:
                return False
            else:
                s.add(board[i][y])
            
        # check submatrix
        x = x / 3 * 3
        y = y / 3 * 3
        s = set()
        for i in xrange(3):
            for j in xrange(3):
                char = board[x + i][y + j]
                if char == '.':
                    continue
                if char in s:
                    return False
                else:
                    s.add(char)
        return True
*/
