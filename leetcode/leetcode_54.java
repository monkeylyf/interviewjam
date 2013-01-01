/*Spiral matrix

Given a matrix of m x n elements (m rows, n columns), return all elements of
the matrix in spiral order.
For example,
Given the following matrix:
[
  [ 1, 2, 3 ],
  [ 4, 5, 6 ],
  [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

import java.util.ArrayList;


class leetcode_54 {
    public static void main(String[] args) {
        int[][] test = new int[2][1];
        test[0][0] = 3;
        test[1][0] = 2;
        spiralOrder(test);
    }
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) return res;
        int[][] onion = matrix;
        peelMatrix(onion, res);
        return res;
    }
    public static void peelMatrix(int[][] onion, ArrayList<Integer> res) {
        int row = onion.length;
        int col = onion[0].length;
        for (int i = 0; i < col; ++i) res.add(onion[0][i]);
        if (row > 1) {
            int[][] newOnion = new int[col][row - 1];
            for (int i = 0; i < row - 1; ++i) {
                for (int j = 0; j < col; ++j) {
                    newOnion[col - 1 - j][i] = onion[i + 1][j];
                }
            }
            peelMatrix(newOnion, res);
        }
    }
}
