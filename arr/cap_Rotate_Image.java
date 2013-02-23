/*Rotate_Image
careercup

Given an image represented by an NxN matrix, where each pixel in the image is
4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
place?


Mark as duplicate:
leetcode_Rotate_Image
*/

class cap_Rotate_Image {
	public static void main(String[] args) {
		int[][] test0 = {{1,2,3}, {4,5,6},{7,8,9}};
		int[][] test1 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		int[][] test2 = {{1,2,3,4,5,6},
				 {7,8,9,10,11,12},
				 {13,14,15,16,17,18},
				 {19,20,21,22,23,24},
				 {25,26,27,28,29,30},
				 {31,32,33,34,35,36}};
		//rotateMatrix(test0, 3);
		//rotateMatrix(test1, 4);
		//rotateMatrix(test2, 6);
		my(test0, 3);
		my(test1, 4);
		my(test2, 6);
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
	public static void my(int[][] m, int n) {
		int tmp;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				tmp = m[i][j];
				m[i][j] = m[j][i];
				m[j][i] = tmp;
			}
		}
		for (int h = 0; h < n; ++h) {
			for (int k = 0; k < n / 2; ++k) {
				tmp = m[h][k];
				m[h][k] = m[h][n - 1 - k];
				m[h][n - 1 - k] = tmp;
			}
		}
		printMatrix(m, n);
	}
}
