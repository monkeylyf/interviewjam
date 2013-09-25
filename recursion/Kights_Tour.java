/*Kights_Tour

http://en.wikipedia.org/wiki/Knight%27s_tour
*/

public class Kights_Tour {

	// Eight different directions for Kight to move.
	static final int[][] shifts = new int[][] {{1, 2}, {2, 1},
											   {2, -1}, {1, -2},
											   {-1, -2}, {-2, -1},
											   {-2, 1}, {-1, 2}
											  };

	public static void main(String[] args) {
		solve(8, 0, 0);
		solve(8, 0, 4);
	}
	
	public static void solve(int n, int x, int y) {
		int[][] path = new int[n][n];
		if (jump(path, 1, x, y, n)) {
			printMatrix(path);
		} else {
			System.out.println("impossible");
		}
	}
	
	public static boolean jump(int[][] path, int idx, int x, int y, int n) {
		if (idx == n * n + 1) {
			return true; // index begins with 1. n * n is the last to fill. End with n^2 + 1.
		} else if (x < 0 || x >= n || y < 0 || y >= n || path[x][y] != 0) {
			return false; // Index out of boundary, Prune.
		} else {
			path[x][y] = idx; // Set status.
			for (int[] shift : shifts) {
				if (jump(path, idx + 1, x + shift[0], y + shift[1], n)) {
					return true;
				}
			}
			path[x][y] = 0; // Reset. Backtracking.
			return false;
		}
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
