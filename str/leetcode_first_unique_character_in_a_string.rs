/**
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 *
 * Examples:
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */

fn main() {
    assert_eq!(0, Solution::first_uniq_char("leetcode".to_string()));
    assert_eq!(2, Solution::first_uniq_char("loveleetcode".to_string()));
}

struct Solution {}

impl Solution {
    pub fn first_uniq_char(s: String) -> i32 {
        let mut bit: [u16; 26] = [0; 26];
        for c in s.chars() {
            let index: u32 = c as u32 - 97;
            bit[index as usize] += 1;
        }
        for (i, c) in s.chars().enumerate() {
            let index: u32 = c as u32 - 97;
            if bit[index as usize] == 1 {
                return i as i32;
            }
        }
        return -1;
    }
}
