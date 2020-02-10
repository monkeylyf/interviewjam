/**
 * X is a good number if after rotating each digit individually by 180 degrees,
 * we get a valid number that is different from X.  Each digit must be rotated
 * - we cannot choose to leave it alone.
 *
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8
 * rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each
 * other, and the rest of the numbers do not rotate to any other number and
 * become invalid.
 *
 * Now given a positive number N, how many numbers X from 1 to N are good?
 *
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after
 * rotating.
 * Note:
 *
 * N  will be in range [1, 10000].
 */

fn main() {
    assert_eq!(4, Solution::rotated_digits(10));
}

struct Solution {}

impl Solution {
    pub fn rotated_digits(n: i32) -> i32 {
        let mut count: i32 = 0;
        for i in 1..=n {
            if Solution::is_good_number(i) {
                count += 1;
            }
        }
        return count;
    }

    fn is_good_number(n: i32) -> bool {
        let mut to_other: i32 = 0;
        let mut not: i32 = 0;
        let mut base: i32 = n;
        while base > 0 {
            let divident: i32 = base / 10;
            let remainder: i32 = base - divident * 10;
            if remainder == 2 || remainder == 5 || remainder == 6 || remainder == 9 {
                to_other += 1;
            } else if remainder == 0 || remainder == 1 || remainder == 8 {
                // Do nothing.
            } else {
                not += 1;
            }
            base = divident;
        }
        return not == 0 && to_other > 0;
    }
}
