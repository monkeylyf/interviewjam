/*Longest_Arithmetic_Pgrogression
geeksforgeeks
*/

public class Longest_Arithmetic_Pgrogression {

	/**
	 * Examples:
	 * 
	 * set[] = {1, 7, 10, 15, 27, 29}
	 * output = 3
	 * The longest arithmetic progression is {1, 15, 29}
	 * 
	 * set[] = {5, 10, 15, 20, 25, 30}
	 * output = 6 The whole set is in AP
	 */

	public static void main(String[] args) {
		// test case 1.
		System.out.println(LAP(new int[] {1, 7, 10, 13, 14, 19}));
		// test case 2.
		System.out.println(LAP(new int[] {1, 7, 10, 15, 27, 29}));
		// test case 3.
		System.out.println(LAP(new int[] {2, 4, 6, 8, 10}));
		// test case 4.
		System.out.println(LAP(new int[] {1}));
		// test case 5.
		System.out.println(LAP(new int[0]));
		// test case 6.
		System.out.println(LAP(new int[] {10, 0}));
	}
	
	public static int LAP(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		} else if (arr.length == 1) {
			return 1;
		}
		final int NUM = 0;
		final int CD = 1; // Common difference.
		int n = arr.length, ret = 2, localMax, localCD, i, j;
		// Init dp.
		int[][] dp = new int[2][n];
		dp[NUM][0] = 1;
		// DP
		for (i = 1; i < n; ++i) {
			localMax = 1;
			localCD = arr[i] - arr[0];
			for (j = 1; j <i; ++j) {
				if (arr[i] - arr[j] == dp[CD][j] && dp[NUM][j] > localMax) {
					localMax = dp[NUM][j];
					localCD = arr[i] - arr[j];
				}
			}
			dp[NUM][i] = localMax + 1;
			dp[CD][i] = localCD;
			ret = Math.max(ret, localMax + 1);
		}
		//print(dp[NUM]);
		//print(dp[CD]);
		return ret;
	}

	// helper function.	
	public static void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}

}
