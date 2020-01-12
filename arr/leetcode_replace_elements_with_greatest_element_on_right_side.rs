/**
 * Given an array arr, replace every element in that array with the greatest
 * element among the elements to its right, and replace the last element with -1.
 *
 * After doing so, return the array.
 *
 * Example 1:
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 *
 *
 * Constraints:
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 */

use std::cmp::max;


fn main() {
    let arr: Vec<i32> = vec![17, 18, 5, 4, 6, 1];
    assert_eq!(vec![18,6,6,6,1,-1], Solution::replace_elements(arr));
    //Solution::replace_elements(arr);
}

struct Solution {}

impl Solution {
    pub fn replace_elements(arr: Vec<i32>) -> Vec<i32> {
        if arr.is_empty() {
            return arr;
        }
        if arr.len() == 1 as usize {
            return vec![-1];  // Otherwise at line 41 usize overflows.
        }

        let mut array: Vec<i32> = arr.iter().cloned().collect();
        let len: usize = array.len();
        let mut max_val: i32 = array[len - 1];

        for i in (0..=len - 2).rev() {
            let val: i32 = array[i];
            array[i] = max_val;
            max_val = max(val, max_val);
        }
        array[len - 1] = -1;

        return array;
    }
}

/*
class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        if not arr:
            return arr

        max_val = arr[-1]
        for i in range(len(arr) - 2, -1, -1):
            val = arr[i]
            arr[i] = max_val
            max_val = max(max_val, val)
        arr[-1] = -1
        return arr
 */
