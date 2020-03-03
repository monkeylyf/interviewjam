/**
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * You may assume that there is only lower case English letters in both s and t.
 * t is potentially a very long (length ~= 500,000) string, and s is a short
 * string (<=100).
 *
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a
 * subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * Return true.
 *
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * Return false.
 *
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you
 * want to check one by one to see if T has its subsequence. In this scenario,
 * how would you change your code?
 *
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test cases.
 */

fn main() {
    assert!(Solution::is_subsequence("abc".to_string(), "ahbgdc".to_string()));
}

struct Solution {}

impl Solution {
    pub fn is_subsequence(s: String, t: String) -> bool {
        let mut s_chars: std::str::Chars = s.chars();
        let mut t_chars: std::str::Chars = t.chars();
        while let Some(sc) = s_chars.next() {
            let mut found: bool = false;
            while !found {
                if let Some(st) = t_chars.next() {
                    found = st == sc;
                } else {
                    return false;
                }
            }
            if !found {
                return false;
            }
        }
        return true;
    }
}
