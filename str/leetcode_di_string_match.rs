/**
 * Given a string S that only contains "I" (increase) or "D" (decrease),
 * let N = S.length.
 *
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 *
 * Example 1:
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 *
 * Example 2:
 * Input: "III"
 * Output: [0,1,2,3]
 *
 * Example 3:
 * Input: "DDI"
 * Output: [3,2,0,1]
 *
 * Note:
 *
 * 1 <= S.length <= 10000
 * S only contains characters "I" or "D".
 */

fn main() {
    assert_eq!(vec![0, 4, 1, 3, 2], Solution::di_string_match("IDID".to_string()));
    assert_eq!(vec![0, 1, 2, 3], Solution::di_string_match("III".to_string()));
    assert_eq!(vec![3, 2, 0, 1], Solution::di_string_match("DDI".to_string()));
}

struct Solution {}

impl Solution {
    pub fn di_string_match(s: String) -> Vec<i32> {
        let length: usize = s.len();
        let mut vec: Vec<i32> = vec![-1; length + 1];
        let mut acc: i32 = 0;
        for (i, c) in s.chars().enumerate() {
            if c == 'I' {
                vec[i] = acc;
                acc += 1;
            }
        }
        for i in (0 as usize..=length).rev() {
            if vec[i] == -1 {
                vec[i] = acc;
                acc += 1;
            }
        }
        return vec;
    }
}
