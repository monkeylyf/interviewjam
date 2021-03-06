/**
 * Given two strings s and t which consist of only lowercase letters.
 *
 * String t is generated by random shuffling string s and then add one more
 * letter at a random position.
 *
 * Find the letter that was added in t.
 *
 * Example:
 * Input:
 * s = "abcd"
 * t = "abcde"
 *
 * Output:
 * e
 *
 * Explanation:
 * 'e' is the letter that was added.
 */

fn main() {
    assert_eq!('e', Solution::find_the_difference("abcd".to_string(), "abcde".to_string()));
}

struct Solution {}


impl Solution {
    pub fn find_the_difference(s: String, t: String) -> char {
        let mut bit: [i32; 26] = [0; 26];
        for c in t.chars() {
            let i: u32 = c as u32 - 97;
            bit[i as usize] += 1;
        }
        for c in s.chars() {
            let i: u32 = c as u32 - 97;
            bit[i as usize] -= 1;
        }
        for (i, value) in bit.iter().enumerate() {
            if *value > 0 {
                return (i as u8 + 97) as char;
            }
        }
        return ' ';
    }
}
