/**
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal,
 * switching the row and column indices of the matrix.
 *
 * Example 1:
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 *
 * Example 2:
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 *
 * Note:
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 */

fn main() {
    let matrix: Vec<Vec<i32>> = vec![
        vec![1, 2, 3],
        vec![4, 5, 6],
        vec![7, 8, 9]];
    let expected: Vec<Vec<i32>> = vec![
        vec![1, 4, 7],
        vec![2, 5, 8],
        vec![3, 6, 9]];
    assert_eq!(expected, Solution::transpose(matrix));

    let matrix1: Vec<Vec<i32>> = vec![
        vec![1, 2, 3],
        vec![4, 5, 6]];
    let expected1: Vec<Vec<i32>> = vec![
        vec![1, 4],
        vec![2, 5],
        vec![3, 6]];
    assert_eq!(expected1, Solution::transpose(matrix1));
}

struct Solution {}

impl Solution {
    pub fn transpose(a: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let row_length: usize = a.len();
        let column_length: usize = a[0].len();
        let mut matrix: Vec<Vec<i32>> = Vec::with_capacity(column_length);
        for _ in 0 as usize..column_length {
            matrix.push(vec![0; row_length]);
        }
        for (i, row) in a.iter().enumerate() {
            for (j, value) in row.iter().enumerate() {
                matrix[j][i] = *value;
            }
        }
        return matrix;
    }
}
