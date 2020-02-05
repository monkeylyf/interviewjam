/**
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a
 * character c, the key might get long pressed, and the character will be typed
 * 1 or more times.
 *
 * You examine the typed characters of the keyboard.  Return True if it is
 * possible that it was your friends name, with some characters (possibly none)
 * being long pressed.
 *
 * Example 1:
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 *
 * Example 2:
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 *
 * Example 3:
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 *
 * Example 4:
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 *
 * Note:
 * name.length <= 1000
 * typed.length <= 1000
 * The characters of name and typed are lowercase letters.
 */

fn main() {
    assert!(Solution::is_long_pressed_name("alex".to_string(), "aaleex".to_string()));
    assert!(!Solution::is_long_pressed_name("saeed".to_string(), "ssaaedd".to_string()));
    assert!(Solution::is_long_pressed_name("leelee".to_string(), "lleeelee".to_string()));
    assert!(Solution::is_long_pressed_name("laiden".to_string(), "laiden".to_string()));
}

struct Solution {}

impl Solution {
    pub fn is_long_pressed_name(name: String, typed: String) -> bool {
        let mut i: usize = 0;
        let mut j: usize = 0;
        let name_chars: Vec<char> = name.chars().collect();
        let types_chars: Vec<char> = typed.chars().collect();
        while i < name.len() && j < typed.len() {
            if name_chars[i] != types_chars[j] {
                return false;
            }
            let ii: usize = Solution::next_different_char(i, &name_chars);
            let jj: usize = Solution::next_different_char(j, &types_chars);
            if (ii - i) > (jj - j) {
                return false;
            }
            i = ii;
            j = jj;
        }
        return i == name.len() && j == typed.len();
    }

    fn next_different_char(start: usize, chars: &Vec<char>) -> usize {
        let mut i: usize = start;
        while i < chars.len() - 1 && chars[i] == chars[i + 1] {
            i += 1;
        }
        return i + 1;
    }
}
