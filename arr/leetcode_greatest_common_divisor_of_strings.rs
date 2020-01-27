/**
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T
 * (T concatenated with itself 1 or more times)
 * Return the largest string X such that X divides str1 and X divides str2.
 *
 * Example 1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 *
 * Example 2:
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 *
 * Example 3:
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 *
 * Note:
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] and str2[i] are English uppercase letters.
 */

fn main() {
    let a: String = "ABCABC".to_string();
    let b: String = "ABC".to_string();
    assert_eq!("ABC", Solution::gcd_of_strings(a, b));
}

struct Solution {}

impl Solution {
    pub fn gcd_of_strings(str1: String, str2: String) -> String {
        let small: &str = if str1.len() < str2.len() {
            &str1
        } else {
            &str2
        };
        let large: &str = if str1.len() < str2.len() {
            &str2
        } else {
            &str1
        };
        for i in (0..small.len()).rev() {
            if large.len() % (i + 1) == 0 && small.len() % (i + 1) == 0 {
                let unit: &str = &small[0..i + 1];
                if unit.repeat(large.len() / (i + 1)) == large {
                    return unit.to_string();
                }
            }
        }
        return "".to_string();
    }
}
