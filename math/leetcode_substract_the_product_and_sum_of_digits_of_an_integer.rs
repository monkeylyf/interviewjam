/**
 * Given an integer number n, return the difference between the product of its
 * digits and the sum of its digits.
 *
 * Example 1:
 * Input: n = 234
 * Output: 15
 * Explanation:
 * Product of digits = 2 * 3 * 4 = 24
 * Sum of digits = 2 + 3 + 4 = 9
 * Result = 24 - 9 = 15
 *
 * Example 2:
 * Input: n = 4421
 * Output: 21
 * Explanation:
 * Product of digits = 4 * 4 * 2 * 1 = 32
 * Sum of digits = 4 + 4 + 2 + 1 = 11
 * Result = 32 - 11 = 21
 *
 * Constraints:
 * 1 <= n <= 10^5
 */

fn main() {
    assert_eq!(21, Solution::subtract_product_and_sum(4421));
}

struct Solution {}

impl Solution {
    pub fn subtract_product_and_sum(n: i32) -> i32 {
        let mut sum: i32 = 0;
        let mut product: i32 = 1;
        let mut i: i32 = n;
        while i > 0 {
            let remainder = i % 10;
            product *= remainder;
            sum += remainder;
            i /= 10;
        }
        return product - sum;
    }
}
/*
class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        """This solution is way faster than divmod to get every last digit as in Rust solution above."""
        s = str(n)
        a = 0
        b = 1
        for i in s:
            i = int(i)
            a += i
            b *= i
        return b - a
 */
