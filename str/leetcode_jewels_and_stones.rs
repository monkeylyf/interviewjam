/**
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have.  Each character in S is a type of stone
 * you have. You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type of
 * stone from "A".
 *
 * Example 1:
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 *
 * Example 2:
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */

use std::collections::HashSet;

fn main() {
    assert_eq!(3, Solution::num_jewels_in_stones("aA".to_string(), "aAAbbbb".to_string()));
    assert_eq!(0, Solution::num_jewels_in_stones("z".to_string(), "ZZ".to_string()));
}

struct Solution {}

impl Solution {
    pub fn num_jewels_in_stones(j: String, s: String) -> i32 {
        let jewels: HashSet<char> = j.chars().into_iter().collect();
        return s.chars().into_iter().filter(|s| jewels.contains(s)).count() as i32;
    }
}
