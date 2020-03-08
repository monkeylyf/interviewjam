/**
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 *
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */

use std::cmp::max;

fn main() {
    assert_eq!(1, Solution::integer_break(2));
    assert_eq!(2, Solution::integer_break(3));
    assert_eq!(36, Solution::integer_break(10));
    assert_eq!(12, Solution::integer_break(7));
    assert_eq!(18, Solution::integer_break(8));
}

struct Solution {}

impl Solution {
    pub fn integer_break(n: i32) -> i32 {
        let mut dp: [i32; 59] = [0; 59];
        dp[2] = 1;
        for i in 3..=n {
            let index: usize = i as usize;
            for j in 1..=i {
                let local_max: i32 = max(i - j, dp[(i - j) as usize]);
                dp[index] = max(dp[index], j * local_max);
            }
        }
        return dp[n as usize];
    }
}
