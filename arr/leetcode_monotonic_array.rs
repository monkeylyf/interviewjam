/**
 * An array is monotonic if it is either monotone increasing or monotone
 * decreasing.
 *
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j]. An array A
 * is monotone decreasing if for all i <= j, A[i] >= A[j].
 *
 * Return true if and only if the given array A is monotonic.
 *
 * Example 1:
 * Input: [1,2,2,3]
 * Output: true
 *
 * Example 2:
 * Input: [6,5,4,4]
 * Output: true
 *
 * Example 3:
 * Input: [1,3,2]
 * Output: false
 *
 * Example 4:
 * Input: [1,2,4,5]
 * Output: true
 *
 * Example 5:
 * Input: [1,1,1]
 * Output: true
 *
 * Note:
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 */

fn main() {
    assert!(Solution::is_monotonic(vec![1, 2, 2, 3]));
    assert!(Solution::is_monotonic(vec![6, 5, 4, 4]));
    assert!(!Solution::is_monotonic(vec![1, 3, 2]));
    assert!(Solution::is_monotonic(vec![1, 2, 4, 5]));
    assert!(Solution::is_monotonic(vec![1, 1, 1]));
}

struct Solution {}

impl Solution {
    pub fn is_monotonic(a: Vec<i32>) -> bool {
        let length: usize = a.len();
        if length == 1 {
            return true;
        }

        let mut is_non_decreasing: bool = true;
        let mut i: usize = 0;
        while i < length - 1 && is_non_decreasing {
            is_non_decreasing = a[i] <= a[i + 1];
            i += 1;
        }
        if is_non_decreasing {
            return true;
        }

        let mut is_non_increasing: bool = true;
        i = 0;
        while i < length - 1 && is_non_increasing {
            is_non_increasing = a[i] >= a[i + 1];
            i += 1;
        }
        return is_non_increasing;
    }
}
