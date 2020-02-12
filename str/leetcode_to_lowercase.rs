/**
 * Implement function ToLowerCase() that has a string parameter str, and returns
 * the same string in lowercase.
 *
 * Example 1:
 * Input: "Hello"
 * Output: "hello"
 *
 * Example 2:
 * Input: "here"
 * Output: "here"
 *
 * Example 3:
 * Input: "LOVELY"
 * Output: "lovely"
 */

fn main() {
    assert_eq!("hello", Solution::to_lower_case("Hello".to_string()));
    assert_eq!("here", Solution::to_lower_case("here".to_string()));
    assert_eq!("lovely", Solution::to_lower_case("LOVELY".to_string()));
}

struct Solution {}

impl Solution {
    pub fn to_lower_case(str: String) -> String {
        let mut chars: Vec<char> = Vec::with_capacity(str.len());
        for c in str.chars() {
            let ascii: u8 = c as u8;
            if 65 <= ascii && ascii <= 90 {
                chars.push((ascii + 32) as char);
            } else {
                chars.push(c);
            }
        }
        return chars.iter().collect();
    }
}
