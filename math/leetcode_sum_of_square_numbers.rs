/**
 * Given a non-negative integer c, your task is to decide whether there're two
 * integers a and b such that a2 + b2 = c.
 *
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 *
 * Example 2:
 * Input: 3
 * Output: False
 */

fn main() {
    assert!(Solution::judge_square_sum(8));
    assert!(Solution::judge_square_sum(5));
    assert!(Solution::judge_square_sum(4));
    assert!(!Solution::judge_square_sum(3));
}

struct Solution {}

impl Solution {
    pub fn judge_square_sum(c: i32) -> bool {
        let mut head: i32 = 0;
        let mut tail: i32 = (c as f64).sqrt() as i32;
        while head <= tail {
            let s: i32 = head * head + tail * tail;
            if s == c {
                return true;
            } else if s > c {
                tail -= 1;
            } else {
                head += 1;
            }
        }
        return false;
    }
}
