/**
 * Given n and m which are the dimensions of a matrix initialized by zeros and
 * given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci]
 * you have to increment all cells in row ri and column ci by 1.
 *
 * Return the number of cells with odd values in the matrix after applying the
 * increment to all indices.
 *
 * Example 1:
 * Input: n = 2, m = 3, indices = [[0,1],[1,1]]
 * Output: 6
 * Explanation: Initial matrix = [[0,0,0],[0,0,0]].
 * After applying first increment it becomes [[1,2,1],[0,1,0]].
 * The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
 *
 * Example 2:
 * Input: n = 2, m = 2, indices = [[1,1],[0,0]]
 * Output: 0
 * Explanation: Final matrix = [[2,2],[2,2]]. There is no odd number in the final matrix.
 *
 * Constraints:
 * 1 <= n <= 50
 * 1 <= m <= 50
 * 1 <= indices.length <= 100
 * 0 <= indices[i][0] < n
 * 0 <= indices[i][1] < m
 */

use std::collections::HashMap;

fn main() {
    let indices: Vec<Vec<i32>> = vec![vec![0, 1], vec![1, 1]];
    assert_eq!(6, Solution::odd_cells(2, 3, indices));
}

struct Solution {}

impl Solution {
    pub fn odd_cells(n: i32, m: i32, indices: Vec<Vec<i32>>) -> i32 {
        let mut x_counter: HashMap<i32, i32> = HashMap::new();
        let mut dx: i32 = 0;
        for point in &indices {
            let x: &i32 = point.get(0).unwrap();
            *x_counter.entry(*x).or_insert(0) += 1;
        }
        for (_key, value) in x_counter {
            if (value % 2).abs() == 1 {
                dx += 1;
            }
        }

        let mut y_counter: HashMap<i32, i32> = HashMap::new();
        let mut dy: i32 = 0;
        for point in &indices {
            let y: &i32 = point.get(1).unwrap();
            *y_counter.entry(*y).or_insert(0) += 1;
        }
        for (_key, value) in y_counter {
            if (value % 2).abs() == 1 {
                dy += 1;
            }
        }

        return dx * m + dy * (n - dx) - dx * dy;
    }
}

/*
from collections import Counter

class Solution:
    def oddCells(self, n: int, m: int, indices: List[List[int]]) -> int:
        dx = Counter(i for i, _ in indices)
        rows = sum(1 for val in dx.values() if val % 2 == 1)
        dy = Counter(j for _, j in indices)
        cols = sum(1 for val in dy.values() if val % 2 == 1)
        return rows * m + cols * (n - rows) - rows * cols
 */
