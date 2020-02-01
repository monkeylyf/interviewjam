/**
 * Given an array of integers A sorted in non-decreasing order, return an array
 * of the squares of each number, also in sorted non-decreasing order.
 *
 * Example 1:
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 *
 * Example 2:
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 * Note:
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 */

fn main() {
    let input1: Vec<i32> = vec![-4, -1, 0, 3, 10];
    assert_eq!(vec![0, 1, 9, 16, 100], Solution::sorted_squares(input1));

    let input2: Vec<i32> = vec![-7, -3, 2, 3, 11];
    assert_eq!(vec![4, 9, 9, 49, 121], Solution::sorted_squares(input2));
}

struct Solution {}


impl Solution {
    pub fn sorted_squares(a: Vec<i32>) -> Vec<i32> {
        let mut sorted: Vec<i32> = Vec::with_capacity(a.len());
        let mut left: usize = 0;
        for (i, value) in a.iter().enumerate() {
            if *value < 0 {
                left = i;
            }
        }
        left += 1;  // usize can not be -1.
        let mut right: usize = left;
        while 0 < left && right < a.len() {
            let left_value: i32 = a[left - 1];
            let right_value: i32 = a[right];
            if -left_value > right_value {
                sorted.push(right_value * right_value);
                right += 1;
            } else {
                sorted.push(left_value * left_value);
                left -= 1;
            }
        }
        while 0 < left {
            let left_value: i32 = a[left - 1];
            sorted.push(left_value * left_value);
            left -= 1;
        }

        while right < a.len() {
            let right_value: i32 = a[right];
            sorted.push(right_value * right_value);
            right += 1;
        }
        return sorted;
    }
}
