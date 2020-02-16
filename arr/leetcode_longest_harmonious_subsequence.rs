/**
 * We define a harmounious array as an array where the difference between its
 * maximum value and its minimum value is exactly 1.
 *
 * Now, given an integer array, you need to find the length of its longest
 * harmonious subsequence among all its possible subsequences.
 *
 * Example 1:
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 *
 * Note: The length of the input array will not exceed 20,000.
 */

use std::collections::HashMap;

fn main() {
    assert_eq!(5, Solution::find_lhs(vec![1,3,2,2,5,2,3,7]));
}

struct Solution {}

impl Solution {
    pub fn find_lhs(nums: Vec<i32>) -> i32 {
        let mut count: HashMap<&i32, i32> = HashMap::new();
        for num in &nums {
            *count.entry(num).or_insert(0) += 1;
        }
        let mut max_length: i32 = 0;
        for num in &nums {
            if let Some(frequency) = count.get(&(num + 1)) {
                max_length = std::cmp::max(max_length, *frequency + count.get(num).unwrap());
            }
        }
        return max_length;
    }
}
