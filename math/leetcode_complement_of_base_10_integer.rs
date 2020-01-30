/**
 * Every non-negative integer N has a binary representation.  For example, 5 can
 * be represented as "101" in binary, 11 as "1011" in binary, and so on.  Note
 * that except for N = 0, there are no leading zeroes in any binary
 * representation.
 *
 * The complement of a binary representation is the number in binary you get
 * when changing every 1 to a 0 and 0 to a 1.  For example, the complement of
 * "101" in binary is "010" in binary.
 *
 * For a given number N in base-10, return the complement of it's binary
 * representation as a base-10 integer.
 *
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
 *
 * Example 2:
 * Input: 7
 * Output: 0
 * Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
 *
 * Example 3:
 * Input: 10
 * Output: 5
 * Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 *
 * Note:
 * 0 <= N < 10^9
 */

fn main() {
    assert_eq!(2, Solution::bitwise_complement(5));
    assert_eq!(0, Solution::bitwise_complement(7));
    assert_eq!(5, Solution::bitwise_complement(10));
    assert_eq!(1, Solution::bitwise_complement(0));
}

struct Solution {}

impl Solution {
    pub fn bitwise_complement(n: i32) -> i32 {
        if n == 0 {
            return 1;
        }
        let mut i: i32 = 0;
        let mut number: i32 = n;
        let mut base: i32 = 1;
        while number > 0 {
            let divident: i32 = number / 2;
            let remainder: i32 = number - divident * 2;
            if remainder == 0 {
                i += base;
            }
            base *= 2;
            number = divident;
        }
        return i;
    }
}
