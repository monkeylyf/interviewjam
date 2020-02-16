/**
 * Given an m * n matrix M initialized with all 0's and several update
 * operations.
 *
 * Operations are represented by a 2D array, and each operation is represented
 * by an array with two positive integers a and b, which means M[i][j] should be
 * added by one for all 0 <= i < a and 0 <= j < b.
 *
 * You need to count and return the number of maximum integers in the matrix
 * after performing all the operations.
 *
 * Example 1:
 * Input:
 * m = 3, n = 3
 * operations = [[2,2],[3,3]]
 * Output: 4
 * Explanation:
 * Initially, M =
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 *
 * After performing [2,2], M =
 * [[1, 1, 0],
 *  [1, 1, 0],
 *  [0, 0, 0]]
 *
 * After performing [3,3], M =
 * [[2, 2, 1],
 *  [2, 2, 1],
 *  [1, 1, 1]]
 *
 * So the maximum integer in M is 2, and there are four of it in M. So return 4.
 * Note:
 * The range of m and n is [1,40000].
 * The range of a is [1,m], and the range of b is [1,n].
 * The range of operations size won't exceed 10,000.
 */

fn main() {
    assert_eq!(4, Solution::max_count(3, 3, vec![vec![2, 2], vec![3, 3]]));
    assert_eq!(9, Solution::max_count(3, 3, vec![]));
}

struct Solution {}

impl Solution {
    pub fn max_count(m: i32, n: i32, ops: Vec<Vec<i32>>) -> i32 {
        let mut rows: Vec<i32> = vec![0; m as usize];
        let mut columns: Vec<i32> = vec![0; n as usize];
        for op in &ops {
            let x: usize = op[0] as usize - 1;
            let y: usize = op[1] as usize - 1;
            rows[x] += 1;
            columns[y] += 1;
        }
        let x: usize = rows.iter()
            .position(|x| *x > 0)
            .unwrap_or(m as usize - 1);
        let y: usize = columns.iter()
            .position(|x| *x > 0)
            .unwrap_or(n as usize - 1);
        return (x as i32 + 1) * (y as i32 + 1);
    }
}
