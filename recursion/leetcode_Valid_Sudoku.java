/*Valid_Sudoku

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
The Sudoku board could be partially filled, where empty cells are filled with
the character '.'.
*/


import java.util.HashSet;


public class leetcode_Valid_Sudoku {

    public static void main(String[] args) {

    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<Character>();
        // Check col.
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
            set = new HashSet<Character>();
        }
        // Check row.
        for (int j = 0; j < board[0].length; ++j) {
            for (int i = 0; i < board.length; ++i) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
            set = new HashSet<Character>();
        }
        // Check subbox.
        int[][] checkPoint = new int[][] {{0, 0},
                                          {0, 3},
                                          {0, 6},
                                          {3, 0},
                                          {3, 3},
                                          {3, 6},
                                          {6, 0},
                                          {6, 3},
                                          {6, 6},
                                         };
        for (int point = 0; point < checkPoint.length; ++point) {
            int i = checkPoint[point][0];
            int j = checkPoint[point][1];
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
            set = new HashSet<Character>();
        }
        return true;
    }
}
