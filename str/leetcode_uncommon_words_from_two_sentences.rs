/**
 * We are given two sentences A and B.  (A sentence is a string of space
 * separated words.  Each word consists only of lowercase letters.)
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and
 * does not appear in the other sentence.
 *
 * Return a list of all uncommon words.
 * You may return the list in any order.
 *
 * Example 1:
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 *
 * Example 2:
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 *
 * Note:
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 */

use std::collections::HashMap;

fn main() {
    assert_eq!(vec!["sweet".to_string(), "sour".to_string()], Solution::uncommon_from_sentences(
            "this apple is sweet".to_string(), "this apple is sour".to_string()));
    assert_eq!(vec!["banana".to_string()], Solution::uncommon_from_sentences(
            "apple apple".to_string(), "banana".to_string()));
    assert_eq!(vec!["ejt".to_string()], Solution::uncommon_from_sentences(
            "s z z z s".to_string(), "s z ejt".to_string()));
}

struct Solution {}

impl Solution {
    pub fn uncommon_from_sentences(a: String, b: String) -> Vec<String> {
        let uncommons_in_a: HashMap<String, u16> = Solution::count_uncommon(&a);
        let uncommons_in_b: HashMap<String, u16> = Solution::count_uncommon(&b);
        let mut res: Vec<String> = Vec::new();
        for (word, frequency) in uncommons_in_a.iter() {
            if *frequency == 1 && !uncommons_in_b.contains_key(word) {
                res.push(word.to_string());
            }
        }
        for (word, frequency) in uncommons_in_b.iter() {
            if *frequency == 1 && !uncommons_in_a.contains_key(word) {
                res.push(word.to_string());
            }
        }
        return res;
    }

    fn count_uncommon(a: &str) -> HashMap<String, u16> {
        let mut map: HashMap<String, u16> = HashMap::new();
        for word in a.split(" ") {
            *map.entry(word.to_string()).or_insert(0 as u16) += 1;
        }
        return map;
    }
}
