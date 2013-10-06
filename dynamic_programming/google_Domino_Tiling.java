/*Domino_Tiling
google

You are given a N x N Euclidean plane and you are tring to cover the place
with infinite number of 1 x 2 tiles. You can not overlap the tile. How many
ways are there to cover the plane?

And print out all solutions.
*/

import java.util.*;


public class google_Domino_Tiling {
	
	public static void main(String[] args) {
		// Test case 1.
		//dfs(1, 10);
		// Test case 2.
		//dfs(1, 15);
		// Test case 3.
		//dfs(4, 4);
		// Test case 4.
		//dfs(6, 6); // dfs(8, 8);  12,988,816 solutions..

		// Test case for dp solution.
		solve(4, 4);
		//solve(6, 6);
	}
	
	/* dp[i][j] represents the number of ways to tile at row i with status j and
	 * here j in binary form by (0 0 meaning a horizontal tile and 1 a vertical one)
	 *															   0 
	 * And we want the last row to be 0 0...0 0 (m x 1's), which demical value is 0.
	 * dp[height - 1][0] is the final result.
	 */
	public static void solve(int height, int width) {
		if (height < width) {
			// Swap height, width.
			int swap = height;
			height = width;
			width = swap;
		}
		// 1 << width = 2^width, represents how many different ways to tile 1 x width.
		long[][] dp = new long[height][1 << width];
		for (int i = 0; i < height; ++i) {
			calc(i, 0, 0, dp, height, width);
		}
		System.out.println(dp[height - 1][0]);
	}

	private static void calc(int i, int j, int status, long[][] dp, int height, int width) {
		//System.out.println(String.format("i: %d j: %d status: %s", i, j, Integer.toBinaryString(status)));
		if (j > width) {
			return;	
		} else if (j == width) { // Done tiling this rw.
			if (i == 0) { // First row.
				++dp[i][status];
			} else { // Conpare to previous row and calc dp relationship.
				for (int k = 0; k < dp[i].length; ++k) {
					// (status ^ k) == status - k, what does this mean? For all different bits, bits in status are all 1's and bits in k are all 0's (no borrow during substraction)
					// meaning current row got 1 (vertical) then previous MUST be 1.
					// But using two 1's will be confusing so use 0 to mark as closure of vertical tile.
					// status is a valid piling for row i. and k is all possible piling for a row.
					if ((status ^ k) == status - k) {
						dp[i][status ^ k] += dp[i - 1][k]; // status ^ k, 1111 and 1100 -> 0011 1100
														   //									0011
					}
				}	
			}
		} else {
			calc(i, j + 1, (status << 1) + 1, dp, height, width); // left shit by 1 and add one meaning vertical pile.
			calc(i, j + 2, (status << 2), dp, height, width); // left shift by 2 meaning put two zeros at the end of status
		}
	}

	// Helper function.
	public static void print(long[] arr) {
		for (long i : arr) System.out.print(i + "\t");
		System.out.println();
	}

	public static void printMatrix(long[][] matrix) {
		for (long[] arr : matrix) print(arr);
		System.out.println();
	}

	// Recursion+backtracking.
	// Horizontal tile : 1, 1 and vertical tile 0
	//											1
	public static void dfs(int height, int width) {
		int[][] domino = new int[height][width];
		ArrayList<int[][]> all = new ArrayList<int[][]>();
		int i = 0, j = 0;
		dfsUtil(i, j, height, width, domino, all);
		System.out.println(String.format("height:%d Width:%d num:%s", height, width, all.size()));
	}

	public static void dfsUtil(int i,int j, int height, int width, int[][] domino, ArrayList<int[][]> all) {
		if (j == width) {
			// New row.
			dfsUtil(i + 1, 0, height, width, domino, all);
		} else if (i == height) {
			if (checkLastRow(domino)) {
				//printMatrix(domino);
				all.add(cloneMatrix(domino));
			}
		} else {
			// This spot has already been filled.
			// Do nothing and move to next.
			if (domino[i][j] == 1) {
				dfsUtil(i, j + 1, height, width, domino, all);	
			} else {
				// This spot has not been filled.
				if (j != width - 1 && domino[i][j + 1] == 0) {
					domino[i][j] = 1; // Fill it anyway.
					domino[i][j + 1] = 1;
					dfsUtil(i, j + 2, height, width, domino, all);
					domino[i][j] = 0;
					domino[i][j + 1] = 0;
				}
				if (i != height - 1) {
					domino[i + 1][j] = 1;
					dfsUtil(i, j + 1, height, width, domino, all);
					domino[i + 1][j] = 0;
				}
				// What if j == width - 1 && i == height - 1.
				// This domino can not be filled properly.
			}
		}
	}

	// Helper funciton to check the last row of domino if it's all filled.
	public static boolean checkLastRow(int[][] domino) {
		int row = domino.length;
		for (int i = 0; i < domino[row - 1].length; ++i) {
			if (domino[row -1][i] == 0) {
				return false;	
			}	
		}
		return true;
	}

	//
	public static void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}

	public static void printMatrix(int[][] matrix) {
		for (int[] arr : matrix) print(arr);
		System.out.println();
	}

	public static int[][] cloneMatrix(int[][] matrix) {
		int[][] ret = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[i].length; ++j) {
				ret[i][j] = matrix[i][j];
			}	
		}
		return ret;
	}
}
