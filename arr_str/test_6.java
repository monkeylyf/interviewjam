/*Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees	Can you do this in place?*/


class test_6 {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3}, {4,5,6},{7,8,9}};
		int[][] test1 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		int[][] test2 = {{1,2,3,4,5,6},
				 {7,8,9,10,11,12},
				 {13,14,15,16,17,18},
				 {19,20,21,22,23,24},
				 {25,26,27,28,29,30},
				 {31,32,33,34,35,36}};
		rotateMatrix(matrix, 3);
		rotateBy(matrix, 3);
		rotateMatrix(test1, 4);
		rotateMatrix(test2, 6);
	}

	public static void printMatrix(int[][] Matrix, int n) {
		for (int i = 0; i < n; ++i) {
			String output = "";
			for (int j = 0; j < n; ++j) {
				output += " " + Matrix[i][j]; 
			}
			System.out.println(output);
		}
	}

	public static void rotateMatrix(int[][] Matrix, int n) {
		int tmp;
		System.out.println("Orgincal matrix is:");
		printMatrix(Matrix,n);

		// Mirror rotation along (1, 1) -- (n,n)
		for (int i = 0; i < n; ++i) {
			for (int j = n - 1; j > i; --j) {
				// (a, b) ---> (b, a)
				tmp = Matrix[i][j];
				Matrix[i][j] = Matrix[j][i];
				Matrix[j][i] = tmp;
			}
		}
		System.out.println("After the 1st rotation  matrix is:");
		printMatrix(Matrix,n);

		// Mirror rotation along (1, n/2) -- (n, n/2)
		System.out.println("Done with rotation!");
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n/2; ++j) {
				tmp = Matrix[i][j];
				Matrix[i][j] = Matrix[i][n - 1 - j];
				Matrix[i][n - 1 - j] = tmp;
			}
		}
		System.out.println("After the 2nd rotation  matrix is:");
		printMatrix(Matrix,n);
	}

	public static void rotateBy(int[][] matrix, int n) {
		// Rotate by 180 degree
		for(int layer = 0; layer < n/2; ++layer) {
			int first = layer;
			int last = n - 1 -layer;
			for(int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i];// save top
			
				//left -> top
				matrix[first][i] = matrix[last-offset][first];
				//bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset];
				//right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				//top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
		printMatrix(matrix, n);
	}
}
