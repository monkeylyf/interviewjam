/**
 * Given a non negative integer number num. For every numbers i in the range
 * 0 ≤ i ≤ num calculate the number of 1's in their binary representation and
 * return them as an array.
 *
 * Example 1:
 * Input: 2
 * Output: [0,1,1]
 *
 * Example 2:
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * Follow up:
 *
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)).
 * But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like
 * __builtin_popcount in c++ or in any other language.
 */

fn main() {
    assert_eq!(vec![0, 1, 1], Solution::count_bits(2));
    assert_eq!(vec![0, 1, 1, 2, 1, 2], Solution::count_bits(5));
}

struct Solution {}

impl Solution {
    pub fn count_bits(num: i32) -> Vec<i32> {
        if num == 0 {
            return vec![0];
        }
        if num == 1 {
            return vec![0, 1];
        }
        let mut bits: Vec<i32> = vec![0, 1];
        let mut i: i32 = num;
        let mut base: i32 = 1;
        while i > 0 {
            if base != 1 {
                let length: usize = if i >= base { bits.len() } else { i as usize };
                for index in 0..length {
                    let val: i32 = bits[index];
                    bits.push(val + 1);
                }
            }
            i -= base;
            base *= 2;
        }
        return bits;
    }
}
