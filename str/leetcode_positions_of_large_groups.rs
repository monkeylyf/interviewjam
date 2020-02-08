/**
 * In a string S of lowercase letters, these letters form consecutive groups of
 * the same character.
 *
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx",
 * "z" and "yy".
 *
 * Call a group large if it has 3 or more characters. We would like the starting
 * and ending positions of every large group.
 *
 * The final answer should be in lexicographic order.
 *
 * Example 1:
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending
 * positions 6.
 *
 * Example 2:
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 *
 * Example 3:
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 *
 * Note:  1 <= S.length <= 1000
 */

fn main() {
    assert_eq!(vec![vec![3, 6]],
               Solution::large_group_positions("abbxxxxzzy".to_string()));
    assert!(Solution::large_group_positions("abc".to_string()).is_empty());
    assert_eq!(vec![vec![3, 5], vec![6, 9], vec![12, 14]],
               Solution::large_group_positions("abcdddeeeeaabbbcd".to_string()));
    assert!(Solution::large_group_positions("".to_string()).is_empty());
    assert_eq!(vec![vec![0, 2]],
               Solution::large_group_positions("aaa".to_string()));
}

struct Solution {}

impl Solution {
    pub fn large_group_positions(s: String) -> Vec<Vec<i32>> {
        let mut positions: Vec<Vec<i32>> = vec![];
        if s.is_empty() {
            return positions;
        }
        let mut prev: i32 = -1;
        let mut prev_char: char = 'a';  // Placeholder for initialization.
        for (i, c) in s.chars().enumerate() {
            if prev == -1 {
                prev = i as i32;
                prev_char = c;
            } else if prev_char != c {
                if i as i32 - prev >= 3 {
                    positions.push(vec![prev, i as i32 - 1]);
                }
                prev = i as i32;
                prev_char = c;
            }
        }
        // Collect last sequence.
        if s.len() as i32 - prev >= 3 {
            positions.push(vec![prev, s.len() as i32 - 1]);
        }
        return positions;
    }
}
