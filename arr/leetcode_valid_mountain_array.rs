/**
 * Given an array A of integers, return true if and only if it is a valid
 * mountain array.
 *
 * Recall that A is a mountain array if and only if:
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * Example 1:
 * Input: [2,1]
 * Output: false
 *
 * Example 2:
 * Input: [3,5,5]
 * Output: false
 *
 * Example 3:
 * Input: [0,3,2,1]
 * Output: true
 *
 * Note:
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */

fn main() {
    assert!(Solution::valid_mountain_array(vec![0, 3, 2, 1]));
    assert!(!Solution::valid_mountain_array(vec![2, 1]));
    assert!(!Solution::valid_mountain_array(vec![3, 5, 5]));
    assert!(!Solution::valid_mountain_array(vec![1, 2, 3, 4, 5, 6, 7, 8, 9]));
}

struct Solution {}

impl Solution {
    pub fn valid_mountain_array(a: Vec<i32>) -> bool {
        let length: usize = a.len();
        if length < 3 {
            return false;
        }

        let mut i: usize = 0;
        while i < length - 1 && a[i] < a[i + 1] {
            i += 1;
        }
        let mut j: usize = length - 1;
        while 0 < j && a[j - 1] > a[j] {
            j -= 1;
        }
        return i != length - 1 && j != 0 && i == j;
    }
}
