/**
 * Given two strings A and B of lowercase letters, return true if and only if we
 * can swap two letters in A so that the result equals B.
 *
 * Example 1:
 *
 * Input: A = "ab", B = "ba"
 * Output: true
 *
 * Example 2:
 * Input: A = "ab", B = "ab"
 * Output: false
 *
 * Example 3:
 * Input: A = "aa", B = "aa"
 * Output: true
 *
 * Example 4:
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 *
 * Example 5:
 * Input: A = "", B = "aa"
 * Output: false
 *
 * Note:
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 */

fn main() {
    assert!(Solution::buddy_strings("ab".to_string(), "ba".to_string()));
    assert!(!Solution::buddy_strings("ab".to_string(), "ab".to_string()));
    assert!(Solution::buddy_strings("aa".to_string(), "aa".to_string()));
    assert!(Solution::buddy_strings("aaaaaaabc".to_string(), "aaaaaaacb".to_string()));
    assert!(!Solution::buddy_strings("".to_string(), "aa".to_string()));
    assert!(!Solution::buddy_strings("ab".to_string(), "ac".to_string()));
    assert!(!Solution::buddy_strings("abcc".to_string(), "acbd".to_string()));
}

struct Solution {}

impl Solution {
    pub fn buddy_strings(a: String, b: String) -> bool {
        if a.len() != b.len() {
            return false;
        }

        let mut i: usize = 0;
        let mut aa: i32 = -1;
        let mut found_one_diff_pair: bool = false;
        let a_chars: Vec<char> = a.chars().into_iter().collect();
        let b_chars: Vec<char> = b.chars().into_iter().collect();
        let mut map: [u16; 26] = [0; 26];
        let mut found_same_chars: bool = false;
        while i < a.len() {
            let char_a: char = a_chars[i];
            let char_b: char = b_chars[i];
            if char_a != char_b {
                if found_one_diff_pair {
                    return false;
                } else if aa == -1 {
                    aa = i as i32;
                } else {
                    let prev: usize = aa as usize;
                    if a_chars[prev] == char_b && b_chars[prev] == char_a {
                        found_one_diff_pair = true;
                    } else {
                        return false;
                    }
                }
            } else if !found_same_chars {
                let ascii: u16 = char_a as u16 - 97;
                map[ascii as usize] += 1;
                if map[ascii as usize] > 1 {
                    found_same_chars = true;
                }
            }
            i += 1;
        }
        return found_one_diff_pair || (aa == -1 && found_same_chars);
    }
}
