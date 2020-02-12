/**
 * Given a sorted (in ascending order) integer array nums of n elements and a
 * target value, write a function to search target in nums. If target exists,
 * then return its index, otherwise return -1.
 *
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 * Note:
 * You may assume that all elements in nums are unique.
 * n will be in the range [1, 10000].
 * The value of each element in nums will be in the range [-9999, 9999].
 */

fn main() {
    assert_eq!(4, Solution::search(vec![-1,0,3,5,9,12], 9));
    assert_eq!(-1, Solution::search(vec![-1,0,3,5,9,12], 2));
    assert_eq!(0, Solution::search(vec![5], 5));
    assert_eq!(-1, Solution::search(vec![5], -5));
}

struct Solution {}

impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        let mut head: i32 = 0;
        let mut tail: i32 = nums.len() as i32 - 1;
        while head <= tail {
            let mid: i32 = (tail - head) / 2 + head;
            let value: i32 = nums[mid as usize];
            if target == value {
                return mid as i32;
            } else if target > value {
                head = mid + 1;
            } else {
                tail = mid - 1;
            }
        }

        return -1;
    }

    pub fn cheat_with_built_in(nums: Vec<i32>, target: i32) -> i32 {
        let result: Result<usize, usize> = nums.binary_search(&target);
        return if result.is_ok() {
            result.unwrap() as i32
        } else {
            -1
        };
    }
}
