/**
 * We define the Perfect Number is a positive integer that is equal to the sum
 * of all its positive divisors except itself.
 *
 * Now, given an integer n, write a function that returns true when it is a
 * perfect number and false when it is not.
 *
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * Note: The input number n will not exceed 100,000,000. (1e8)
 */

fn main() {
    assert!(Solution::check_perfect_number(28));
}

struct Solution {}

impl Solution {
    pub fn check_perfect_number(num: i32) -> bool {
        if num <= 1 {
            return false;
        }
        let mut sum: i32 = 1;
        for i in 2..=((num as f64).sqrt() as i32) {
            if num % i == 0 {
                sum += i + num / i;
            }
        }
        return sum == num;
    }
}
