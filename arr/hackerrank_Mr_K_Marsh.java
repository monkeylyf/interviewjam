/*hackrrank_Mr_K_Marsh

https://www.hackerrank.com/contests/101hack/challenges/mr-k-marsh
*/

import java.util.*;


class hackerrank_Mr_K_Marsh {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M, N, i;
		M = sc.nextInt();
		N = sc.nextInt();
		char[][] land = new char[M][N];
		for (i = 0; i < M ; ++i) {
			land[i]	= sc.next().toCharArray();
		}
		solve(M, N, land);
	}

	// Space complexity O(mn). Time complexity O(n^2 m)
	public static void solve(int M, int N, char[][] land) {
		int[][] range = new int[n][m];
		int MAX = 5000;
		int res = 0, lastCol, up, low, col;
		// Init range.
		// range[i][j] represents the smallest row index (i, j) can reach up to.
		for (up = 0; up < m; ++up) {
			range[0][up] = land[0][up] == '.' ? 0 : 5000;
		}
		for (up = 1; up < n; ++up) {
			for (col = 0; col < m; ++col) {
				range[up][col] = (land[up][col] == '.') ? Math.min(range[up - 1][col], up) : 5000;
			}
		}
		for (up = 0; up < n; ++up) {
			for (low = up + 1; low < n; ++low) {
				// Scanning all possible upper border and lower border.
				lastCol = -1;
				for (col = 0; col < m; ++col) {
					// Check col[i, j].
					if (land[up][col] == '.' && land[low][col] == '.') { // Two corners are '.'
						if (range[low][col] <= up) { // Col is all '.'
							if (lastCol != -1) {
								res = Math.max(res, 2 * (low - up - 1) + 2 * (col - lastCol + 1));
							} else { // Update last Col
								lastCol = col;
							}
						}
					} else { // Invalid col. Reset lastCol.
						lastCol = -1;
					}
				}
			}
		}
		if (res == 0) {
			System.out.println("impossible");
		} else {
			System.out.println(res);
		}
	}	
}
