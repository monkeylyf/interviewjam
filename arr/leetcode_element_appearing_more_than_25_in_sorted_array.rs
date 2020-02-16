/**
 * Given an integer array sorted in non-decreasing order, there is exactly one
 * integer in the array that occurs more than 25% of the time.
 *
 * Return that integer.
 *
 * Example 1:
 * Input: arr = [1,2,2,6,6,6,6,7,10]
 * Output: 6
 *
 * Constraints:
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 */

fn main() {
}

struct Solution {}

impl Solution {
    pub fn find_special_integer(arr: Vec<i32>) -> i32 {

    }
}


/*
class Solution:
    def findSpecialInteger(self, arr: List[int]) -> int:
        even = len(arr) // 4
        counter = {}
        for i in arr:
            freq = counter.get(i, 0)
            if freq == even:
                return i
            else:
                counter[i] = freq + 1
 */
