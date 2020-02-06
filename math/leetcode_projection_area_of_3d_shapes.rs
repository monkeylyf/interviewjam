/**
 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the
 * x, y, and z axes.
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid
 * cell (i, j).
 * Now we view the projection of these cubes onto the xy, yz, and zx planes.
 * A projection is like a shadow, that maps our 3 dimensional figure to a 2
 * dimensional plane.
 *
 * Here, we are viewing the "shadow" when looking at the cubes from the top, the
 * front, and the side.
 * Return the total area of all three projections.
 *
 * Example 1:
 * Input: [[2]]
 * Output: 5
 *
 * Example 2:
 * Input: [[1,2],[3,4]]
 * Output: 17
 * Explanation:
 * Here are the three projections ("shadows") of the shape made with each axis-aligned plane.
 *
 * Example 3:
 * Input: [[1,0],[0,2]]
 * Output: 8
 *
 * Example 4:
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 14
 *
 * Example 5:
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 21
 */

fn main() {
    assert_eq!(5, Solution::projection_area(vec![vec![2]]));
    assert_eq!(17, Solution::projection_area(vec![vec![1, 2], vec![3, 4]]));
    assert_eq!(8, Solution::projection_area(vec![vec![1, 0], vec![0, 2]]));
    assert_eq!(14, Solution::projection_area(vec![vec![1, 1, 1], vec![1, 0, 1], vec![1, 1, 1]]));
    assert_eq!(21, Solution::projection_area(vec![vec![2, 2, 2], vec![2, 1, 2], vec![2, 2, 2]]));
}

struct Solution {}

impl Solution {
    pub fn projection_area(grid: Vec<Vec<i32>>) -> i32 {
        let mut area: i32 = 0;
        for row in &grid {
            let max: &i32 = row.iter().max().unwrap();
            area += max;
            let non_zero: i32 = row.iter().filter(|x| *x > &0).count() as i32;
            area += non_zero;
        }
        let len: usize = grid[0].len();
        for i in 0..len {
            let mut local_max: i32 = -1;
            for j in 0 as usize..grid.len() {
                let val: i32 = grid[j][i];
                if local_max == -1 || val > local_max {
                    local_max = val;
                }
            }
            area += local_max;
        }
        return area;
    }
}
