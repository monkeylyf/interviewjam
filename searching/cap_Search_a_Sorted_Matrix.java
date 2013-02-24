/*Search_a_Sorted_Matrix
careercup

Given a matrix in which each row and each column is sorted, write a method to
find an element in it.

Mark as duplicate:
google_kth_Maximum_Element_in_Sorted_Matrix
*/

class cap_Search_a_Sorted_Matrix {
	public static void main(String[] args) {
		int[][] m = {{0, 5, 10, 15},
			     {1, 6, 11, 16},
			     {2, 7, 12, 17},
			     {3, 8, 13, 18},
			     {4, 9, 14, 19}};
		for (int i : findIndexOfMatrix(m, 18, 5, 4)) System.out.println(i);
		for (int i : findIndexOfMatrix(m, 13, 5, 4)) System.out.println(i);
		for (int i : findIndexOfMatrix(m, 9, 5, 4)) System.out.println(i);
		for (int i : findIndexOfMatrix(m, -9, 5, 4)) System.out.println(i);
	}
	public static int[] findIndexOfMatrix(int[][] m, int element, int M, int N) {
		int row = 0;
		int col = N - 1;
		while (row < M && col >= 0) {
			if (m[row][col] == element) return new int[] {row, col};
			else if (m[row][col] > element) --col;
			else ++row;
		}
		return new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
	}
}
