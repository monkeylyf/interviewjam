/**
 * We are given two strings, A and B.
 *
 * A shift on A consists of taking string A and moving the leftmost character to
 * the rightmost position. For example, if A = 'abcde', then it will be 'bcdea'
 * after one shift on A. Return True if and only if A can become B after some
 * number of shifts on A.
 *
 * Example 1:
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true
 *
 * Example 2:
 * Input: A = 'abcde', B = 'abced'
 * Output: false
 * Note:
 *
 * A and B will have length at most 100.
 */

fn main() {
    assert!(Solution::rotate_string("abcde".to_string(), "cdeab".to_string()));
    assert!(!Solution::rotate_string("abcde".to_string(), "abced".to_string()));
}

struct Solution {}

impl Solution {
    pub fn rotate_string(a: String, b: String) -> bool {
        if a.len() != b.len() {
            return false;
        }
        let repeated: String = b.repeat(2);
        return repeated.contains(&a);
    }
}
