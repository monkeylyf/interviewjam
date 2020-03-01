/**
 * Given an integer, write an algorithm to convert it to hexadecimal. For
 * negative integer, two’s complement method is used.
 *
 * Note:
 *
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is
 * zero, it is represented by a single zero character '0'; otherwise, the first
 * character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed
 * integer.
 * You must not use any method provided by the library which converts/formats
 * the number to hex directly.
 *
 * Example 1:
 * Input:
 * 26
 * Output:
 * "1a"
 *
 * Example 2:
 * Input:
 * -1
 * Output:
 * "ffffffff"
 */

fn main() {
    assert_eq!("1a", Solution::to_hex(26));
    assert_eq!("ffffffff", Solution::to_hex(-1));
    assert_eq!("0", Solution::to_hex(0));
    assert_eq!("fffffffe", Solution::to_hex(-2));
}

struct Solution {}

impl Solution {
    pub fn to_hex(num: i32) -> String {
        if num == 0 {
            return "0".to_owned();
        }
        let mut i: u32 = if num >= 0 { num as u32 } else { ((std::i64::MAX + num as i64) + 1) as u32};
        let mut hex: Vec<char> = vec![];

        while i > 0 {
            let divident: u32 = i / 16;
            let remainder: u32 = i - divident * 16;
            hex.push(std::char::from_digit(remainder as u32, 16).unwrap());
            i = divident;
        }

        return hex.iter().rev().collect();
    }
}
