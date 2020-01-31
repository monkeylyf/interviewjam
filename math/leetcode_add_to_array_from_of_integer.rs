/**
 * For a non-negative integer X, the array-form of X is an array of its digits
 * in left to right order.  For example, if X = 1231, then the array form is
 * [1,2,3,1].
 *
 * Given the array-form A of a non-negative integer X, return the array-form of
 * the integer X+K.
 *
 * Example 1:
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 *
 * Example 2:
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 *
 * Example 3:
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 *
 * Example 4:
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 *
 * Note：
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * If A.length > 1, then A[0] != 0
 */

fn main() {
    let a: Vec<i32> = vec![1, 2, 0, 0];
    assert_eq!(vec![1, 2, 3, 4], Solution::add_to_array_form(a, 34));

    let b: Vec<i32> = vec![9, 9, 9, 9, 9];
    assert_eq!(vec![1, 0, 0, 0, 0, 0], Solution::add_to_array_form(b, 1));

    let c: Vec<i32> = vec![0];
    assert_eq!(vec![2, 3], Solution::add_to_array_form(c, 23));

    let d: Vec<i32> = vec![0];
    assert_eq!(vec![1, 0, 0, 0], Solution::add_to_array_form(d, 1000));
}

struct Solution {}

impl Solution {
    pub fn add_to_array_form(a: Vec<i32>, k: i32) -> Vec<i32> {
        let mut sum: Vec<i32> = vec![];
        let mut num: i32 = k;
        let mut carry: bool = false;
        for i in a.iter().rev() {
            let digit: i32 = num - num / 10 * 10;
            num = (num - digit) / 10;
            let digit_sum: i32 = if carry {
                i + digit + 1
            } else {
                i + digit
            };
            carry = digit_sum >= 10;
            sum.push(if carry {
                digit_sum - 10
            } else {
                digit_sum
            });
        }
        while num > 0 {
            let digit: i32 = num - num / 10 * 10;
            num = (num - digit) / 10;
            let digit_sum: i32 = if carry {
                digit + 1
            } else {
                digit
            };
            carry = digit_sum >= 10;
            sum.push(if carry {
                digit_sum - 10
            } else {
                digit_sum
            });
        }

        if carry {
            sum.push(1);
        }

        let res: Vec<i32> = sum.iter().cloned().rev().collect();
        return res;
    }
}
