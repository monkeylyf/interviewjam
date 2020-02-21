/**
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original.
 *
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */

fn main() {
    assert_eq!("bacdfeg", Solution::reverse_str("abcdefg".to_string(), 2));
}

struct Solution {}

impl Solution {
    pub fn reverse_str(s: String, k: i32) -> String {
        let length: usize = s.len();
        let mut reversed: Vec<char> = Vec::with_capacity(length);
        let mut i: usize = 0;
        let chars: Vec<char> = s.chars().collect();
        while i < length {
            let e: usize = std::cmp::min(i + k as usize, length);
            for j in (i..e).rev() {
                reversed.push(chars[j]);
            }
            let ee: usize = std::cmp::min(e + k as usize, length);
            for j in e..ee {
                reversed.push(chars[j]);
            }
            i = ee;
        }
        return reversed.iter().collect();
    }
}
