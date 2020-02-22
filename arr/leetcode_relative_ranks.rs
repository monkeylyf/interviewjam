/**
 * Given scores of N athletes, find their relative ranks and the people with the
 * top three highest scores, who will be awarded medals: "Gold Medal", "Silver
 * Medal" and "Bronze Medal".
 *
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so
 * they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks
 * according to their scores.
 *
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 */

use std::collections::HashMap;

fn main() {
    assert_eq!(vec!["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"],
               Solution::find_relative_ranks(vec![5, 4, 3, 2, 1]));
}

struct Solution {}

impl Solution {
    pub fn find_relative_ranks(nums: Vec<i32>) -> Vec<String> {
        let mut ranks: Vec<String> = Vec::with_capacity(nums.len());
        let mut copied: Vec<&i32> = nums.iter().collect();
        let length: usize = nums.len();
        copied.sort();
        let with_index: HashMap<&i32, usize> = copied.iter().enumerate()
            .map(|x| (*x.1, length - x.0))
            .collect();
        for i in &nums {
            let index: i32 = *with_index.get(i).unwrap() as i32;
            match index {
             1 => ranks.push("Gold Medal".to_string()),
             2 => ranks.push("Silver Medal".to_string()),
             3 => ranks.push("Bronze Medal".to_string()),
             _ => ranks.push(index.to_string()),
            }
        }
        return ranks;
    }
}
