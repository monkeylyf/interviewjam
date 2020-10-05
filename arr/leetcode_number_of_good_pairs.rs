/**
 * Given an array of integers nums.
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 *
 * Return the number of good pairs.
 *
 * Example 1:
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 *
 * Example 2:
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 *
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: 0
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */


fn main() {
    assert_eq!(4, Solution::num_identical_pairs(vec![1, 2, 3, 1, 1, 3]));
}

struct Solution {}

impl Solution {
    pub fn num_identical_pairs(nums: Vec<i32>) -> i32 {
        let mut count: [i16; 100] = [0; 100];
        for i in nums {
            let index: usize = i as usize;
            count[index] += 1;
        }

        let mut num_of_pairs: i32 = 0;
        for i in (0..100).rev() {
            let freq = count[i];
            num_of_pairs += (freq * (freq - 1) / 2) as i32;
        }

        return num_of_pairs;
    }
}
