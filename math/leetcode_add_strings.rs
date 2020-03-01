/**
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 *
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 */

use std::char::from_digit;

fn main() {
    assert_eq!("579", Solution::add_strings("123".to_string(), "456".to_string()));
    assert_eq!("1110", Solution::add_strings("999".to_string(), "111".to_string()));
    assert_eq!("108", Solution::add_strings("99".to_string(), "9".to_string()));
}

struct Solution {}

impl Solution {
    pub fn add_strings(num1: String, num2: String) -> String {
        let mut sum: Vec<char> = Vec::with_capacity(std::cmp::max(num1.len(), num2.len() + 1));
        let mut num1_rev = num1.chars().rev();
        let mut num2_rev = num2.chars().rev();
        let mut carry: bool = false;
        let mut both = true;
        while both {
            match (num1_rev.next(), num2_rev.next()) {
                (Some(a), Some(b)) => carry = Self::sum_two(a, b, carry, &mut sum),
                (Some(a), None) => carry = Self::sum_one(a, carry, &mut sum),
                (None, Some(a)) => carry = Self::sum_one(a, carry, &mut sum),
                (None, None) => both = false,
            }
        }

        if carry {
            sum.push('1');
        }
        return sum.iter().rev().collect();
    }

    fn sum_two(a: char, b: char, carry: bool, sum: &mut Vec<char>) -> bool {
        let (to_carry, digit) = Self::sum(a, b);
        if carry {
            if digit == 9 {
                sum.push('0');
                return true;
            } else {
                sum.push(from_digit(digit + 1, 10).unwrap());
                return to_carry;
            }
        } else {
            sum.push(from_digit(digit, 10).unwrap());
            return to_carry;
        }
    }

    fn sum_one(a: char, carry: bool, sum: &mut Vec<char>) -> bool {
        let aa: u32 = a as u32 - 48;
        if carry {
            if aa == 9 {
                sum.push('0');
                return true;
            } else {
                sum.push(from_digit(aa + 1, 10).unwrap());
                return false;
            }
        } else {
            sum.push(from_digit(aa, 10).unwrap());
            return false;
        }
    }

    fn sum(a: char, b: char) -> (bool, u32) {
        let aa: u32 = a as u32 - 48;
        let bb: u32 = b as u32 - 48;
        if aa + bb >= 10 {
            return (true, aa + bb - 10);
        } else {
            return (false, aa + bb);
        }
    }
}
