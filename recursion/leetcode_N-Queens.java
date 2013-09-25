/*N-Queens

The n-queens puzzle is the problem of placing n queens on an n×n chessboard
such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens'
placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

import java.util.ArrayList;


public class leetcode_N_Queens {

    public static void main(String[] args) {
        solveNQueens(10);
    }

    public static ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> all = new ArrayList<String[]>();
        int[] board = new int[n];
        placeQueen(0, n, board, all);
        for (String[] i : all) {
			print(i);
        }
        return all;
    }

	// Backtracking.
    public static void placeQueen(int row, int n, int[] board, ArrayList<String[]> all) {
        if (row == n) { // End of backtracking. Path found.
            String[] tmp = boardToString(board);
            all.add(tmp);
            board = new int[n];
        } else {
            for (int i = 0; i < n; ++i) {
                board[row] = i; // Try to place queue on col i with current row.
                if (check(row, board)) { // If no conflict, go to next level of recursion.
                    placeQueen(row + 1, n, board, all);
                }
            }
        }
    }

	// Check if the queue we just placed on the board is in the same row, col or diagnal
	// with other queue we placed before. 
    public static boolean check(int row, int[] board) {
		int i, diff;
        for (i = 0; i < row; ++i) {
            diff = Math.abs(board[i] - board[row]);
            if (diff == 0 || diff == row - i) {
                return false; // diff == 0: in the same col. diff == row -i on diagnal.
            }
        }
        return true;
    }

	// Since we are using an array to represent a board. 
	// Print out the board based the array.
    public static String[] boardToString(int[] board) {
        String[] res = new String[board.length];
        for (int i = 0; i < board.length; ++i) {
            String row = "";
            for (int j = 0; j < board.length; ++j) {
                if (j == board[i]) {
                    row = row + 'Q';
                } else {
                    row = row + '.';
                }
            }
            res[i] = row;
        }
        return res;
    }

	// Helper function to print an array.
	public static print(String[] i) {
		for (String j : i) System.out.println(j);
		System.out.println();
	}
}
