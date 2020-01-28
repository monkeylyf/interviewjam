/**
 * Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to
 * A[i] interpreted as a binary number (from most-significant-bit to
 * least-significant-bit.)
 *
 * Return a list of booleans answer, where answer[i] is true if and only if N_i
 * is divisible by 5.
 *
 * Example 1:
 * Input: [0,1,1]
 * Output: [true,false,false]
 * Explanation:
 * The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
 * Only the first number is divisible by 5, so answer[0] is true.
 *
 * Example 2:
 * Input: [1,1,1]
 * Output: [false,false,false]
 *
 * Example 3:
 * Input: [0,1,1,1,1,1]
 * Output: [true,false,false,false,true,false]
 *
 * Example 4:
 * Input: [1,1,1,0,1]
 * Output: [false,false,false,false,false]
 *
 * Note:
 * 1 <= A.length <= 30000
 * A[i] is 0 or 1
 */

fn main() {
    let input1: Vec<i32> = vec![0, 1, 1];
    assert_eq!(vec![true, false, false], Solution::prefixes_div_by5(input1));
}

struct Solution {}

impl Solution {
    pub fn prefixes_div_by5(a: Vec<i32>) -> Vec<bool> {
        let mut retval: Vec<bool> = Vec::with_capacity(a.len());
        let mut base: i32 = 0;
        for i in a {
            base = base * 2 + i;
            retval.push(base % 5 == 0);
            // Get remainder to avoid i32 overflow.
            if base > 10_000_000 {
                base = base - (base / 10_000_000) * 10_000_000;
            }
        }
        return retval;
    }
}
