/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 */

use std::collections::HashMap;

fn main() {
    assert_eq!(vec![1, 2], Solution::top_k_frequent(vec![1, 1, 1, 2, 2, 3], 2));
    assert_eq!(vec![1], Solution::top_k_frequent(vec![1], 1));
}

struct Solution {}

impl Solution {
    pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let mut counter: HashMap<i32, i32> = HashMap::new();
        for i in nums {
            *counter.entry(i).or_insert(0) += 1;
        }
        let mut entries: Vec<(&i32, &i32)> = counter.iter().map(|x| (x.1, x.0)).collect();
        entries.sort();
        let mut i: usize = entries.len();
        let mut res: Vec<i32> = vec![];
        for _ in 0..k {
            res.push(*entries[i - 1].1);
            i -= 1;
        }
        return res;
    }
}
