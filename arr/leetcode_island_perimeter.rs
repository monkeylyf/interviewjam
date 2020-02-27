/**
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid
 * is completely surrounded by water, and there is exactly one island (i.e., one
 * or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the
 * water around the island). One cell is a square with side length 1. The grid
 * is rectangular, width and height don't exceed 100. Determine the perimeter of
 * the island.
 *
 * Example:
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 * Output: 16
 *
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 */

fn main() {
    let island1: Vec<Vec<i32>> = vec![
        vec![0,1,0,0],
        vec![1,1,1,0],
        vec![0,1,0,0],
        vec![1,1,0,0]];
    assert_eq!(16, Solution::island_perimeter(island1));
}

struct Solution {}

impl Solution {
    pub fn island_perimeter(grid: Vec<Vec<i32>>) -> i32 {
        let mut parimeter: i32 = 0;
        let length: i32 = grid.len() as i32;
        let width: i32 = grid[0].len() as i32;
        let direction: Vec<(i32, i32)> = vec![(1, 0), (-1, 0), (0, 1), (0, -1)];
        for (i, row) in grid.iter().enumerate() {
            let ii: i32 = i as i32;
            for (j, value) in row.iter().enumerate() {
                let jj: i32 = j as i32;
                if *value == 1 {
                    let mut surrounded: i32 = 0;
                    for (dx, dy) in &direction {
                        let xx: i32 = ii + dx;
                        let yy: i32 = jj + dy;
                        if 0 <= xx && xx < length && 0 <= yy && yy < width &&
                            grid[xx as usize][yy as usize] == 1 {
                            surrounded += 1
                        }
                    }
                    parimeter += 4 - surrounded;
                }
            }
        }
        return parimeter;
    }
}
