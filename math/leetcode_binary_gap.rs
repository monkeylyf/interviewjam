/**
 * Given a positive integer N, find and return the longest distance between two
 * consecutive 1's in the binary representation of N.
 *
 * If there aren't two consecutive 1's, return 0.
 *
 * Example 1:
 * Input: 22
 * Output: 2
 * Explanation:
 * 22 in binary is 0b10110.
 * In the binary representation of 22, there are three ones, and two consecutive
 * pairs of 1's.
 * The first consecutive pair of 1's have distance 2.
 * The second consecutive pair of 1's have distance 1.
 * The answer is the largest of these two distances, which is 2.
 *
 * Example 2:
 * Input: 5
 * Output: 2
 * Explanation:
 * 5 in binary is 0b101.
 *
 * Example 3:
 * Input: 6
 * Output: 1
 * Explanation:
 * 6 in binary is 0b110.
 *
 * Example 4:
 * Input: 8
 * Output: 0
 * Explanation:
 * 8 in binary is 0b1000.
 * There aren't any consecutive pairs of 1's in the binary representation of 8,
 * so we return 0.
 *
 * Note:
 * 1 <= N <= 10^9
 */

fn main() {
    assert_eq!(2, Solution::binary_gap(22));
    assert_eq!(2, Solution::binary_gap(5));
    assert_eq!(1, Solution::binary_gap(6));
    assert_eq!(0, Solution::binary_gap(8));
    assert_eq!(1, Solution::binary_gap(15));
}

struct Solution {}

impl Solution {
    pub fn binary_gap(n: i32) -> i32 {
        let mut gap: i32 = 0;
        let mut i: i32 = n;
        let mut prev: i32 = -1;
        let mut num_of_digit: i32 = 0;
        while i > 0 {
            if i % 2 != 0 {
                if prev != -1 && num_of_digit - prev > gap {
                    gap = num_of_digit - prev;
                }
                prev = num_of_digit;
            }
            i = i / 2;
            num_of_digit += 1;
        }
        return gap;
    }
}
