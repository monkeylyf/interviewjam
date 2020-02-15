/**
 * Given an array with n integers, your task is to check if it could become
 * non-decreasing by modifying at most 1 element.
 *
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for
 * every i (1 <= i < n).
 *
 * Example 1:
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * Note: The n belongs to [1, 10,000].
 */

fn main() {
    assert!(Solution::check_possibility(vec![4, 2, 3]));
    assert!(!Solution::check_possibility(vec![4, 2, 1]));
    assert!(!Solution::check_possibility(vec![3, 4, 2, 3]));
    assert!(Solution::check_possibility(vec![2, 3, 3, 2, 4]));
}

struct Solution {}

impl Solution {
    pub fn check_possibility(nums: Vec<i32>) -> bool {
        let mut n: Vec<&i32> = nums.iter().collect();
        let mut i: usize = 1;
        let mut cheat: bool = false;
        while i < n.len() {
            if n[i - 1] > n[i] {
                if cheat {
                    return false;  // Only cheat once.
                } else {
                    // Greedy swap.
                    if i < 2 || n[i - 2] <= n[i] {
                        // [2, 1] -> [1, 1], [2, 1, 3] -> [1, 1, 3]
                        n[i - 1] = n[i];
                    } else {
                        // [2, 2, 1] -> [2, 2, 2]
                        n[i] = n[i- 1];
                    }
                    cheat = true;
                }
            }
            i += 1;
        }
        return true;
    }
}
