/**
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 *
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 *
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 *
 * Note:
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */

use std::collections::HashMap;

fn main() {
    assert_eq!(2, Solution::find_shortest_sub_array(vec![1, 2, 2, 3, 1]));
    assert_eq!(6, Solution::find_shortest_sub_array(vec![1, 2, 2, 3, 1, 4, 2]));
}

struct Solution {}

impl Solution {
    pub fn find_shortest_sub_array(nums: Vec<i32>) -> i32 {
        let mut max_degree: usize = 0;
        let mut counter: HashMap<i32, Vec<usize>> = HashMap::new();
        for (i, value) in nums.iter().enumerate() {
            let indices: &mut Vec<usize> = counter.entry(*value).or_insert(vec![]);
            indices.push(i);
            if indices.len() > max_degree {
                max_degree = indices.len();
            }
        }
        if max_degree == 1 {
            return 1;
        }

        let mut min_length: usize = nums.len();
        for entry in counter.iter().filter(|e| e.1.len() == max_degree) {
            let indices: &Vec<usize> = entry.1;
            let diff: usize = indices[indices.len() - 1] - indices[0] + 1;
            if diff < min_length {
                min_length = diff;
            }
        }
        return min_length as i32;
    }
}
