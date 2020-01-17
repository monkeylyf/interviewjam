/**
 * Given an array of distinct integers arr, find all pairs of elements with the
 * minimum absolute difference of any two elements.
 *
 * Return a list of pairs in ascending order(with respect to pairs), each pair
 * [a, b] follows
 *
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 *
 * Example 1:
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with
 * difference equal to 1 in ascending order.
 *
 * Example 2:
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 *
 * Example 3:
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 *
 * Constraints:
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 */

use std::cmp::min;
use std::i32::MAX;

fn main() {
    let arr: Vec<i32> = vec![3,8,-10,23,19,-4,-14,27];
    assert_eq!(
        vec![vec![-14, -10], vec![19, 23], vec![23, 27]],
        Solution::minimum_abs_difference(arr));
}

struct Solution {}

impl Solution {
    pub fn minimum_abs_difference(arr: Vec<i32>) -> Vec<Vec<i32>> {
        let mut ret: Vec<Vec<i32>> = Vec::new();
        if arr.is_empty() || arr.len() == 1 as usize {
            return ret;
        }
        let mut arr_copied: Vec<i32> = arr.iter().cloned().collect();
        arr_copied.sort();
        let mut min_value: i32 = MAX;
        for i in 0..arr_copied.len() - 1 {
            min_value = min(min_value, arr_copied[i + 1] - arr_copied[i]);
        }
        for i in 0..arr_copied.len() - 1 {
            let left: i32 = arr_copied[i];
            let right: i32 = arr_copied[i + 1];
            if right - left == min_value {
                ret.push(vec![left, right]);
            }
        }
        return ret;
    }
}
/*
class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        if not arr:
            return arr
        arr.sort()
        min_value = float('+inf')
        for i in range(len(arr) - 1):
            min_value = min(arr[i + 1] - arr[i], min_value)
        ret = []
        for i in range(len(arr) - 1):
            a = arr[i]
            b = arr[i + 1]
            if b - a == min_value:
                ret.append([a, b])
        return ret
 */
