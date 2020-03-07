/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = -2, b = 3
 * Output: 1
 */

fn main() {
    assert_eq!(2, Solution::get_sum(1, 2));
}

struct Solution {}

impl Solution {
    /**
     * https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary%3A-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
     * Copied solution which does not work yet. Though I don't give a shit about bit manipulation
     * questions.
     */
    pub fn get_sum(a: i32, b: i32) -> i32 {
        // Be careful about the terminating condition.
        if b == 0 { a} else { Self::get_sum(a ^ b, (a & b) << 1) }
    }
}
