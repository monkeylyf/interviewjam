/**
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the
 * whole array sorted in ascending order.
 *
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */

fn main() {
    assert_eq!(5, Solution::find_unsorted_subarray(vec![2, 6, 4, 8, 10, 9, 15]));
}

struct Solution {}


impl Solution {
    pub fn find_unsorted_subarray(nums: Vec<i32>) -> i32 {
        let mut copied: Vec<i32> = nums.iter().cloned().collect();
        copied.sort();
        let length: usize = nums.len();
        let mut i: usize = 0;
        while i < length && nums[i] == copied[i] {
            i += 1;
        }
        let mut j = length;
        while j > i && nums[j - 1] == copied[j - 1] {
            j -= 1;
        }
        return (j - i) as i32;
    }
}
