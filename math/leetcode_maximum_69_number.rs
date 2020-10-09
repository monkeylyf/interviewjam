/**
 * Given a positive integer num consisting only of digits 6 and 9.
 *
 * Return the maximum number you can get by changing at most one digit (6
 * becomes 9, and 9 becomes 6).
 *
 * Example 1:
 * Input: num = 9669
 * Output: 9969
 * Explanation:
 * Changing the first digit results in 6669.
 * Changing the second digit results in 9969.
 * Changing the third digit results in 9699.
 * Changing the fourth digit results in 9666.
 * The maximum number is 9969.
 *
 * Example 2:
 * Input: num = 9996
 * Output: 9999
 * Explanation: Changing the last digit 6 to 9 results in the maximum number.
 *
 * Example 3:
 * Input: num = 9999
 * Output: 9999
 * Explanation: It is better not to apply any change.
 *
 * Constraints:
 * 1 <= num <= 10^4
 * num's digits are 6 or 9.
 */

fn main() {
    assert_eq!(9969, Solution::maximum69_number(9669));
}

struct Solution {}

impl Solution {
    pub fn maximum69_number (num: i32) -> i32 {
        let mut index_of_first_6: i32 = -1;
        let mut n: i32 = num;
        let mut digit: i32 = 0;
        while n > 0 {
            let divident = n / 10;
            let remainder = n - divident * 10;
            if remainder == 6 {
                index_of_first_6 = digit;
            }
            n = divident;
            digit += 1;
        }
        if index_of_first_6 == -1 {
            num
        } else {
            num + 3 * 10_i32.pow(index_of_first_6 as u32)
        }
    }
}
