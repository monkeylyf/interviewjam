/**
 * Given a non-negative integer num, return the number of steps to reduce it to
 * zero. If the current number is even, you have to divide it by 2, otherwise,
 * you have to subtract 1 from it.
 *
 * Example 1:
 * Input: num = 14
 * Output: 6
 * Explanation:
 * Step 1) 14 is even; divide by 2 and obtain 7.
 * Step 2) 7 is odd; subtract 1 and obtain 6.
 * Step 3) 6 is even; divide by 2 and obtain 3.
 * Step 4) 3 is odd; subtract 1 and obtain 2.
 * Step 5) 2 is even; divide by 2 and obtain 1.
 * Step 6) 1 is odd; subtract 1 and obtain 0.
 *
 * Example 2:
 * Input: num = 8
 * Output: 4
 * Explanation:
 * Step 1) 8 is even; divide by 2 and obtain 4.
 * Step 2) 4 is even; divide by 2 and obtain 2.
 * Step 3) 2 is even; divide by 2 and obtain 1.
 * Step 4) 1 is odd; subtract 1 and obtain 0.
 *
 * Example 3:
 * Input: num = 123
 * Output: 12
 *
 * Constraints:
 * 0 <= num <= 10^6
 */


fn main() {
    assert_eq!(1, Solution::number_of_steps(1));
    assert_eq!(6, Solution::number_of_steps(14));
}

struct Solution {}

impl Solution {
    pub fn number_of_steps(num: i32) -> i32 {
        let mut steps = 0;
        let mut i = num;

        while i > 0 {
            if i == 1 {
                steps += 1;
            } else if i % 2 == 1 {
                steps += 2;
            } else {
                steps += 1;
            }
            i /= 2;
        }
        return steps;
    }
}
