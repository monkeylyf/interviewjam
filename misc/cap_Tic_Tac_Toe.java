/*Tic_Tac_Toe
careercup

Design an algorithm to figure out if someone has won in a game of tic-tac-toe.
*/

import java.util.*;


class cap_Tic_Tac_Toe {
    public static void main(String[] args) {

    }
    // Approach 1: Cache all possbile combination(3^9).
    public static void hasWon(char[][] board) {
        // Approach 2.
        HashSet<Character> row, col;
        boolean hasEmptyCell = false;
        int i, j;
        // Check row and col.
        for (i = 0; i < 3; ++i) {
            row = new HashSet<Character>();
            col = new HashSet<Character>();
            for (j = 0; j < 3; ++j) {
                if (board[i][j] == '.') {
                    hasEmptyCell = true;
                }
                row.add(board[i][j]);
                col.add(board[j][i]);
            }
            if (hasWon(row)) {
                return;
            }
            if (hasWon(col)) {
                return;
            }
        }
         // check diagonal.
         row = new HashSet<Character>();
         col = new HashSet<Character>();
         for (i = 0; i < 3; ++i) {
             row.add(board[i][i]);
             col.add(board[i][3 - i]);
         }
         if (hasWon(row)) {
             return;
         }
         if (hasWon(col)) {
             return;
         }
         if (hasEmptyCell) {
             System.out.println("Game has not completed");
         } else {
             System.out.println("Draw");
         }
    }

    public static boolean hasWon(HashSet<Character> row) {
        if (row.size() >= 2) {
            return false;  
        } else { // row.size() == 1
            if (row.contains('X')) {
                System.out.println("X won");
                return true;
            } else if (row.contains('O')) {
                System.out.println("X won");
                return true;
            }
        }
        return false;
    }
}
