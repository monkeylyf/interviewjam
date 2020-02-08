/**
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 ;*
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 *
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 *
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 */

fn main() {
    assert!(Solution::backspace_compare("ab#c".to_string(), "ad#c".to_string()));
    assert!(Solution::backspace_compare("ab##".to_string(), "c#d#".to_string()));
    assert!(Solution::backspace_compare("a##c".to_string(), "#a#c".to_string()));
    assert!(!Solution::backspace_compare("a#c".to_string(), "b".to_string()));
}

struct Solution {}

impl Solution {
    pub fn backspace_compare(s: String, t: String) -> bool {
        return Solution::get_str(&s) == Solution::get_str(&t);
    }

    fn get_str(s: &str) -> String {
        let mut stack: Vec<char> = vec![];
        for c in s.chars() {
            if c == '#' {
                if !stack.is_empty() {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack.iter().collect();
    }
}
