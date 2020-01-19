/**
 *
 *
 */

use std::collections::HashMap;

fn main() {
    let words: Vec<String> = vec!["hello".to_string(),"world".to_string(),"leetcode".to_string()];
    let chars: String = "welldonehoneyr".to_string();
    assert_eq!(10, Solution::count_characters(words, chars));
}

struct Solution {}

impl Solution {
    pub fn count_characters(words: Vec<String>, chars: String) -> i32 {
        let counter: HashMap<char, i32> = Solution::count(&chars);
        let mut n: i32 = 0;
        for word in words {
            let mut sub_counter: HashMap<char, i32> = Solution::count(&word);
            if Solution::is_sub(&mut sub_counter, &counter) {
                n += word.len() as i32;
            }
        }
        return n;
    }

    fn is_sub(sub: &HashMap<char, i32>, full: &HashMap<char, i32>) -> bool {
        for (c, i) in sub {
            let value: Option<&i32> = full.get(c);
            if !value.is_some() {
                return false;
            } else if i > value.unwrap() {
                return false;
            }
        }
        return true;
    }

    fn count(word: &str) -> HashMap<char, i32> {
        // TODO: use i32 array [0; 256] is more efficient.
        let mut counter: HashMap<char, i32> = HashMap::new();
        for c in word.chars() {
            *counter.entry(c).or_insert(0) += 1;
        }
        return counter;

    }
}

