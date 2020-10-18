/**
 * Given a string s. You should re-order the string using the following
 * algorithm:
 *
 * 1. Pick the smallest character from s and append it to the result.
 * 2. Pick the smallest character from s which is greater than the last appended
 *    character to the result and append it.
 * 3. Repeat step 2 until you cannot pick more characters.
 * 4. Pick the largest character from s and append it to the result.
 * 5. Pick the largest character from s which is smaller than the last appended
 *    character to the result and append it.
 * 6. Repeat step 5 until you cannot pick more characters.
 * 7. Repeat the steps from 1 to 6 until you pick all characters from s.
 * In each step, If the smallest or the largest character appears more than once
 * you can choose any occurrence and append it to the result.
 *
 * Return the result string after sorting s with this algorithm.
 *
 * Example 1:
 * Input: s = "aaaabbbbcccc"
 * Output: "abccbaabccba"
 * Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
 * After steps 4, 5 and 6 of the first iteration, result = "abccba"
 * First iteration is done. Now s = "aabbcc" and we go back to step 1
 * After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
 * After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
 *
 * Example 2:
 * Input: s = "rat"
 * Output: "art"
 * Explanation: The word "rat" becomes "art" after re-ordering it with the
 * mentioned algorithm.
 *
 * Example 3:
 * Input: s = "leetcode"
 * Output: "cdelotee"
 *
 * Example 4:
 * Input: s = "ggggggg"
 * Output: "ggggggg"
 *
 * Example 5:
 * Input: s = "spo"
 * Output: "ops"
 *
 * Constraints:
 * 1 <= s.length <= 500
 * s contains only lower-case English letters.
 */

use std::char::from_u32;

fn main() {
    assert_eq!("abccbaabccba", Solution::sort_string("aaaabbbbcccc".to_string()));
    assert_eq!("art", Solution::sort_string("rat".to_string()));
    assert_eq!("cdelotee", Solution::sort_string("leetcode".to_string()));
    assert_eq!("gggggggg", Solution::sort_string("gggggggg".to_string()));
    assert_eq!("ops", Solution::sort_string("spo".to_string()));
}

struct Solution {}

impl Solution {
    pub fn sort_string(s: String) -> String {
        if s.is_empty() {
            return s;
        }

        let mut count: [u16; 26] = [0; 26];
        let mut total: u16 = 0;
        let chars: Vec<char> = s.chars().collect();
        for c in &chars {
            let index: u32 =  *c as u32 - 97;
            count[index as usize] += 1;
            total += 1;
        }
        let mut retval: Vec<char> = Vec::with_capacity(chars.len());
        while total > 0 {
            for i in 0..26_usize {
                let j = &count[i];
                if j > &0 {
                    total -= 1;
                    let hex: u32 = i as u32 + 97;
                    let c: char =  from_u32(hex).unwrap();
                    retval.push(c);
                    count[i] -= 1;
                    if total == 0 {
                        break;
                    }
                }
            }
            for i in (0..26_usize).rev() {
                let j = &count[i];
                if j > &0 {
                    total -= 1;
                    let hex: u32 = i as u32 + 97;
                    let c: char =  from_u32(hex).unwrap();
                    retval.push(c);
                    count[i] -= 1;
                    if total == 0 {
                        break;
                    }
                }
            }
        }
        return retval.iter().collect();
    }
}
