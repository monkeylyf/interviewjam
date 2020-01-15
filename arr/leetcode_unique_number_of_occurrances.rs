/**
 * Given an array of integers arr, write a function that returns true if and
 * only if the number of occurrences of each value in the array is unique.
 *
 * Example 1:
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two
 * values have the same number of occurrences.
 *
 * Example 2:
 * Input: arr = [1,2]
 * Output: false
 *
 * Example 3:
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 *
 * Constraints:
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */

use std::collections::HashMap;
use std::collections::HashSet;

fn main () {
    let arr: Vec<i32> = vec![-3,0,1,-3,1,1,1,-3,10,0];
    assert!(Solution::unique_occurrences(arr));
}

struct Solution {}

impl Solution {
    pub fn unique_occurrences(arr: Vec<i32>) -> bool {
        let mut counter: HashMap<i32, i32> = HashMap::new();
        for i in arr {
            *counter.entry(i).or_insert(0) += 1;
        }
        let mut unique_frequency: HashSet<i32> = HashSet::new();
        for f in counter.values() {
            if !unique_frequency.insert(*f) {
                return false;
            }
        }
        return true;
    }
}


/*
from collections import Counter

class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        c = Counter(arr)
        a = set()
        for i in c.values():
            if i in a:
                return False
            a.add(i)
        return True
 */
