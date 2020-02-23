/**
 * Given a binary array, find the maximum number of consecutive 1s in this
 * array.
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation:
 * The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 *
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */

fn main() {
    assert_eq!(3, Solution::find_max_consecutive_ones(vec![1, 1, 0, 1, 1, 1]));
    assert_eq!(6, Solution::find_max_consecutive_ones(vec![1, 1, 1, 1, 1, 1]));
    assert_eq!(0, Solution::find_max_consecutive_ones(vec![]));
}

struct Solution {}

impl Solution {
    pub fn find_max_consecutive_ones(nums: Vec<i32>) -> i32 {
        let mut max: usize = 0;
        let mut i: usize = 0;
        let length: usize = nums.len();
        while i < length {
            if nums[i] == 1 {
                let mut j = i + 1;
                while j < length && nums[j] == 1 {
                    j += 1;
                }
                if j - i > max {
                    max = j - i;
                }
                i = j;
            } else {
                i += 1
            }
        }
        return max as i32;
    }
}
