/**
 * Given a non-empty array of integers, return the third maximum number in this
 * array. If it does not exist, return the maximum number. The time complexity
 * must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned
 * instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum
 * distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */

fn main() {
    assert_eq!(1, Solution::third_max(vec![3, 2, 1]));
    assert_eq!(2, Solution::third_max(vec![1, 2]));
    assert_eq!(1, Solution::third_max(vec![2, 2, 3, 1]));
}

struct Solution {}

impl Solution {
    pub fn third_max(nums: Vec<i32>) -> i32 {
        let mut first: Option<i32> = None;
        let mut second: Option<i32> = None;
        let mut third: Option<i32> = None;

        for i in nums {
            if first.is_none() {
                first = Some(i);
            } else if first.unwrap() < i {
                third = second;
                second = first;
                first = Some(i);
            } else if first.unwrap() == i {
                continue;
            } else if second.is_none() {
                second = Some(i);
            } else if second.unwrap() < i {
                third = second;
                second = Some(i);
            } else if second.unwrap() == i {
                continue;
            } else if third.is_none() {
                third = Some(i);
            } else if third.unwrap() < i {
                third = Some(i);
            }
        }

        return third.unwrap_or(first.unwrap());
    }
}
