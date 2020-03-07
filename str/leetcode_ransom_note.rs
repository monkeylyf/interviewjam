/**
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */

fn main() {
    assert!(!Solution::can_construct("a".to_string(), "b".to_string()));
    assert!(!Solution::can_construct("aa".to_string(), "ab".to_string()));
    assert!(Solution::can_construct("aa".to_string(), "aab".to_string()));
}

struct Solution {}

impl Solution {
    pub fn can_construct(ransom_note: String, magazine: String) -> bool {
        let mut bit: [u16; 26] = [0; 26];
        for c in magazine.chars() {
            let index: u32 = c as u32 - 97;
            bit[index as usize] += 1;
        }
        for c in ransom_note.chars() {
            let index: usize = (c as u32 - 97) as usize;
            if bit[index] == 0 {
                return false;
            } else {
                bit[index] -= 1;
            }
        }
        return true;
    }
}
