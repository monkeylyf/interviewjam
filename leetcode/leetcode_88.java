/*Rotate Image

You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Follow up:
Could you do this in-place?
*/


class leetcode_88 {
    public static void main(String[] args) {
    }
    public static void rotate(int[][] matrix) {
        int tmp;
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int h = 0; h < n; ++h) {
            for (int k = 0; k < n / 2; ++k) {
                tmp = matrix[h][k];
                matrix[h][k] = matrix[h][n - 1 - k];
                matrix[h][n - 1 - k] = tmp;
            }
        }
    }
}
