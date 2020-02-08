/**
 * Given a string S and a character C, return an array of integers representing
 * the shortest distance from the character C in the string.
 *
 * Example 1:
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 * Note:
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 */

fn main() {
    assert_eq!(vec![3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0],
               Solution::shortest_to_char("loveleetcode".to_string(), 'e'));
}

struct Solution {}

impl Solution {
    pub fn shortest_to_char(s: String, c: char) -> Vec<i32> {
        let length: usize = s.len();
        let chars: Vec<char> = s.chars().into_iter().collect();
        let mut shortest: Vec<i32> = vec![length as i32; length];
        let mut prev_index: i32 = -1;
        let mut i: usize = 0;
        // Scan forward.
        while i < length {
            if chars[i] == c {
                prev_index = i as i32;
                shortest[i] = 0;
            } else if prev_index != -1 {
                let distance: i32 = i as i32 - prev_index;
                if distance < shortest[i] {
                    shortest[i] = distance;
                }
            } else {
                // Do nothing.
            }
            i += 1;
        }
        // Scan backward.
        i = length;
        prev_index = -1;
        while i > 0 {
            if chars[i - 1] == c {
                prev_index = i as i32;
            } else if prev_index != -1 {
                let distance: i32 = prev_index - i as i32;
                if distance < shortest[i - 1] {
                    shortest[i - 1] = distance;
                }
            } else {
                // Do nothing.
            }
            i -= 1;
        }
        return shortest;
    }
}
