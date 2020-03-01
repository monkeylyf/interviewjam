/**
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

use std::collections::HashMap;

fn main() {
    assert_eq!(7, Solution::longest_palindrome("abccccdd".to_string()));
}

struct Solution {}

impl Solution {
    pub fn longest_palindrome(s: String) -> i32 {
        let mut counter: HashMap<char, i32> = HashMap::new();
        for c in s.chars() {
            *counter.entry(c).or_insert(0) += 1;
        }

        let mut count: i32 = 0;
        let mut has_odd: bool = false;
        for i in counter.values() {
            if i % 2 == 0 {
                count += *i;
            } else {
                count += *i - 1;
                if !has_odd {
                    has_odd = true;
                }
            }
        }

        return if has_odd {count + 1} else {count};
    }
}
