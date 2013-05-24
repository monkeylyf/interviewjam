/*Dice Throw

geekforgeeks

This problem is very similar to coin change problem.hmmm...
*/


import java.util.*;


public class Dice_Throw {

	/**
	 * Given n dice each with m faces, numbered from 1 to m, find the number of
	 * ways to get sum X. X is the summation of values on each face when all the
	 * dice are thrown.
	 */
	public static void main(String[] args) {
		solve(4, 2, 1);
		solve(2, 2, 3);
		solve(6, 3, 8);
		solve(4, 2, 5);
		solve(4, 3, 5);
	}

	// Time complexity(O(nx^2)). Space complexity O(xn)
	public static void solve(int n, int m, int x) {
		int[][] dp = new int[x + 1][n + 1];
		// dp[i][j] represents how many ways to get sum i with j dice with m facec.
		int i, j, k;
		// init dp. use only one dice.
		for (i = 1; i <= Math.min(m, x); ++i) {
			dp[i][1] = 1;
		}
		
		//
		for (i = 2; i <= n; ++i) { // Using i dice
			for (j = 1; j <= x; ++j) { // To get sum j
				for (k = 1; k < j; ++k) { // And index of cur dice is k, k within[1, k - 1], inclusive inclusive. 
					dp[j][i] += dp[j - k][i - 1]; 
				}
			}
		}
		//printMatrix(dp);
		System.out.println(dp[x][n]);
	}
	
	// Helper function.
	public static void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
	
	public static void printMatrix(int[][] m) {
		for (int[] i : m) print(i);
		System.out.println();
	}
}
