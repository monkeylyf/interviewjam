/*Set Matrix Zeroes

Given a m x n matrix, if an element is 0, set its entire row and column to 0.
Do it in place.
Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/


class leetcode_97 {
    public static void main(String[] args) {
    }
    public static void setZeroes(int[][] matrix) {
        boolean col = false;
        boolean row = false;
        int n = matrix[0].length;
        int m = matrix.length;
        for (int i = 0; i < n; ++i) {
            if (matrix[0][i] == 0) col = true;
        }
        for (int j = 0; j < m; ++j) {
            if (matrix[j][0] == 0) row = true;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int j = 1; j < m; ++j) {
            if (matrix[j][0] == 0) {
                for (int i = 1; i < n; ++i) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 1; i < n; ++i) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; ++j) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (row) {
            for (int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }
        if (col) {
            for (int i = 0; i < n; ++i) {
                matrix[0][i] = 0;
            }
        }
    }
}
