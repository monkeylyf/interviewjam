/*Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0*/
import java.util.*;


class test_7 {
	public static void main(String[] args) {
		long[][] test1 = {{-1,2,0,4}, {-5,6,7,8}, {9,0,11,12}};
		long[][] test2 = {{1,2,3,4,5,6},
		                 {7,8,9,10,11,12},
				 {13,14,0,16,17,18},
			         {0,20,21,22,23,24},
			         {31,32,33,34,35,36}};
		bruteForce(test1, 3,4);
		bruteForce(test2, 5,6);
	}

       public static void printMatrix(long[][] Matrix, int m, int n) {
               for (int i = 0; i < m; ++i) {
                       String output = "";
                       for (int j = 0; j < n; ++j) {
                               output += " " + Matrix[i][j];
                       }
                       System.out.println(output);
               }
       }

	public static void bruteForce(long[][] matrix, int m, int n) {
		System.out.println("Original input is:");
		printMatrix(matrix,m,n);
		int[] row = new int[m];
		int[] col = new int[n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if(matrix[i][j] == 0) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		for (int i = 0; i < m; ++i) {
			if (row[i] == 1) {
				// Setting all element in row i to 0. 
				for (int j = 0; j < n; ++j) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < n; ++i) {
			if (col[i] == 1) {
				// Setting all element in col i to 0. 
				for (int j = 0; j < m; ++j) {
					matrix[j][i] = 0;
				}
			}
		}
		System.out.println("Final output is:");
		printMatrix(matrix,m,n);
	}
}
