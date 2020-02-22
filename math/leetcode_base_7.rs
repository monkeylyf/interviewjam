/**
 * Given an integer, return its base 7 string representation.
 *
 * Example 1:
 * Input: 100
 * Output: "202"
 *
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 */

fn main() {
    assert_eq!("202", Solution::convert_to_base7(100));
    assert_eq!("-10", Solution::convert_to_base7(-7));
    assert_eq!("0", Solution::convert_to_base7(0));
}

struct Solution {}

impl Solution {
    pub fn convert_to_base7(num: i32) -> String {
        if num == 0 {
            return "0".to_string();
        }
        let mut acc: Vec<char> = vec![];
        let mut i: i32 = num.abs();
        while i > 0 {
            let divident: i32 = i / 7;
            let remainder: i32 = i - divident * 7;
            acc.push(std::char::from_digit(remainder as u32, 10).unwrap());
            i = divident;
        }
        if num < 0 {
            acc.push('-');
        }
        return acc.iter().rev().collect();
    }
}
