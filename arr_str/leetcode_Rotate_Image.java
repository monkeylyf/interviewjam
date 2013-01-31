/*Rotate_Image

You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Follow up:
Could you do this in-place?

1 2 3     7 4 1
4 5 6 --> 8 5 2
7 8 9     9 6 3
*/


class leetcode_Rotate_Image {
    public static void main(String[] args) {
    }
    public static void rotate(int[][] matrix) {
        // In-place solution.
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                // 1 2 3     1 4 7
                // 4 5 6 --> 2 5 8
                // 7 8 9     3 6 9
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int h = 0; h < n; ++h) {
            for (int k = 0; k < n / 2; ++k) {
                // 7 4 1      7 4 1
                // 8 5 2 -- > 8 4 2
                // 9 6 3      9 6 3
                int tmp = matrix[h][k];
                matrix[h][k] = matrix[h][n - 1 - k];
                matrix[h][n - 1 - k] = tmp;
            }
        }
    }
}
