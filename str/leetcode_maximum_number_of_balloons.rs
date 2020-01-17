/**
 * Given a string text, you want to use the characters of text to form as many
 * instances of the word "balloon" as possible.
 *
 * You can use each character in text at most once. Return the maximum number of
 * instances that can be formed.
 *
 * Example 1:
 * Input: text = "nlaebolko"
 * Output: 1
 *
 * Example 2:
 * Input: text = "loonbalxballpoon"
 * Output: 2
 *
 * Example 3:
 * Input: text = "leetcode"
 * Output: 0
 *
 * Constraints:
 * 1 <= text.length <= 10^4
 * text consists of lower case English letters only.
 */

use std::cmp::min;
use std::collections::HashMap;
use std::i32::MAX;

fn main() {
    let text: String = "loonbalxballpoon".to_string();
    assert_eq!(2, Solution::max_number_of_balloons(text));
}

struct Solution {}

impl Solution {
    pub fn max_number_of_balloons(text: String) -> i32 {
        if text.len() < 7 {
            return 0;
        }
        let mut counter: HashMap<char, i32> = HashMap::new();
        for c in text.chars() {
            *counter.entry(c).or_insert(0) += 1;
        }
        let mut num: i32 = MAX;
        let pattern: Vec<(char, i32)> = vec![
            ('b', 1), ('a', 1), ('l', 2), ('o', 2), ('n', 1)];
        for (c, i) in pattern.iter() {
            let value: Option<&i32> = counter.get(c);
            if !value.is_some() {
                return 0;
            }
            num = min(num, value.unwrap() / i);
        }
        return num;
    }
}

/*
from collections import Counter

class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        a = Counter(text)
        one = {'b': 1, 'a': 1, 'l': 2, 'o': 2, 'n': 1}
        num = float('+inf')
        for i, c in one.items():
            d = a.get(i)
            if d is None:
                return 0
            num = min(num, d // c)
        return num
 */
