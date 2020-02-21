/**
 * Given a word, you need to judge whether the usage of capitals in it is right
 * or not.
 *
 * We define the usage of capitals in a word to be right when one of the
 * following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 *
 * Example 1:
 * Input: "USA"
 * Output: True
 *
 * Example 2:
 * Input: "FlaG"
 * Output: False
 *
 * Note: The input will be a non-empty word consisting of uppercase and
 * lowercase latin letters.
 */

fn main() {
    assert!(Solution::detect_capital_use("USA".to_string()));
    assert!(Solution::detect_capital_use("leetcode".to_string()));
    assert!(Solution::detect_capital_use("Google".to_string()));
    assert!(!Solution::detect_capital_use("FlaG".to_string()));
}

struct Solution {}

impl Solution {
    pub fn detect_capital_use(word: String) -> bool {
        if word.is_empty() {
            return true;
        }
        let mut iter = word.chars();
        let init: bool = iter.next().unwrap().is_uppercase();
        if init {
            let mut prev: Option<bool> = None;
            while let Some(c) = iter.next() {
                let is_uppercase: bool = c.is_uppercase();
                if prev.is_none() {
                    prev = Some(is_uppercase);
                } else if prev.unwrap() != is_uppercase {
                    return false;
                }
            }
            return true;
        } else {
            while let Some(c) = iter.next() {
                if c.is_uppercase() {
                    return false;
                }
            }
            return true;
        }
    }
}
