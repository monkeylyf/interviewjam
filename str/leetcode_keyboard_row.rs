/**
 * Given a List of words, return the words that can be typed using letters of
 * alphabet on only one row's of American keyboard like the image below.
 *
 * Example:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 *
 *
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 */

use std::collections::HashSet;

static FIRST: &'static [char] = &['q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'];
static SECOND: &'static [char] = &['a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'];
static THIRD: &'static [char] = &['z', 'x', 'c', 'v', 'b', 'n', 'm'];

fn main() {
    assert_eq!(vec!["Alaska", "Dad"], Solution::find_words(
            vec!["Hello".to_string(), "Alaska".to_string(), "Dad".to_string(), "Peace".to_string()]));
}

struct Solution {}

impl Solution {
    pub fn find_words(words: Vec<String>) -> Vec<String> {
        let first: HashSet<&char> = FIRST.iter().collect();
        let second: HashSet<&char> = SECOND.iter().collect();
        let third: HashSet<&char> = THIRD.iter().collect();
        let mut res: Vec<String> = vec![];
        for word in &words {
            if Solution::is(&first, word) ||
                Solution::is(&second, word) ||
                Solution::is(&third, word) {
                res.push(word.to_owned());
            }
        }
        return res;
    }

    fn is(set: &HashSet<&char>, word: &str) -> bool {
        let lower = word.to_lowercase();
        let mut iter = lower.chars();
        while let Some(cc) = iter.next() {
            if !set.contains(&cc) {
                return false;
            }
        }
        return true;
    }
}
