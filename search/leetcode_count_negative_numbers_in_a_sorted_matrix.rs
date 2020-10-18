/**
 * Given a m * n matrix grid which is sorted in non-increasing order both
 * row-wise and column-wise.
 *
 * Return the number of negative numbers in grid.
 *
 * Example 1:
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 *
 * Example 2:
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 *
 * Example 3:
 * Input: grid = [[1,-1],[-1,-1]]
 * Output: 3
 *
 * Example 4:
 * Input: grid = [[-1]]
 * Output: 1
 *
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 */

fn main() {
    let input: Vec<Vec<i32>> = vec![
        vec![4, 3, 2, -1],
        vec![3, 2, 1, -1],
        vec![1, 1, -1, -2],
        vec![-1, -1, -2, -3]
    ];
    assert_eq!(8, Solution::count_negatives(input));
}

struct Solution {}

impl Solution {
    pub fn count_negatives(grid: Vec<Vec<i32>>) -> i32 {
        let n: usize = grid.len();
        if n == 0 {
            return 0;
        }
        let m: usize = grid[0].len();
        if m == 0 {
            return 0;
        }
        let mut count: i32 = 0;
        let mut prev: usize = m - 1;
        for vec in &grid {
            if vec[0] < 0 {
                break;
            } else {
                prev = Solution::binary_search(prev, vec);
                count += prev as i32 + 1;
            }
        }
        return m as i32 * n as i32 - count;
    }

    fn binary_search(i: usize, row: &Vec<i32>) -> usize {
        if row[i] >= 0 {
            return i;
        }
        let mut start: usize = 0;
        let mut end: usize = i;
        let mut found = false;
        while !found && start < end {
            let mid: usize = (end - start) / 2 + start;
            if row[mid] >= 0 {
                found = start == mid;
                start = mid;
            } else {
                end = mid;
            }
        }
        start
    }
}
