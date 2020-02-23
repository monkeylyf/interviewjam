/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s
 * elements are subset of nums2. Find all the next greater numbers for nums1's
 * elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number
 * to its right in nums2. If it does not exist, output -1 for this number.
 *
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for
 * it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second
 * array is 3.
 * For number 2 in the first array, there is no next greater number for it in
 * the second array, so output -1.
 *
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second
 * array is 3.
 * For number 4 in the first array, there is no next greater number for it in
 * the second array, so output -1.
 *
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 */

use std::collections::HashMap;

fn main() {
    assert_eq!(vec![-1, 3, -1], Solution::next_greater_element(vec![4, 1, 2], vec![1, 3, 4, 2]));
    assert_eq!(vec![3, -1], Solution::next_greater_element(vec![2, 4], vec![1, 2, 3, 4]));
}

struct Solution {}

impl Solution {
    pub fn next_greater_element(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        let mut greater: HashMap<&i32, &i32> = HashMap::new();
        let mut stack: Vec<&i32> = vec![];

        for i in &nums2 {
            while !stack.is_empty() && stack[stack.len() - 1] < i {
                greater.insert(stack.pop().unwrap(), i);
            }
            stack.push(i);
        }

        let mut res: Vec<i32> = Vec::with_capacity(nums1.len());
        for i in &nums1 {
            if let Some(j) = greater.get(i) {
                res.push(**j);
            } else {
                res.push(-1)
            }
        }
        return res;
    }
}
