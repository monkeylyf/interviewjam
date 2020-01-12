/**
 * Given an array nums of integers, return how many of them contain an even
 * number of digits.
 *
 * Example 1:
 * Input: nums = [12,345,2,6,7896]
 *
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 *
 * Example 2:
 * Input: nums = [555,901,482,1771]
 *
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 *
 * Constraints:
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 */

fn main() {
    let input: Vec<i32> = vec![555,901,482,1771];
    assert_eq!(1, Solution::find_numbers(input));
}

struct Solution {}

impl Solution {
    pub fn find_numbers(nums: Vec<i32>) -> i32 {
        return nums.iter().map(|x| {
            let size: usize = x.to_string().len();
            if size % 2 == 0 {
                return 1;
            } else {
                return 0;
            }
        }).sum();
    }
}


/*
class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        return sum(int(len(str(i)) % 2 == 0) for i in nums)
 */
