/**
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will
 * not be any extra space in the string.
 */

fn main() {
    assert_eq!("s'teL ekat edoCteeL tsetnoc",
               Solution::reverse_words("Let's take LeetCode contest".to_string()));
}

struct Solution {}

impl Solution {
    pub fn reverse_words(s: String) -> String {
        let mut reversed: Vec<char> = Vec::with_capacity(s.len());
        let mut i: usize = 0;
        let chars: Vec<char> = s.chars().collect();
        while i < s.len() {
            let c: char = chars[i];
            if chars[i] != ' ' {
                let mut j: usize = i; while j < s.len() && chars[j] != ' ' {
                    j += 1;
                }
                let end: usize = j;
                while j > i {
                    reversed.push(chars[j - 1]);
                    j -= 1;
                }
                i = end;
            } else {
                reversed.push(c);
                i += 1;
            }
        }
        return reversed.iter().collect();
    }
}
