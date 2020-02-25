/**
 * Given a non-empty string check if it can be constructed by taking a substring
 * of it and appending multiple copies of the substring together. You may assume
 * the given string consists of lowercase English letters only and its length
 * will not exceed 10000.
 *
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 * Input: "aba"
 * Output: False
 *
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc"
 * twice.)
 */

fn main() {
    assert!(Solution::repeated_substring_pattern("abab".to_string()));
    assert!(!Solution::repeated_substring_pattern("aba".to_string()));
    assert!(Solution::repeated_substring_pattern("abcabcabcabc".to_string()));
}

struct Solution {}

impl Solution {

    /**
     * https://leetcode.com/problems/repeated-substring-pattern/discuss/94334/Easy-python-solution-with-explaination
     */
    pub fn repeated_substring_pattern(s: String) -> bool {
        if s.is_empty() {
            return false;
        } else {
            let twice: String = s.repeat(2);
            let truncated: &str = &twice[1..twice.len() -1];
            return truncated.contains(&s);
        }
    }
}
