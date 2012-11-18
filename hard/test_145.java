/*Given an NxN matrix of positive and negative integers, write code to find the
sub-matrix with the largest possible sum*/

class test_145 {
	public static void main(String[] args) {
		int[][] input = {{1, 2, -3},
			  {3, -2, 1},
			  {1, -1, 1}};
		System.out.println(getMaxMatrix(input, 3, 3));
		int[][] input1 = {{1, 1, 1},
				  {-1, -1, -1},
				  {-2, -2, -2}};
		System.out.println(getMaxMatrix(input1, 3, 3));
		int[][] input2 = {{1, 2, -3},
			  	  {3, -2, 1},
			  	  {1, -1, 1},
			  	  {3, 0, 4}};
		System.out.println(getMaxMatrix(input2, 4, 3));
	}

	public static int getMaxMatrix(int[][] mtx, int n, int m) {
		int max = 0;
		for (int i = 0; i < n; ++i) {
			int[] shit = new int[n];
			for (int j = i; j < n; ++j) {
				for (int it = 0; it < m; ++it) shit[it] += mtx[j][it];
				int sum = 0;
				for (int len = 0; len < m; ++ len) {
					sum += shit[len];
					if (sum > max) max = sum;
					else if (sum < 0) sum = 0;
				}
			}
		}
		return max;
	}
}
