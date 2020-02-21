/**
 * Given an array of integers and an integer k, you need to find the number of
 * unique k-diff pairs in the array. Here a k-diff pair is defined as an integer
 * pair (i, j), where i and j are both numbers in the array and their absolute
 * difference is k.
 *
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of
 * unique pairs.
 *
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4)
 * and (4, 5).
 *
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 */

use std::collections::HashMap;
use std::collections::HashSet;

fn main() {
    assert_eq!(2, Solution::find_pairs(vec![3, 1, 4, 1, 5], 2));
    assert_eq!(4, Solution::find_pairs(vec![1, 2, 3, 4, 5], 1));
    assert_eq!(1, Solution::find_pairs(vec![1, 3, 1, 5, 4], 0));
}

struct Solution {}

impl Solution {
    pub fn find_pairs(nums: Vec<i32>, k: i32) -> i32 {
        if k < 0 {
            return 0;
        } else if k == 0 {
            let mut map: HashMap<i32, i32> = HashMap::new();
            for i in &nums {
                *map.entry(*i).or_insert(0) += 1;
            }
            let mut count: i32 = 0;
            for (_, i) in map {
                if i >= 2 {
                    count += 1;
                }
            }
            return count;
        } else {
            let set: HashSet<&i32> = nums.iter().collect();
            let mut count: i32 = 0;
            for i in &set {
                if set.contains(&(*i + k)) {
                    count += 1;
                }
            }
            return count;
        }
    }
}
