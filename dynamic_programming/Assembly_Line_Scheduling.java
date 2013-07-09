/*Assembly_Line_Scheduling
geeksforgeeks

Two assembly lines, 1 and 2, each with stations from 1 to n.
A car chassis must pass through all stations from 1 to n in order(in any of the
two assembly lines). i.e. it cannot jump from station i to station j if they are
not at one move distance.
The car chassis can move one station forward in the same line, or one station
diagonally in the other line. It incurs an extra cost ti, j to move to station
j from line i. No cost is incurred for movement in same line.
The time taken in station j on line i is ai, j.
Si,j represents a station j on line i.

What is minimum time it will take to build a car chassis?
*/

public class Assembly_Line_Scheduling {

	public static void main(String[] args) {
		// Test case 1.
		System.out.println(solve(new int[][] { { 4, 5, 3, 2 }, { 2, 10, 1, 4 } }, new int[][] {
				{ 0, 7, 4, 5 }, { 0, 9, 2, 8 } }, new int[] { 10, 12 },
				new int[] { 18, 7 }));
	}

	public static int solve(int[][] time, int[][] trans, int[] enter, int[] exit) {
		// Assume there is only two lines.
		final int NUM_LINE = 2;
		assert (time.length == NUM_LINE);
		assert (trans.length == NUM_LINE);
		assert (enter.length == NUM_LINE);
		assert (exit.length == NUM_LINE);

		// DP
		int n = time[0].length, i;
		int[][] dp = new int[NUM_LINE][n + 1];
		dp[0][0] = enter[0] + time[0][0]; // Time spent to leave the first
											// station
		dp[1][0] = enter[1] + time[1][0];
		for (i = 1; i < n; ++i) {
			dp[0][i] = Math.min(dp[0][i - 1], dp[1][i - 1] + trans[1][i])
					+ time[0][i];
			dp[1][i] = Math.min(dp[1][i - 1], dp[0][i - 1] + trans[0][i])
					+ time[1][i];
		}
		return Math.min(dp[0][n - 1] + exit[0], dp[1][n - 1] + exit[1]);
	}
}
