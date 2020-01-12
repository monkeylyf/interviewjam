/*
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 */


use std::collections::HashSet;


fn main() {
    let input = String::from("leetcode");
    assert_eq!("leotcede", Solution::reverse_vowels(input));

    let input2 = String::from("hello");
    assert_eq!("holle", Solution::reverse_vowels(input2));

    let input3 = String::from("a.");
    assert_eq!("a.", Solution::reverse_vowels(input3));

    let input3 = String::from("aA");
    assert_eq!("Aa", Solution::reverse_vowels(input3));

    let input4 = String::from(".,");
    assert_eq!(".,", Solution::reverse_vowels(input4));
}


struct Solution { }

impl Solution {
    pub fn reverse_vowels(s: String) -> String {
        if s.is_empty() {
            return s;
        }

        let vowels: HashSet<char> = vec![
            'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']
            .into_iter().collect();
        let mut chars: Vec<char> = s.chars().collect();

        let mut i: usize = 0;
        let mut j: usize = chars.len() - 1;

        while i < j {
            while i < chars.len() && !vowels.contains(&chars[i]) {
                i += 1;
            }

            while j > 0 as usize && !vowels.contains(&chars[j]) {
                // 0 as usize can not be decrement otherwise stackoverflow
                // And it is suffice to move to index 1 to end, instead of 0.
                j -= 1;
            }

            if i < j {
                let right: char = chars[j];
                chars[j] = chars[i];
                chars[i] = right;
                i += 1;
                j -= 1;
            }
        }

        let reversed: String = chars.into_iter().collect();
        return reversed;
    }
}
