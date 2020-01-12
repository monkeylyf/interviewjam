/*
 * Given two arrays, write a function to compute their intersection.
 *
 *Example 1:
 *
 *Input: nums1 = [1,2,2,1], nums2 = [2,2]
 *Output: [2]
 *Example 2:
 *
 *Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *Output: [9,4]
 *Note:
 *
 *Each element in the result must be unique.
 *The result can be in any order.
 */

use std::collections::HashSet;


fn main() {
    let nums1 = vec![1, 2, 2, 1];
    let nums2 = vec![2, 2];
    assert_eq!(vec![2], Solution::intersection(nums1, nums2));
}

struct Solution { }

impl Solution {
    pub fn intersection(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        let a: HashSet<i32> = nums1.iter().cloned().collect();
        let b: HashSet<i32> = nums2.iter().cloned().collect();
        return a.intersection(&b).cloned().collect();
    }
}
