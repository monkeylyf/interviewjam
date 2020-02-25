/**
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are
 * different.
 */

fn main() {
    assert_eq!(2, Solution::hamming_distance(1, 4));
    assert_eq!(1, Solution::hamming_distance(3, 1));
}

struct Solution {}

impl Solution {
    pub fn hamming_distance(x: i32, y: i32) -> i32 {
        let mut i: i32 = x ^ y;
        println!("{}", i);
        let mut count: i32 = 0;
        while i > 0 {
            let divident: i32 = i / 2;
            let remainder: i32 = i - divident * 2;
            if remainder == 1 {
                count += 1;
            }
            i = divident;
        }
        return count;
    }
}
