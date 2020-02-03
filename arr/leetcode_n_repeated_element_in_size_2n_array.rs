/**
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of
 * these elements is repeated N times.
 *
 * Return the element repeated N times.
 *
 * Example 1:
 * Input: [1,2,3,3]
 * Output: 3
 *
 * Example 2:
 * Input: [2,1,2,5,3,2]
 * Output: 2
 *
 * Example 3:
 * Input: [5,1,5,2,5,3,5,4]
 * Output: 5
 *
 * Note:
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length is even
 */

fn main() {
    assert_eq!(5, Solution::repeated_n_times(vec![5,1,5,2,5,3,5,4]));
}

struct Solution {}

impl Solution {
    pub fn repeated_n_times(a: Vec<i32>) -> i32 {
        // O(n) time complexity and O(1) space solution:
        // How to distribute n unique elements among n same numbers?
        // There must be consecutive appearence of the number or fit XiX
        // pattern. Edge case: [x, 1, 2, x, 3, 4, x], the number is either
        // first or last.
        let mut i: usize = 0;
        let length: usize = a.len();
        while i < length - 1 {
            if a[i] == a[i + 1] {
                return a[i];
            } else if i < length - 2 && a[i] == a[i + 2] {
                return a[i];
            }
            i += 1;
        }
        return a[0];
    }
}
