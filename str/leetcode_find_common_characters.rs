/**
 * Given an array A of strings made only from lowercase letters, return a list
 * of all characters that show up in all strings within the list (including
 * duplicates).  For example, if a character occurs 3 times in all strings but
 * not 4 times, you need to include that character three times in the final
 * answer.
 *
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 *
 * Example 2:
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 *
 * Note:
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 */

use std::cmp::min;
use std::collections::HashMap;

fn main() {
    // TODO: why returned string order is random? assert_eq! fails sometime.
    let input: Vec<String> = vec!["bella".to_string(), "label".to_string(), "roller".to_string()];
    assert_eq!(vec!["e".to_string(), "l".to_string(), "l".to_string()],
               Solution::common_chars(input));

    let input1: Vec<String> = vec!["cool".to_string(), "lock".to_string(), "cook".to_string()];
    assert_eq!(vec!["c".to_string(), "o".to_string()], Solution::common_chars(input1));
}

struct Solution {}

impl Solution {
    pub fn common_chars(a: Vec<String>) -> Vec<String> {
        let mut common: Vec<String> = vec![];
        if a.is_empty() {
            return common;
        }
        let mut base: HashMap<char, u32> = Solution::get_counter(&a[0]);
        for i in 1..a.len() {
            base = Solution::get_intersection(base, &a[i]);
        }
        for (c, freq) in base.iter() {
            for _ in 0..*freq {
                common.push(c.to_string());
            }
        }
        return common;
    }

    fn get_intersection(a: HashMap<char, u32>, s: &str) -> HashMap<char, u32> {
        // TODO: mutate on a with iter_mut
        let counter: HashMap<char, u32> = Solution::get_counter(s);
        let mut common: HashMap<char, u32> = HashMap::new();
        for (c, freq) in a.iter() {
            let val: Option<&u32> = counter.get(c);
            if val.is_some() {
                let f: &u32 = val.unwrap();
                common.insert(*c, min(*f, *freq));
            }
        }
        return common;
    }

    fn get_counter(s: &str) -> HashMap<char, u32> {
        let mut counter: HashMap<char, u32> = HashMap::new();
        for c in s.chars() {
            *counter.entry(c).or_insert(0) += 1;
        }
        return counter;
    }
}
