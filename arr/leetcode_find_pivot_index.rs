/**
 * Given an array of integers nums, write a method that returns the "pivot"
 * index of this array.
 *
 * We define the pivot index as the index where the sum of the numbers to the
 * left of the index is equal to the sum of the numbers to the right of the
 * index.
 *
 * If no such index exists, we should return -1. If there are multiple pivot
 * indexes, you should return the left-most pivot index.
 *
 * Example 1:
 * Input:
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the
 * sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 *
 * Example 2:
 * Input:
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 *
 * Note:
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 */

fn main() {
    assert_eq!(3, Solution::pivot_index(vec![1, 7, 3, 6, 5, 6]));
    assert_eq!(-1, Solution::pivot_index(vec![1, 2, 3]));
    assert_eq!(2, Solution::pivot_index(vec![-1, -1, -1, -1, -1, 0]));
}

struct Solution {}

impl Solution {
    pub fn pivot_index(nums: Vec<i32>) -> i32 {
        let length: usize = nums.len();
        if length == 0 || length == 2 {
            return -1;
        }
        if length == 1 {
            return 0;
        }
        let sum: i32 = nums.iter().sum();
        let mut i: usize = 0;
        let mut acc: i32 = 0;
        while i < length {
            let value: i32 = nums[i];
            if acc * 2 + value == sum {
                return i as i32;
            } else {
                acc += value;
                i += 1;
            }
        }
        return -1;
    }
}
