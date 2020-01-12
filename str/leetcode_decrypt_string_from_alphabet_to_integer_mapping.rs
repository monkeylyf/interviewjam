/**
 * Given a string s formed by digits ('0' - '9') and '#' . We want to map s to
 * English lowercase characters as follows:
 *
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
 * Return the string formed after mapping.
 *
 * It's guaranteed that a unique mapping will always exist.
 *
 * Example 1:
 * Input: s = "10#11#12"
 * Output: "jkab"
 * Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 *
 * Example 2:
 * Input: s = "1326#"
 * Output: "acz"
 *
 * Example 3:
 * Input: s = "25#"
 * Output: "y"
 *
 * Example 4:
 * Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * Output: "abcdefghijklmnopqrstuvwxyz"
 */

fn main() {
    let s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
    assert_eq!("abcdefghijklmnopqrstuvwxyz", Solution::freq_alphabets(s.to_string()));
}

struct Solution {}

impl Solution {
    pub fn freq_alphabets(s: String) -> String {
        let chars: Vec<char> = s.chars().rev().collect();
        let mut decrypted: Vec<String> = Vec::new();
        let mut i: usize = 0;
        while i < chars.len() {
            match chars[i] {
                '#' => {
                    let num: String = chars[i + 1..i + 3].into_iter().rev().collect();
                    let decrypted_char = Solution::get_char(&num);
                    decrypted.push(decrypted_char);
                    i += 3;
                }
                _ => {
                    let decrypted_char = Solution::get_char(&chars[i].to_string());
                    decrypted.push(decrypted_char);
                    i += 1;
                }
            }
        }
        let rev: Vec<String> = decrypted.iter().cloned().rev().collect();
        return rev.join("");
    }

    fn get_char(s: &str) -> String {
        match s {
            "1" => "a".to_string(),
            "2" => "b".to_string(),
            "3" => "c".to_string(),
            "4" => "d".to_string(),
            "5" => "e".to_string(),
            "6" => "f".to_string(),
            "7" => "g".to_string(),
            "8" => "h".to_string(),
            "9" => "i".to_string(),
            "10" => "j".to_string(),
            "11" => "k".to_string(),
            "12" => "l".to_string(),
            "13" => "m".to_string(),
            "14" => "n".to_string(),
            "15" => "o".to_string(),
            "16" => "p".to_string(),
            "17" => "q".to_string(),
            "18" => "r".to_string(),
            "19" => "s".to_string(),
            "20" => "t".to_string(),
            "21" => "u".to_string(),
            "22" => "v".to_string(),
            "23" => "w".to_string(),
            "24" => "x".to_string(),
            "25" => "y".to_string(),
            "26" => "z".to_string(),
            _ => panic!("fuck this shit: {}", s)
        }
    }
}


/*
import string

mapping = {}
base = ord('a')
for char in string.ascii_lowercase:
    if char <= 'i':
        mapping[str(ord(char) - base + 1)] = char
    else:
        mapping[str(ord(char) - base + 1) + "#"] = char

class Solution:
    def freqAlphabets(self, s: str) -> str:

        i = len(s) - 1
        res = []
        while i >= 0:
            char = s[i]
            if char == '#':
                res.append(mapping[s[i - 2:i + 1]])
                i -= 3
            else:
                res.append(mapping[char])
                i -= 1
        return ''.join(res[::-1])
 */
