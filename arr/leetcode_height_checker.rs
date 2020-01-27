/**
 * Students are asked to stand in non-decreasing order of heights for an annual
 * photo.
 *
 * Return the minimum number of students that must move in order for all
 * students to be standing in non-decreasing order of height.
 *
 * Example 1:
 * Input: heights = [1,1,4,2,1,3]
 * Output: 3
 *
 * Constraints:
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */

fn main() {
    let heights: Vec<i32> = vec![1, 1, 4, 2, 1, 3];
    assert_eq!(3, Solution::height_checker(heights));
}

struct Solution {}

impl Solution {
    pub fn height_checker(heights: Vec<i32>) -> i32 {
        let mut copied_heights: Vec<i32> = heights.iter().cloned().collect();
        copied_heights.sort();
        let mut i: usize = 0;
        let mut ret: i32 = 0;
        while i < heights.len() {
            if copied_heights[i] != heights[i] {
                ret += 1;
            }
            i += 1;
        }
        return ret;
    }
}

/*
class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        sort = sorted(heights)
        i = 0
        num_of_swap = 0
        while i < len(heights):
            if sort[i] != heights[i]:
                num_of_swap += 1
            i += 1
        return num_of_swap
 */
