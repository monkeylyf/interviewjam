/**
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 *
 * Example 1:
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 *
 * Example 2:
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 *
 * Input: n = 1
 * Output: [0]
 *
 * Constraints:
 * 1 <= n <= 1000
 */

fn main() {
    println!("hello world");
    assert_eq!(0, Solution::sum_zero(3).iter().sum());
}

struct Solution {}

impl Solution {
    pub fn sum_zero(n: i32) -> Vec<i32> {
        let mut arr: Vec<i32> = Vec::with_capacity(n as usize);
        for i in 1..=n / 2 {
            arr.push(i);
            arr.push(-i);
        }
        if ((n % 2) + 2) % 2 == 1 {  // % is remainder op not modulus
            arr.push(0);
        }
        return arr;
    }
}
