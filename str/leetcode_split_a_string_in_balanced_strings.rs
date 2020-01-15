/**
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * Return the maximum amount of splitted balanced strings.
 *
 * Example 1:
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring
 * contains same number of 'L' and 'R'.
 *
 * Example 2:
 * Input: s = "RLLLLRRRLR"
 * Output: 3
 * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring
 * contains same number of 'L' and 'R'.
 *
 * Example 3:
 * Input: s = "LLLLRRRR"
 * Output: 1
 * Explanation: s can be split into "LLLLRRRR".
 *
 * Example 4:
 * Input: s = "RLRRRLLRLL"
 * Output: 2
 * Explanation: s can be split into "RL", "RRRLLRLL", since each substring
 * contains an equal number of 'L' and 'R'
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s[i] = 'L' or 'R'
 */

fn main() {
}

struct Solution {}

impl Solution {
    pub fn balanced_string_split(s: String) -> i32 {
        let mut balance: i32 = 0;
        let mut count: i32 = 0;
        for c in s.chars() {
            if c == 'L' {
                balance += 1;
            } else if c == 'R' {
                balance -= 1;
            } else {
                panic!("fuck this shit: {}", c);
            }
            if balance == 0 {
                count += 1;
            }
        }
        return count;
    }
}

/*
class Solution:
    def balancedStringSplit(self, s: str) -> int:
        r = 0
        count = 0
        for char in s:
            if char == 'L':
                r -= 1
            elif char == 'R':
                r += 1
            else:
                raise ValueError()
            if r == 0:
                count += 1
        return count
 */
