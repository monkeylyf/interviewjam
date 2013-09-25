/*N-Queens_Followup

The n-queens puzzle is the problem of placing n queens on an n×n chessboard
such that no two queens attack each other. 
*In addition that any THREE queens can not be in the same line at the
same time*. For example, (0, 0), (1, 2), (2, 4) are in the same line.
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens'
placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
*/

import java.util.ArrayList;

public class N-Queens_Followup {

	/**
	 * This solution is a simple copy of leetcode_N-Queens and is not the right solution!
	 */

    public static void main(String[] args) {
        solveNQueens(8);
    }

    public static ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> all = new ArrayList<String[]>();
        int[] board = new int[n];
        placeQueen(0, n, board, all);
        for (String[] i : all) {
            for (String j : i) System.out.println(j);
            System.out.println();
        }
        return all;
    }

    public static void placeQueen(int row, int n, int[] board, ArrayList<String[]> all) {
        if (row == n) {
            String[] tmp = boardToString(board);
            all.add(tmp);
            board = new int[n];
        } else {
            for (int i = 0; i < n; ++i) {
                board[row] = i;
                if (check(row, board)) {
                    placeQueen(row + 1, n, board, all);
                }
            }
        }
    }

    public static boolean check(int row, int[] board) {
        for (int i = 0; i < row; ++i) {
            int diff = Math.abs(board[i] - board[row]);
            if (diff == 0 || diff == row - i) {
                return false;
            }
        }
        return true;
    }

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
}
