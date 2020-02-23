/**
 * Given a positive integer, output its complement number. The complement
 * strategy is to flip the bits of its binary representation.
 *
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed
 * integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 *
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits),
 * and its complement is 010. So you need to output 2.
 *
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and
 * its complement is 0. So you need to output 0.
 */

fn main() {
    assert_eq!(2, Solution::find_complement(5));
    assert_eq!(0, Solution::find_complement(1));
}

struct Solution {}

impl Solution {
    pub fn find_complement(num: i32) -> i32 {
        let mut base: i32 = 1;
        let mut i: i32 = num;
        let mut complement: i32 = 0;
        while i > 0 {
            let divident: i32 = i / 2;
            let remainder: i32 = i - divident * 2;
            i = divident;
            if remainder == 0 {
                complement += base;
            }
            base *= 2;
        }
        return complement;
    }
}
