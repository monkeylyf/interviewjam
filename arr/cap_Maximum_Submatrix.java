/*Maximum_Submatrix
careercup

Given an NxN matrix of positive and negative integers, write code to find the
sub-matrix with the largest possible sum
*/

class cap_Maximum_Submatrix {
	public static void main(String[] args) {
		int[][] input = {{1, 2, -3},
			  {3, -2, 1},
			  {1, -1, 1}};
		System.out.println(getMaxMatrix(input));
		int[][] input1 = {{1, 1, 1},
				  {-1, -1, -1},
				  {-2, -2, -2}};
		System.out.println(getMaxMatrix(input1));
		int[][] input2 = {{1, 2, -3},
			  	  {3, -2, 1},
			  	  {1, -1, 1},
			  	  {3, 0, 4}};
		System.out.println(getMaxMatrix(input2));
	}
	public static int getMaxMatrix(int[][] mtx) {
        // Brutal force: O(n^6): O(n^4) to traversal all possible submatrix and O(n^2) to compute the sum
        // O(n^3) as follow
        int n = mtx.length;
        int m = mtx[0].length;
		int max = 0;
        int[] accumulator;
		for (int i = 0; i < n; ++i) {
			accumulator = new int[n];
			for (int j = i; j < n; ++j) {
                // Given the submatrix with upper row [i] and lower row[n-1] and random left/right borders.
                // Calculate the maximum sum.
				for (int it = 0; it < m; ++it) {
                    accumulator[it] += mtx[j][it]; // accumulator the value along y axis.
                }
				int sum = 0; // Paradigm: Maximum subarray.
				for (int len = 0; len < m; ++len) {
					sum += accumulator[len];
					if (sum > max) {
                        max = sum;
                    } else if (sum < 0) {
                        sum = 0;
                    }
				}
			}
		}
		return max;
	}
}
