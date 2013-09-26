/*Spiral_Matrix_II

Given an integer n, generate a square matrix filled with elements from 1 to n2
in spiral order.
For example,
Given n = 3,
You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/


public class leetcode_Spiral_Matrix_II {

    public static void main(String[] args) {

    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        drawLayer(res, 0, 0, n, 1);
        return res;
    }

    public static void drawLayer(int[][] res, int row, int col, int len, int num) {
        if (len < 0) {
            return;
        } else {
            for (int i = 0; i < len - 1; ++i) {
                // ->
                res[row][col + i] = num++;
            }
            for (int i = 0; i < len - 1; ++i) {
                // |
                // v
                res[row + i][col + len - 1] = num++;
            }
            for (int i = 0; i < len - 1; ++i) {
                // <-
                res[row + len - 1][col + len - 1 - i] = num++;
            }
            for (int i = 0; i < len - 1; ++i) {
                // up
                // |
                res[row + len - 1 - i][col] = num++;
            }
            drawLayer(res, row + 1, col + 1, len - 2, num);
        }
    }
}
