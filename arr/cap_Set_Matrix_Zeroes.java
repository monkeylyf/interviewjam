/*Set_Matrix_Zeroes
careercup

Write an algorithm such that if an element in an MxN matrix is 0, its entire
row and column is set to 0


Mark as duplicate:
leetcode_Set_Matrix_Zeroes
*/
import java.util.*;


class cap_Set_Matrix_Zeroes {
	public static void main(String[] args) {
		long[][] test1 = {{-1,2,0,4}, 
				  {-5,6,7,8}, 
				  {9,0,11,12}};
		long[][] test2 = {{1,2,3,4,5,6},
		                 {7,8,9,10,11,12},
				 {13,14,0,16,17,18},
			         {0,20,21,22,23,24},
			         {31,32,33,34,35,36}};
		my(test1, 3,4);
		System.out.println("-------------");
		my(test2, 5,6);
	}

       public static void printMatrix(long[][] Matrix, int m, int n) {
               for (int i = 0; i < m; ++i) {
                       String output = "";
                       for (int j = 0; j < n; ++j) {output += " " + Matrix[i][j];}
                       System.out.println(output);
               }
        }

	public static void my(long[][] mtx , int m, int n) {
		boolean col = false, row = false;
		for (int i = 0; i < n; ++i) {if (mtx[0][i] == 0) col = true;}
		for (int j = 0; j < m; ++j) {if (mtx[j][0] == 0) row = true;}
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				if (mtx[i][j] == 0) {
					mtx[0][j] = 0;
					mtx[i][0] = 0;
				}
			}
		}
		for (int j = 1; j < m; ++j) {if (mtx[j][0] == 0) {for (int i = 1; i < n; ++i) {mtx[j][i] = 0;}}}
		for (int i = 1; i < n; ++i) {if (mtx[0][i] == 0) {for (int j = 1; j < m; ++j) {mtx[j][i] = 0;}}}
		if (row) {for (int i = 0; i < m; ++i) {mtx[i][0] = 0;}}
		if (col) {for (int i = 0; i < n; ++i) {mtx[0][i] = 0;}}
		printMatrix(mtx, m, n);
	}
}
