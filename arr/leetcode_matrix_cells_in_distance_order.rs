/**
 * We are given a matrix with R rows and C columns has cells with integer
 * coordinates (r, c), where 0 <= r < R and 0 <= c < C.
 *
 * Additionally, we are given a cell in that matrix with coordinates (r0, c0).
 *
 * Return the coordinates of all cells in the matrix, sorted by their distance
 * from (r0, c0) from smallest distance to largest distance.  Here, the distance
 * between two cells (r1, c1) and (r2, c2) is the Manhattan distance,
 * |r1 - r2| + |c1 - c2|.  (You may return the answer in any order that
 * satisfies this condition.)
 *
 * Example 1:
 * Input: R = 1, C = 2, r0 = 0, c0 = 0
 * Output: [[0,0],[0,1]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1]
 *
 * Example 2:
 * Input: R = 2, C = 2, r0 = 0, c0 = 1
 * Output: [[0,1],[0,0],[1,1],[1,0]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
 * The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
 *
 * Example 3:
 * Input: R = 2, C = 3, r0 = 1, c0 = 2
 * Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
 * There are other answers that would also be accepted as correct, such as
 * [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
 */

use std::cmp::max;

fn main() {
    assert_eq!(vec![vec![1,2], vec![0, 2], vec![1, 1], vec![0, 1], vec![1, 0], vec![0, 0]],
             Solution::all_cells_dist_order(2, 3, 1, 2));
}

struct Solution {}

impl Solution {
    pub fn all_cells_dist_order(r: i32, c: i32, r0: i32, c0: i32) -> Vec<Vec<i32>> {
        let mut distance: Vec<Vec<i32>> = Vec::with_capacity((r * c) as usize);
        let max_diagnoal: i32 = max(max(r0 + c0, r - r0 + c0), max(r - r0 + c - c0, r0 + c - c0));
        // Push original cell with distancec as 0.
        distance.push(vec![r0, c0]);
        for diagnoal in 1..=max_diagnoal {
            for x in r0 - diagnoal..=r0 {
                // Upper-to-left inclusive.
                let y = r0 + c0 - diagnoal - x;
                if 0 <= x && x < r && 0 <= y && y < c {
                    distance.push(vec![x, y]);
                }
                // Down-to-right inclusive.
                let xx: i32 = 2 * r0 - x;
                let yy: i32 = 2 * c0 - y;
                if 0 <= xx && xx < r && 0 <= yy && yy < c {
                    println!("{}: {}, {}", diagnoal, xx, yy);
                    distance.push(vec![xx, yy]);
                }
            }
            for x in r0 - diagnoal + 1..r0 {
                // Upper-to-right exclusive.
                let y = x - r0 + c0 + diagnoal;
                if 0 <= x && x < r && 0 <= y && y < c {
                    println!("{}: {}, {}", diagnoal, x, y);
                    distance.push(vec![x, y]);
                }
                // Down-to-left exclusive.
                let xx: i32 = 2 * r0 - x;
                let yy: i32 = 2 * c0 - y;
                if 0 <= xx && xx < r && 0 <= yy && yy < c {
                    println!("{}: {}, {}", diagnoal, xx, yy);
                    distance.push(vec![xx, yy]);
                }
            }
        }
        return distance;
    }
}
