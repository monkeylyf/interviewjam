/**
 * Given the array of integers nums, you will choose two different indices i and
 * j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 *
 * Example 1:
 * Input: nums = [3,4,5,2]
 * Output: 12
 * Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will
 * get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
 *
 * Example 2:
 * Input: nums = [1,5,4,5]
 * Output: 16
 * Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get
 * the maximum value of (5-1)*(5-1) = 16.
 *
 * Example 3:
 * Input: nums = [3,7]
 * Output: 12
 *
 * Constraints:
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 */

fn main() {
    assert_eq!(12, Solution::max_product(vec![3, 4, 5, 2]));
    assert_eq!(16, Solution::max_product(vec![1, 5, 4, 5]));
}

struct Solution {}

impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        let mut largest: i32 = std::i32::MIN;
        let mut second_largest: i32 = std::i32::MIN;
        for i in nums {
            if i > largest {
                second_largest = largest;
                largest = i;
            } else if i > second_largest {
                second_largest = i;
            } else {
            }
        }

        return (largest - 1) * (second_largest - 1);
    }
}
