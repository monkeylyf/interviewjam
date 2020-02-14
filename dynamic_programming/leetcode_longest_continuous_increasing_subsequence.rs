/**
 * Given an unsorted array of integers, find the length of longest continuous
 * increasing subsequence (subarray).
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its
 * length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a
 * continuous one where 5 and 7 are separated by 4.
 *
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 * Note: Length of the array will not exceed 10,000.
 */

fn main() {
    assert_eq!(3, Solution::find_length_of_lcis(vec![1, 3, 5, 4, 7]));
    assert_eq!(1, Solution::find_length_of_lcis(vec![2, 2, 2, 2, 2]));
}

struct Solution {}

impl Solution {
    pub fn find_length_of_lcis(nums: Vec<i32>) -> i32 {
        if nums.is_empty() {
            return 0;
        }
        let length: usize = nums.len();
        let mut longest: i32 = 1;
        let mut acc: i32 = 1;
        for i in 1..length {
            if nums[i - 1] < nums[i] {
                acc += 1;
                if acc > longest {
                    longest = acc;
                }
            } else {
                acc = 1;
            }
        }
        return longest;
    }
}
