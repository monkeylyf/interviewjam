/*Search_a_2D_Matrix 

Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous
row.
For example,
Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

Given target = 3, return true.
*/


public class leetcode_Search_a_2D_Matrix {

	/**
	 * Please check ./cap_Search_a_Sorted_Matrix.java and it's clearer.
	 */

    public static void main(String[] args) {
        // There are three different ways to solve this problem.
        int[][] matrix = {{1, 2, 6, 10},
                          {3, 4, 7, 13},
                          {5, 9, 11, 14},
                          {8, 12, 15, 16}};
        //System.out.println(searchMatrix1(matrix, 0));
        System.out.println(searchMatrix1(new int[][] {{1, 3, 5, 7},
                                                      {10, 11, 16, 20},
                                                      {23, 30, 34, 50}}, 23));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // Binary search for the specific row.
        // O(logM*N)
        int start = 0;
        int end = matrix.length - 1;
        int row = 0;
        while (start <= end) {
            row = (start + end) / 2; // middle between start and end.
            if (target < matrix[row][0]) {
                // If target is less than first int of this row.
                end = row - 1;
            } else if (target > matrix[row][matrix[row].length - 1]) {
                // If target is larget than the last int of this row
                start = row + 1;
            } else {
                // target is larger than first int and less than last int of this row.
                break;
            }
        }
        // Binary search for the specific element Given a row.
        int rowStart = 0;
        int rowEnd = matrix[row].length - 1;
        while (rowStart <= rowEnd) {
            int middle = matrix[row][(rowStart + rowEnd) / 2];
            if (middle == target) {
                return true;
            } else if (middle > target) {
                rowEnd = (rowStart + rowEnd) / 2 - 1;
            } else {
                rowStart = (rowStart + rowEnd) / 2 + 1;
            }
        }
        return false;
    }

    public static boolean searchMatrix1(int[][] matrix, int target) {
        return matrixBinarySearch(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    public static boolean matrixBinarySearch(int[][] matrix, int target, int rHead, int rTail, int cHead, int cTail) {
        // 1 1 2 3 3     x < target search region 3,5,8 && 6,7 
        // 1 1 2 3 3     x > target search region 1,2,3 && 4,6
        // 4 4 x 5 5     x == target return true
        // 6 6 7 8 8
        // 6 6 7 8 8
        // O((mn)^(log4(3)))
        System.out.println(rHead + " " + rTail + " " + cHead + " " + cTail);
        if (rHead <= rTail && cHead <= cTail) {
            int rMid = (rHead + rTail) / 2;
            int cMid = (cHead + cTail) / 2;
            int middle = matrix[rMid][cMid];
            if (middle == target) {
                return true;
            }  else if (middle < target) {
                return matrixBinarySearch(matrix, target, rHead, rMid, cMid + 1, cTail) ||
                       matrixBinarySearch(matrix, target, rMid + 1, rTail, cHead, cTail);
            } else {
                // middle > target. Check three submatrix.
                return matrixBinarySearch(matrix, target, rHead, rMid - 1, cHead, cTail) ||
                       matrixBinarySearch(matrix, target, rMid, rTail, cHead, cMid - 1);
            }
        }
        return false;    
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        // Starting from matrix[0][n - 1]
        // Worst scenario O(m + n). I can't believe this passes Judge Large.
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length  && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                --col;
            } else {
                ++row;
            }
        }
        return false;
    }
}
