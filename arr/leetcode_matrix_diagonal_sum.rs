/**
 * Given a square matrix mat, return the sum of the matrix diagonals.
 *
 * Only include the sum of all the elements on the primary diagonal and all the
 * elements on the secondary diagonal that are not part of the primary diagonal.
 *
 * Example 1:
 * Input: mat = [[1,2,3],
 *               [4,5,6],
 *               [7,8,9]]
 * Output: 25
 * Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
 * Notice that element mat[1][1] = 5 is counted only once.
 *
 * Example 2:
 * Input: mat = [[1,1,1,1],
 *               [1,1,1,1],
 *               [1,1,1,1],
 *               [1,1,1,1]]
 * Output: 8
 *
 * Example 3:
 * Input: mat = [[5]]
 * Output: 5
 *
 * Constraints:
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 */

fn main() {
    assert_eq!(25, Solution::diagonal_sum(vec![vec![1, 2, 3], vec![4, 5, 6], vec![7, 8, 9]]));
    assert_eq!(8, Solution::diagonal_sum(vec![vec![1, 1, 1, 1], vec![1, 1, 1, 1], vec![1, 1, 1, 1], vec![1, 1, 1, 1]]));
    assert_eq!(55, Solution::diagonal_sum(vec![vec![7,3,1,9], vec![3,4,6,9], vec![6,9,6,6], vec![9,5,8,5]]));
}

struct Solution {}

impl Solution {
    pub fn diagonal_sum(mat: Vec<Vec<i32>>) -> i32 {
        let length: usize = mat.len();
        let mut sum: i32 = 0;
        for i in 0..length {
            let j = length - 1 - i;
            sum += mat[i][i];
            if i != j {
                sum += mat[j][i];
            }
        }
        return sum;
    }
}
