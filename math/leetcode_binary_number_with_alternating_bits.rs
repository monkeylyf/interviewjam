/**
 * Given a positive integer, check whether it has alternating bits: namely, if
 * two adjacent bits will always have different values.
 *
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation:
 * The binary representation of 5 is: 101
 *
 * Example 2:
 * Input: 7
 * Output: False
 * Explanation:
 * The binary representation of 7 is: 111.
 *
 * Example 3:
 * Input: 11
 * Output: False
 * Explanation:
 * The binary representation of 11 is: 1011.
 *
 * Example 4:
 * Input: 10
 * Output: True
 * Explanation:
 * The binary representation of 10 is: 1010.
 */

fn main() {
    assert!(Solution::has_alternating_bits(5));
    assert!(!Solution::has_alternating_bits(7));
    assert!(Solution::has_alternating_bits(10));
}

struct Solution {}

impl Solution {
    pub fn has_alternating_bits(n: i32) -> bool {
        let mut base: i32 = n;
        let mut prev: i32 = -1;

        while base > 0 {
            let divident: i32 = base / 2;
            let remainer: i32 = base - divident * 2;
            if prev != -1 && prev == remainer {
                return false;
            }
            base = divident;
            prev = remainer;
        }
        return true;
    }
}
