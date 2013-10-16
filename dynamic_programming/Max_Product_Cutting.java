/*Max_Product_Cutting


Given a rope of length n meters, cut the rope in different parts of integer
lengths in a way that maximizes product of lengths of all parts. You must make
at least one cut. Assume that the length of rope is more than 2 meters.
*/

public class Max_Product_Cutting {
	
	public static void main(String[] args) {
		System.out.println(solve(2));
		System.out.println(solve(3));
		System.out.println(solve(4));
		System.out.println(solve(5));
		System.out.println(solve(10));
	}

	public static int solve(int len) {
		assert(len >= 2);
		// - - - - - - a rope of length 6.
		//  1 2 3 4 5 6
		//
		int i, j;
		// Init dp state.
		int[] dp = new int[len + 1];
		dp[1] = 1;
		// dp.
		for (i = 2; i <= len; ++i) {
			for (j = 1; j <= i / 2; ++j) {
				dp[i] = Math.max(dp[i], dp[i - j] * j); // Two cuts, one between j and i-j and another within i-j 
				dp[i] = Math.max(dp[i], j * (i - j)); // One cut between j and i-j.
			}
		}
		print(dp);
		return dp[len];
	}

	// Helper function.
	public static int max(int[] arr, int i, int j) {
		int ret = Integer.MIN_VALUE;
		for (; i <=j; ++i) {
			ret = (ret < arr[i]) ? arr[i] : ret;	
		}
		return ret;
	}

	public static void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
}
