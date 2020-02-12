/**
 * Give a string s, count the number of non-empty (contiguous) substrings that
 * have the same number of 0's and 1's, and all the 0's and all the 1's in these
 * substrings are grouped consecutively.
 *
 * Substrings that occur multiple times are counted the number of times they
 * occur.
 *
 * Example 1:
 * Input: "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's
 * and 0's: "0011", "01", "1100", "10", "0011", and "01".
 *
 * Notice that some of these substrings repeat and are counted the number of
 * times they occur.
 *
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are
 * not grouped together.
 *
 * Example 2:
 * Input: "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal
 * number of consecutive 1's and 0's.
 *
 * Note:
 * s.length will be between 1 and 50,000.
 * s will only consist of "0" or "1" characters.
 */

use std::cmp::min;

fn main() {
    assert_eq!(6, Solution::count_binary_substrings("00110011".to_string()));
    assert_eq!(4, Solution::count_binary_substrings("10101".to_string()));
}

struct Solution {}

impl Solution {
    pub fn count_binary_substrings(s: String) -> i32 {
        let chars: Vec<char> = s.chars().collect();
        let mut acc = 0;
        let mut max_prev_sequence_length = 0;
        let mut max_cur_sequence_length = 1;
        for i in 1..s.len() {
            if chars[i - 1] != chars[i] {
                acc += min(max_prev_sequence_length, max_cur_sequence_length);
                max_prev_sequence_length = max_cur_sequence_length;
                max_cur_sequence_length = 1;
            } else {
                max_cur_sequence_length += 1;
            }
        }
        acc + min(max_prev_sequence_length, max_cur_sequence_length)
    }
}
