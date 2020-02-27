/**
 * Given a non-empty integer array of size n, find the minimum number of moves
 * required to make all array elements equal, where a move is incrementing n - 1
 * elements by 1.
 *
 * Example:
 * Input:
 * [1,2,3]
 * Output:
 * 3
 *
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */

fn main() {
    assert_eq!(3, Solution::min_moves(vec![1, 2, 3]));
}

struct Solution {}

impl Solution {
    /**
     * increament n - 1 is equivalent to decrease one by 1.
     */
    pub fn min_moves(nums: Vec<i32>) -> i32 {
        if nums.is_empty() {
            return 0;
        }
        let mut min: &i32 = &nums[0];
        let mut sum: i32 = nums[0];
        for i in &nums[1..] {
            sum += i;
            if i < min {
                min = i;
            }
        }
        return sum - min * nums.len() as i32;
    }
}
