/**
 * Given an integer array, find three numbers whose product is maximum and
 * output the maximum product.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 *
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 *
 * Note:
 * The length of the given array will be in range [3,104] and all elements are
 * in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of
 * 32-bit signed integer.
 */

use std::cmp::max;

fn main() {
    assert_eq!(6, Solution::maximum_product(vec![1, 2, 3]));
    assert_eq!(24, Solution::maximum_product(vec![1, 2, 3, 4]));
    assert_eq!(16, Solution::maximum_product(vec![-4, -1, 3, 4]));
}

struct Solution {}

impl Solution {
    pub fn maximum_product(nums: Vec<i32>) -> i32 {
        let mut n: Vec<&i32> = nums.iter().collect();
        n.sort();
        let length: usize = n.len();
        return max(n[0] * n[1] * n[length - 1], n[length - 3] * n[length - 2] * n[length - 1]);
    }
}
