/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the
 * same element.
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 *
 * Example 1:
 * Input:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * Output: True
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 *
 * Example 2:
 * Input:
 * matrix = [
 *   [1,2],
 *   [2,2]
 * ]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 *
 * Note:
 * matrix will be a 2D array of integers.
 * matrix will have a number of rows and columns in range [1, 20].
 * matrix[i][j] will be integers in range [0, 99].
 *
 * Follow up:
 * What if the matrix is stored on disk, and the memory is limited such that you
 * can only load at most one row of the matrix into the memory at once?
 * What if the matrix is so large that you can only load up a partial row into
 * the memory at once?
 */

fn main() {
    let matrix: Vec<Vec<i32>> = vec![
        vec![1,2,3,4],
        vec![5,1,2,3],
        vec![9,5,1,2]
    ];
    assert!(Solution::is_toeplitz_matrix(matrix));
}

struct Solution {}

impl Solution {
    pub fn is_toeplitz_matrix(matrix: Vec<Vec<i32>>) -> bool {
        let length: usize = matrix.len();
        let width: usize = matrix[0].len();
        for i in 1..length {
            for j in 1..width {
                if matrix[i - 1][j - 1] != matrix[i][j] {
                    return false;
                }
            }
        }
        return true;
    }
}
