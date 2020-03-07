/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 */

fn main() {
    assert!(Solution::is_perfect_square(16));
    assert!(!Solution::is_perfect_square(14));
}

struct Solution {}

impl Solution {
    pub fn is_perfect_square(num: i32) -> bool {
        let square: i32 = Self::sqrt(num);
        return num == square * square;
    }

    fn sqrt(x: i32) -> i32 {
        if x == 0 {
            return 0;
        }
        let mut res: i32 = 1;
        loop {
            if res <= x / res && res + 1 > x / (res + 1) {
                break; // res ^ 2 <= x && (res + 1) ^ 2 > x, res is the answer.
            } else if x / res >= 4 * res {
                res *= 2; // x > (2 * res) ^ 2, base can be doubled.
            } else {
                res += 1; // (res + 1)^ 2 < x < (2 * res) ^ 2. Very closed.
            }
        }
        return res;
    }
}
