/*Eight_Queens
careercup

Write an algorithm to print all ways of arranging eight queens on a chess
board so that none of them share the same row, column or diagonal

Marks as duplicate with: ./leetcode_N-Queens.java
*/

import java.util.*;

public class cap_Eight_Queens {

	public static void main(String[] args) {
		Queen(8);
	}

	public static void Queen(int n) {
		ArrayList<int[]> all = new ArrayList<int[]>();
		int[] board = new int[n];
		placeQueen(0, n, board, all);
		for (int[] j : all) {
			for (int i = 0; i < n; ++i) {
				System.out.print("(" + i + ", " + j[i] + "), ");
			}
			System.out.println();
		}
		System.out.println("There are " + all.size() + " solutions to this questions.");
	}

	private static void placeQueen(int row, int n, int[] board, ArrayList<int[]> all) {
		if (row == n) {
			int[] tmp = new int[n];
			for (int i = 0; i < n; ++i) {
				tmp[i] = board[i];
				System.out.println(board[i]);
			}
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

	private static boolean check(int row, int[] board) {
		for (int i = 0; i < row; ++i) {
			int diff = Math.abs(board[i] - board[row]);
			if (diff == 0 || diff == row - i) {
				return false;
			}
		}
		return true;
	}
}
