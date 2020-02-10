/**
 * In a given integer array nums, there is always exactly one largest element.
 *
 * Find whether the largest element in the array is at least twice as much as
 * every other number in the array.
 *
 * If it is, return the index of the largest element, otherwise return -1.
 *
 * Example 1:
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the
 * array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 *
 * Example 2:
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 *
 * Note:
 * nums will have a length in the range [1, 50].
 * Every nums[i] will be an integer in the range [0, 99].
 */

fn main() {
    assert_eq!(1, Solution::dominant_index(vec![3, 6, 1, 0]));
    assert_eq!(-1, Solution::dominant_index(vec![1, 2, 3, 4]));
}

struct Solution {}

impl Solution {
    pub fn dominant_index(nums: Vec<i32>) -> i32 {
        let mut largest_index: i32 = -1;
        let mut largest: &i32 = &-1;
        let mut second_largest: &i32 = &-1;
        for (i, value) in nums.iter().enumerate() {
            if largest == &-1 {
                largest = value;
                largest_index = i as i32;
            } else if value > largest {
                second_largest = largest;
                largest_index = i as i32;
                largest = value;
            } else if value > second_largest {
                second_largest = value;
            } else {
                // Do nothing.
            }
        }
        return if *largest >= 2 * *second_largest {
            largest_index
        } else {
            -1
        };
    }
}
