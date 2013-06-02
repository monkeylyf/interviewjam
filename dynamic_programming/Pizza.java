/*Pizza

Consider a row of n slices pizza of values v1 . . . vn, where n is even. We
want to as much pizza as possible by alternating turns. In each turn, a player
selects either the first or last pizza slice from the row, removes it from the row
permanently, and eat it. Determine the maximum possible amount of pizza we can
definitely win (by eating more than your opponent) if we pick first.
*/



class Pizza {
	public static void main(String[] args) {
		solve(new int[] {8, 15, 3, 7});		
		solve(new int[] {2, 2, 2, 2});		
		solve(new int[] {20, 30, 2, 2, 2, 10});		
	}

	public static void solve(int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n][n];
		int gap, i, j;
		for (gap = 0; gap < n; ++gap) {
			for (i = 0, j = gap; j < n; ++i, ++j) {
				// Vi, Vi+1...Vj-1, Vj is an array of pizza.
				
				// 1. You picked Vi
				// Then you opponent'd leave you min(dp(i+2,j), dp(i+1,j-1))
				// 2. You picked Vj
				// Then you opponent'd leave you min(dp(i+1,j-1), dp(i,j-2))
				
				if (j == i) {
					dp[i][j] = arr[i];
				} else if (j == i + 1) {
					dp[i][j] = Math.max(arr[i], arr[j]);
				} else {
					dp[i][j] = Math.max(arr[i] + Math.min(dp[i+2][j], dp[i+1][j-1]),
										arr[j] + Math.min(dp[i+1][j-1], dp[i][j-2]));	
				}
			}
		}
		printMatrix(dp);
		System.out.println("max: " + dp[0][n-1]);
	}

	public static void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}

	public static void printMatrix(int[][] m) {
		for (int[] i : m) print(i);
		System.out.println();
	}
}
