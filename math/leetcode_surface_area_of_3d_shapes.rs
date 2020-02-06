/**
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 *
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid
 * cell (i, j).
 * Return the total surface area of the resulting shapes.
 *
 * Example 1:
 * Input: [[2]]
 * Output: 10
 *
 * Example 2:
 * Input: [[1,2],[3,4]]
 * Output: 34
 *
 * Example 3:
 * Input: [[1,0],[0,2]]
 * Output: 16
 *
 * Example 4:
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 *
 * Example 5:
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 *
 * Note:
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 */

use std::cmp::min;

fn main() {
    assert_eq!(10, Solution::surface_area(vec![vec![2]]));
    assert_eq!(34, Solution::surface_area(vec![vec![1, 2], vec![3, 4]]));
    assert_eq!(16, Solution::surface_area(vec![vec![1, 0], vec![0, 2]]));
    assert_eq!(32, Solution::surface_area(vec![vec![1, 1, 1],
                                               vec![1, 0, 1],
                                               vec![1, 1, 1]]));
    assert_eq!(46, Solution::surface_area(vec![vec![2, 2, 2],
                                               vec![2, 1, 2],
                                               vec![2, 2, 2]]));
}

struct Solution {}


impl Solution {
    pub fn surface_area(grid: Vec<Vec<i32>>) -> i32 {
        let mut surface: i32 = 0;
        for (i, row) in grid.iter().enumerate() {
            for (j, value) in row.iter().enumerate() {
                let v: i32 = *value;
                if v == 0 {
                    continue;
                } else if v == 1 {
                    surface += 6;
                } else if v == 2 {
                    surface += 10;
                } else {
                    surface += value * 4 + 2;
                }
                // Abstract upper cube.
                if 0 < i {
                    surface -= 2 * min(*value, grid[i - 1][j]);
                }
                // Abstract left cube.
                if 0 < j {
                    surface -= 2 * min(*value, row[j - 1]);
                }
            }
        }
        return surface;
    }
}
