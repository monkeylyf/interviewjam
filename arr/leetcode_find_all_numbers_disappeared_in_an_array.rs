/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */

fn main() {
    let nums: Vec<i32> = vec![4,3,2,7,8,2,3,1];
    assert_eq!(vec![5, 6], Solution::find_disappeared_numbers(nums));
}

struct Solution {}

impl Solution {
    /**
     * Map value to index, so that in-place vec maintains hashset and value information.
     */
    pub fn find_disappeared_numbers(nums: Vec<i32>) -> Vec<i32> {
        let mut nums = nums;
        let mut i: usize = 0;
        while i < nums.len() {
            let index: usize = nums[i].abs() as usize - 1;
            let target: i32 = nums[index];
            if target > 0 {
                nums[index] = -target;
            }
            i += 1;
        }
        return nums.iter().enumerate()
            .filter(|x| *x.1 > 0)
            .map(|x| x.0 as i32 + 1)
            .collect::<Vec<i32>>();
    }
}
