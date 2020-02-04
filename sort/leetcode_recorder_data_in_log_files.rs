/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier. Then,
 * either:
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is
 * guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the
 * identifier used in case of ties.  The digit-logs should be put in their
 * original order.
 *
 * Return the final order of the logs.
 *
 * Example 1:
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 *
 * Constraints:
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */

use std::cmp::Ordering;

fn main() {
    let input1: Vec<String> = vec![
        "dig1 8 1 5 1".to_string(),
        "let1 art can".to_string(),
        "dig2 3 6".to_string(),
        "let2 own kit dig".to_string(),
        "let3 art zero".to_string(),
    ];
    assert_eq!(
        vec!["let1 art can".to_string(),
             "let3 art zero".to_string(),
             "let2 own kit dig".to_string(),
             "dig1 8 1 5 1".to_string(),
             "dig2 3 6".to_string()],
        Solution::reorder_log_files(input1));
}

struct Solution {}

impl Solution {
    pub fn reorder_log_files(logs: Vec<String>) -> Vec<String> {
        let mut copied: Vec<String> = logs.iter().cloned().collect();
        copied.sort_by(|x, y| {
            if !Solution::is_letter_log(&x) && !Solution::is_letter_log(&y) {
                return Ordering::Equal;
            } else if Solution::is_letter_log(&x) && Solution::is_letter_log(&y) {
                let i = x.find(" ").unwrap();
                let j = y.find(" ").unwrap();
                let aa = &x[i..];
                let bb = &y[j..];
                if aa == bb {
                    return x.cmp(y)
                } else {
                    return aa.cmp(bb);
                }
            } else if !Solution::is_letter_log(&x) && Solution::is_letter_log(&y) {
                return Ordering::Greater;
            } else if Solution::is_letter_log(&x) && !Solution::is_letter_log(&y) {
                return Ordering::Less;
            } else {
                return Ordering::Equal;
            }
        });
        return copied;
    }

    fn is_letter_log(a: &str) -> bool {
        let mut seen_whitespace: bool = false;
        for c in a.chars() {
            if seen_whitespace {
                if c.is_alphabetic() {
                    return true;
                }
            } else {
                seen_whitespace = c == ' ';
            }
        }
        return false;
    }
}
