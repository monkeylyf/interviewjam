/**
 * Given a non-empty string s, you may delete at most one character. Judge
 * whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of
 * the string is 50000.
 */

fn main() {
    assert!(Solution::valid_palindrome("aba".to_string()));
    assert!(Solution::valid_palindrome("abca".to_string()));
}

struct Solution {}

impl Solution {
    pub fn valid_palindrome(s: String) -> bool {
        let chars: Vec<char> = s.chars().collect();
        let mut head: usize = 0;
        let mut tail: usize = chars.len() - 1;
        while head < tail {
            if chars[head] == chars[tail] {
                head += 1;
                tail -= 1;
            } else {
                return Solution::is_palindrome(head + 1, tail, &chars) ||
                       Solution::is_palindrome(head, tail - 1, &chars);
            }
        }
        return true;
    }

    fn is_palindrome(h: usize, t: usize, chars: &Vec<char>) -> bool {
        let mut head = h;
        let mut tail = t;
        while head < tail {
            if chars[head] != chars[tail] {
                return false;
            }
            head += 1;
            tail -= 1;
        }
        return true;
    }
}
