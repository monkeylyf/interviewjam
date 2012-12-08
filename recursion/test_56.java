/*Write an algorithm to print all ways of arranging eight queens on a chess
board so that none of them share the same row, column or diagonal*/

import java.util.*;

class test_56 {
	public static void main(String[] args) {
		Queen(8);
	}
	public static void Queen(int n) {
		ArrayList<int[]> all = new ArrayList<int[]>();
		int[] board = new int[n];
		placeQueen(0, n, board, all);
		int total = 0;
		for (int[] j : all) {
			for (int i = 0; i < n; ++i) System.out.print("(" + i + ", " + j[i] + "), ");
			System.out.println("");
			total += 1;
		}
		System.out.println("There are " + total + " solutions to this questions.");
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
			return;
		}
		for (int i = 0; i < n; ++i) {
			board[row] = i;
			if (check(row, board)) placeQueen(row + 1, n, board, all);
		}
	}
	private static boolean check(int row, int[] board) {
		for (int i = 0; i < row; ++i) {
			int diff = Math.abs(board[i] - board[row]);
			if (diff == 0 || diff == row - i) return false;
		}
		return true;
	}
}
