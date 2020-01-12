/*
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 5
 * Output: false
 * Follow up: Could you solve it without loops/recursion?
 */

fn main() {
    assert!(Solution::is_power_of_four(16));
    assert!(!Solution::is_power_of_four(15));
}

struct Solution {}


impl Solution {
    pub fn is_power_of_four(num: i32) -> bool {
        match num {
            1 => true,
            4 => true,
            16 => true,
            64 => true,
            256 => true,
            1024 => true,
            4096 => true,
            16384 => true,
            65536 => true,
            262144 => true,
            1048576 => true,
            4194304 => true,
            16777216 => true,
            67108864 => true,
            268435456 => true,
            1073741824 => true,
            _ => false
        }
    }
}

/*
  class Solution:
    def isPowerOfFour(self, num: int) -> bool:
        """Loop version."""
        while num > 1:
            num, remain = divmod(num, 4)
            if remain != 0:
                return False
        return num == 1
 */
