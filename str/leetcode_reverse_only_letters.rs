/**
 * Given a string S, return the "reversed" string where all characters that are
 * not a letter stay in the same place, and all letters reverse their positions.
 *
 * Example 1:
 * Input: "ab-cd"
 * Output: "dc-ba"
 *
 * Example 2:
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 *
 * Example 3:
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 *
 * Note:
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S doesn't contain \ or "
 */

fn main() {
    assert_eq!("7_28]", Solution::reverse_only_letters("7_28]".to_string()));
    assert_eq!("", Solution::reverse_only_letters("".to_string()));
    assert_eq!("j-Ih-gfE-dCba", Solution::reverse_only_letters("a-bC-dEf-ghIj".to_string()));
    assert_eq!("dc-ba", Solution::reverse_only_letters("ab-cd".to_string()));
    assert_eq!("Qedo1ct-eeLg=ntse-T!", Solution::reverse_only_letters("Test1ng-Leet=code-Q!".to_string()));
}

struct Solution {}

impl Solution {
    pub fn reverse_only_letters(s: String) -> String {
        let length: usize = s.len();
        if length == 0 {
            return s;
        }
        let mut chars: Vec<char> = s.chars().collect();
        let mut i: usize = 0;
        let mut j: usize = length - 1;
        while i < j {
            while i < j && !chars[i].is_alphabetic() {
                i += 1;
            }
            while i < j && !chars[j].is_alphabetic() {
                j -= 1;
            }
            if i < j {
                let temp: char = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i += 1;
                j -= 1;
            } else {
                break;
            }

        }
        return chars.iter().collect();
    }
}
