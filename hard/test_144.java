/*Imagine you have a square matrix, where each cell is filled with either black
or white. Design an algorithm to find the maximum subsquare such that all four
borders are filled with black pixels*/

class test_144 {
	public static void main(String[] args) {
		int[][] input = {
                         {1, 1, 0, 1, 1},
        				 {1, 1, 1, 1, 1},
				         {0, 1, 0, 0, 1},
				         {0, 1, 1, 0, 1},
				         {0, 1, 1, 1, 1}
                        };
		maxSubsquare(input, 5);
	}
	public static void maxSubsquare(int[][] m, int n) {
	    for (int l = n; l > 1; --l) {
		    for (int i = 0; i <= n - l; ++i) {
				for (int j = 0; j <= n - l; ++j) {
					boolean allOne = true;
					// (i, j) -> (i, j + l - 1) -> (i + l - 1, j) -> (i + l - 1, j + l - 1)
					for (int h = j; h < j + l; ++h) {
						if (m[i][h] != 1) {
							allOne = false;
							break;
						}
					}
					if (allOne) {
						for (int h = j; h < j + l; ++h) {
							if (m[i + l - 1][h] != 1) {
								allOne = false;
								break;
							}
						}
					}
					if (allOne) {
						for (int h = i; h < i + l; ++h) {
							if (m[h][j] != 1) {
								allOne = false;
								break;
							}
						}	
					}
					if (allOne) {
						for (int h = i; h < i + l; ++h) {
							if (m[h][j + l - 1] != 1) {
								allOne = false;
								break;
							}
						}	
					}
					if (allOne) {
						System.out.println("Largest square detected.");
						System.out.println("Coordicates of four corners are: ");
						System.out.println("(" + i + ", " + j + ")");
						System.out.println("(" + i + ", " + (j + l - 1) + ")");
						System.out.println("(" + (i + l -1) + ", " + j + ")");
						System.out.println("(" + (i + l -1) + ", " + (j + l -1) + ")");
						return;
					}
					else System.out.println("No square detected.");
				}
			}
		 }
	}
}
