/**
 * Given a paragraph and a list of banned words, return the most frequent word
 * that is not in the list of banned words. It is guaranteed there is at least
 * one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of
 * punctuation.  Words in the paragraph are not case sensitive.
 * The answer is in lowercase.
 *
 * Example:
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent
 * non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is
 * banned.
 *
 * Note:
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in
 * paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation
 * symbols.
 */

use std::collections::HashMap;
use std::collections::HashSet;

fn main() {
    assert_eq!("ball".to_string(),
               Solution::most_common_word(
                   "Bob hit a ball, the hit BALL flew far after it was hit.".to_string(),
                   vec!["hit".to_string()]));

    assert_eq!("bob".to_string(),
               Solution::most_common_word("Bob".to_string(), vec![]));
}

struct Solution {}

impl Solution {
    pub fn most_common_word(paragraph: String, banned: Vec<String>) -> String {
        let banned_set: HashSet<&String> = banned.iter().collect();
        let mut counter: HashMap<String, u16> = HashMap::new();
        for word in Solution::collect_words(&paragraph) {
            if !banned_set.contains(&word) {
                *counter.entry(word).or_insert(0 as u16) += 1;
            }
        }
        return counter.iter().max_by_key(|x| x.1).unwrap().0.clone();
    }

    fn collect_words(paragraph: &str) -> Vec<String> {
        let mut words: Vec<String> = vec![];
        let mut acc: Vec<char> = vec![];
        for c in paragraph.chars() {
            if c != '!' && c != '?' && c != '\'' && c != ',' && c != '.' && c != ';' && c != ' ' {
                acc.push(c.to_lowercase().next().unwrap());
            } else {
                if !acc.is_empty() {
                    let word: String = acc.iter().collect();
                    words.push(word);
                    acc.clear();
                }
            }
        }
        if !acc.is_empty() {
            let word: String = acc.iter().collect();
            words.push(word);
        }
        return words;
    }
}
