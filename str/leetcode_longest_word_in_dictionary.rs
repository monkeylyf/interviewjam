/**
 * Given a list of strings words representing an English Dictionary, find the
 * longest word in words that can be built one character at a time by other
 * words in words. If there is more than one possible answer, return the longest
 * word with the smallest lexicographical order.
 *
 * If there is no answer, return the empty string.
 *
 * Example 1:
 * Input:
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor",
 * and "worl".
 *
 * Example 2:
 * Input:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation:
 * Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 * Note:
 *
 * All the strings in the input will only contain lowercase letters.
 * The length of words will be in the range [1, 1000].
 * The length of words[i] will be in the range [1, 30].
 */

use std::collections::HashMap;

fn main() {
    assert_eq!("world", Solution::longest_word(
            vec![
            "w".to_string(),
            "wo".to_string(),
            "wor".to_string(),
            "worl".to_string(),
            "world".to_string()]));

    assert_eq!("apple", Solution::longest_word(
            vec![
            "a".to_string(),
            "banana".to_string(),
            "app".to_string(),
            "appl".to_string(),
            "ap".to_string(),
            "apply".to_string(),
            "apple".to_string()]));

    assert_eq!("latte", Solution::longest_word(
            vec![
            "m".to_string(),
            "mo".to_string(),
            "moc".to_string(),
            "moch".to_string(),
            "mocha".to_string(),
            "l".to_string(),
            "la".to_string(),
            "lat".to_string(),
            "latt".to_string(),
            "latte".to_string(),
            "c".to_string(),
            "ca".to_string(),
            "cat".to_string()]));
}

struct Solution {}

impl Solution {
    pub fn longest_word(words: Vec<String>) -> String {
        let counter: HashMap<usize, Vec<String>> = Solution::get_by_length(&words);
        let mut acc: Vec<String> = vec![];
        Solution::dfs("", &counter, &mut acc);
        let min: Option<&String> = acc.iter().min();
        return if min.is_some() {
            min.unwrap().to_string()
        } else {
            "".to_string()
        };
    }

    fn dfs(prev: &str, counter: &HashMap<usize, Vec<String>>, acc: &mut Vec<String>) {
        let next_length: usize = prev.len() + 1;
        let strings: Option<&Vec<String>> = counter.get(&next_length);
        if strings.is_some() {
            let next_words: Vec<&String> = strings.unwrap().iter()
                .filter(|x| x.starts_with(prev))
                .collect();
            if next_words.is_empty() {
                Solution::update(prev, acc);
            } else {
                for next_word in strings.unwrap() {
                    if next_word.starts_with(prev) {
                        Solution::dfs(next_word, counter, acc);
                    }
                }
            }
        } else {
            Solution::update(prev, acc);
        }
    }

    fn update(word: &str, acc: &mut Vec<String>) {
       if word == "" {
           return;
       } else if acc.is_empty() {
           acc.push(word.to_string());
       } else {
           let length: usize = acc[0].len();
           if word.len() > length {
               acc.clear();
               acc.push(word.to_string());
           } else if word.len() < length {
               // Do nothing.
           } else {
               acc.push(word.to_string());
           }
       }
    }

    fn get_by_length(words: &Vec<String>) -> HashMap<usize, Vec<String>> {
        let mut by_length: HashMap<usize, Vec<String>> = HashMap::new();
        for word in words {
            let length: usize = word.len();
            //let acc: &mut Vec<String> = by_length.entry(length).or_insert(vec![]);
            by_length.entry(length).or_insert(vec![]).push(word.to_string());
        }
        return by_length;
    }
}
