/**
 * In MATLAB, there is a very useful function called 'reshape', which can
 * reshape a matrix into a new one with different size but keep its original
 * data.
 *
 * You're given a matrix represented by a two-dimensional array, and two
 * positive integers r and c representing the row number and column number of
 * the wanted reshaped matrix, respectively.
 *
 * The reshaped matrix need to be filled with all the elements of the original
 * matrix in the same row-traversing order as they were.
 *
 * If the 'reshape' operation with given parameters is possible and legal,
 * output the new reshaped matrix; Otherwise, output the original matrix.
 *
 * Example 1:
 * Input:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4
 * matrix, fill it row by row by using the previous list.
 *
 * Example 2:
 * Input:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * Output:
 * [[1,2],
 *  [3,4]]
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the
 * original matrix.
 *
 * Note:
 * The height and width of the given matrix is in range [1, 100].
 * The given r and c are all positive.
 */

fn main() {
    println!("{:?}", Solution::matrix_reshape(vec![vec![1, 2], vec![3, 4]], 1, 4));
    println!("{:?}", Solution::matrix_reshape(vec![vec![1, 2], vec![3, 4]], 4, 1));
}

struct Solution {}

impl Solution {
    pub fn matrix_reshape(nums: Vec<Vec<i32>>, r: i32, c: i32) -> Vec<Vec<i32>> {
        let length: usize = nums.len();
        let width: usize = nums[0].len();
        if length * width < (r * c) as usize {
            return nums;
        }
        let rr: usize = r as usize;
        let cc: usize = c as usize;
        let mut i: usize = 0;
        let mut j: usize = 0;
        let mut reshaped: Vec<Vec<i32>> = vec![vec![0; cc]; rr];
        for row in &nums {
            for value in row {
                reshaped[i][j] = value.to_owned();
                j += 1;
                if j >= cc {
                    i += 1;
                    j = 0;
                }
            }
        }
        return reshaped;
    }
}
