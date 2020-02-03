/**
 * We are given an array A of N lowercase letter strings, all of the same
 * length.
 *
 * Now, we may choose any set of deletion indices, and for each string, we
 * delete all the characters in those indices.
 *
 * For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices
 * {0, 2, 3}, then the final array after deletions is ["bef", "vyz"], and the
 * remaining columns of A are ["b","v"], ["e","y"], and ["f","z"].  (Formally,
 * the c-th column is [A[0][c], A[1][c], ..., A[A.length-1][c]].)
 *
 * Suppose we chose a set of deletion indices D such that after deletions, each
 * remaining column in A is in non-decreasing sorted order.
 *
 * Return the minimum possible value of D.length.
 *
 * Example 1:
 * Input: ["cba","daf","ghi"]
 * Output: 1
 * Explanation:
 * After choosing D = {1}, each column ["c","d","g"] and ["a","f","i"] are in
 * non-decreasing sorted order.
 * If we chose D = {}, then a column ["b","a","h"] would not be in
 * non-decreasing sorted order.
 *
 * Example 2:
 * Input: ["a","b"]
 * Output: 0
 * Explanation: D = {}
 *
 * Example 3:
 * Input: ["zyx","wvu","tsr"]
 * Output: 3
 * Explanation: D = {0, 1, 2}
 */

fn main() {
    assert_eq!(1, Solution::min_deletion_size(vec!["cba".to_string(), "daf".to_string(), "ghi".to_string()]));
    assert_eq!(0, Solution::min_deletion_size(vec!["a".to_string(), "b".to_string()]));
    assert_eq!(3, Solution::min_deletion_size(vec!["zyx".to_string(), "tsr".to_string(), "tsr".to_string()]));
}

struct Solution {}

impl Solution {
    pub fn min_deletion_size(a: Vec<String>) -> i32 {
        let chars: Vec<Vec<char>> = a.iter()
            .map(|w| w.chars().collect())
            .collect();
        let mut count: i32 = 0;
        let length: usize = chars[0].len();
        let num_of_words: usize = a.len();
        for i in 0 as usize..length {
            for j in 1 as usize..num_of_words {
                if chars[j - 1][i] > chars[j][i] {
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }
}
