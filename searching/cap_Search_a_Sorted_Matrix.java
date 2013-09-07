/*Search_a_Sorted_Matrix
careercup

Given a matrix in which each row and each column is sorted, write a method to
find an element in it.

Please check:
google_kth_Maximum_Element_in_Sorted_Matrix.

These two questions are strongly-related.
*/

public class cap_Search_a_Sorted_Matrix {

	public static void main(String[] args) {
		// Test case.
		int[][] m = {
				 {1, 2, 6, 10},
			     {3, 4, 7, 13},
			     {5, 9, 11, 14},
			     {8, 12,15, 17}
				    };
		for (int i = 0; i < 20; ++i) {
			System.out.println(findIndexBinary(m, i));	
		}
	}

	// Divide and conquer. This solution requires recursion, which is not preferred.

	// Binary Search.
	public static boolean findIndexBinary(int[][] m, int target) {
		int row = m.length, col = m[0].length;
		// Starting from upperright.
		int rowCursor = 0, colCursor = col - 1, cur;
		while (rowCursor < row && colCursor >= 0) {
			cur = m[rowCursor][colCursor];
			if (cur == target) {
				return true;	
			} else if (cur > target) {
				--colCursor;
			} else { // cur < target
				++rowCursor;	
			}
		}
		return false;
	}
}
