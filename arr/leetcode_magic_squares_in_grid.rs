/**
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9
 * such that each row, column, and both diagonals all have the same sum.
 *
 * Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?
 * (Each subgrid is contiguous).
 *
 * Example 1:
 * Input: [[4,3,8,4],
 *         [9,5,1,9],
 *         [2,7,6,2]]
 * Output: 1
 * Explanation:
 * The following subgrid is a 3 x 3 magic square:
 * 438
 * 951
 * 276
 *
 * while this one is not:
 * 384
 * 519
 * 762
 *
 * In total, there is only one magic square inside the given grid.
 * Note:
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 */

fn main() {
    let input: Vec<Vec<i32>> = vec![
        vec![4, 3, 8, 4],
        vec![9, 5, 1, 9],
        vec![2, 7, 6, 2]];
    assert_eq!(1, Solution::num_magic_squares_inside(input));

    let input1: Vec<Vec<i32>> = vec![
        vec![10, 3, 5],
        vec![1, 6, 11],
        vec![7, 9, 2]];
    assert_eq!(0, Solution::num_magic_squares_inside(input1));
}

struct Solution {}

impl Solution {
    pub fn num_magic_squares_inside(grid: Vec<Vec<i32>>) -> i32 {
        if grid.len() < 3 as usize || grid[0].len() < 3 as usize {
            return 0;
        }
        let mut count: i32 = 0;
        for i in 0 as usize..grid.len() - 2 {
            let row: &Vec<i32> = &grid[i];
            for j in 0 as usize..row.len() - 2 {
                if Solution::is_magic_square(i, j, &grid) {
                    count += 1;
                }
            }
        }
        return count;
    }

    fn is_magic_square(i: usize, j: usize, grid: &Vec<Vec<i32>>) -> bool {
        let mut map: [u16; 10] = [0; 10];
        for ii in i..i + 3 {
            let mut row_sum: i32 = 0;
            for jj in j..j + 3 {
                let value: i32 = grid[ii][jj];
                if value > 9 || value < 1 {
                    return false;
                }
                row_sum += value;
                // Check uniqueness.
                let index: usize = value as usize;
                if map[index] > 0 {
                    return false;
                } else {
                    map[index] += 1;
                }
            }
            // Check row sum.
            if row_sum != 15 {
                return false;
            }
        }
        // Check column sum.
        for jj in j..j + 3 {
            let mut column_sum: i32 = 0;
            for ii in i..i + 3 {
                column_sum += &grid[ii][jj];
            }
            if column_sum != 15 {
                return false;
            }
        }
        // Check diagonals.
        if &grid[i][j] + &grid[i + 1][j + 1] + &grid[i + 2][j + 2] != 15 {
            return false;
        }
        if &grid[i][j + 2] + &grid[i + 1][j + 1] + &grid[i + 2][j] != 15 {
            return false;
        }
        return true;
    }
}
