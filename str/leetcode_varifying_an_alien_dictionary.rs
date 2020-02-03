/**
 * In an alien language, surprisingly they also use english lowercase letters,
 * but possibly in a different order. The order of the alphabet is some
 * permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the
 * alphabet, return true if and only if the given words are sorted
 * lexicographicaly in this alien language.
 *
 * Example 1:
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is
 * sorted.
 *
 * Example 2:
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] >
 * words[1], hence the sequence is unsorted.
 *
 * Example 3:
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is
 * shorter (in size.) According to lexicographical rules "apple" > "app",
 * because 'l' > '∅', where '∅' is defined as the blank character which is less
 * than any other character (More info).
 *
 * Constraints:
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 */

use std::cmp::min;

fn main() {
    let words: Vec<String> = vec!["word".to_string(), "world".to_string(), "row".to_string()];
    let order: String = "worldabcefghijkmnpqstuvxyz".to_string();
    assert!(!Solution::is_alien_sorted(words, order));

    let words1: Vec<String> = vec!["hello".to_string(), "leetcode".to_string()];
    let order1: String = "hlabcdefgijkmnopqrstuvwxyz".to_string();
    assert!(Solution::is_alien_sorted(words1, order1));

    let words2: Vec<String> = vec!["apple".to_string(), "app".to_string()];
    let order2: String = "abcdefghijklmnopqrstuvwxyz".to_string();
    assert!(!Solution::is_alien_sorted(words2, order2));
}

struct Solution {}

impl Solution {
    pub fn is_alien_sorted(words: Vec<String>, order: String) -> bool {
        let mut array: [usize; 26] = [0; 26];
        for (i, c) in order.chars().enumerate() {
            let ascii: u32 = c as u32 - 97;
            array[ascii as usize] = i;
        }
        let words_length: usize = words.len();
        let chars: Vec<Vec<char>> = words.iter()
            .map(|w| w.chars().into_iter().collect())
            .collect();
        for j in 1 as usize..words_length {
            if !Solution::is_sorted(&chars[j - 1], &chars[j], array) {
                return false;
            }
        }
        return true;
    }

    fn is_sorted(prev_word: &Vec<char>, cur_word: &Vec<char>, array: [usize; 26]) -> bool {
        let min_length: usize = min(prev_word.len(), cur_word.len());
        for i in 0 as usize..min_length {
            let previous: char = prev_word[i];
            let current: char = cur_word[i];
            if previous != current {
                let prev_index: u32 = previous as u32 - 97;
                let cur_index: u32 = current as u32 - 97;
                if array[prev_index as usize] > array[cur_index as usize] {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return prev_word.len() <= cur_word.len();
    }
}
