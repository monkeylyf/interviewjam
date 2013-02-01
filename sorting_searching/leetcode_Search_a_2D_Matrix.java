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


class leetcode_Search_a_2D_Matrix {
    public static void main(String[] args) {
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Binary search for the specific row.
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
}
