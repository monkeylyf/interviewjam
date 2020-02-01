/**
 * Given two positive integers x and y, an integer is powerful if it is equal to
 * x^i + y^j for some integers i >= 0 and j >= 0.
 *
 * Return a list of all powerful integers that have value less than or equal to
 * bound.
 * You may return the answer in any order.  In your answer, each value should
 * occur at most once.
 *
 * Example 1:
 * Input: x = 2, y = 3, bound = 10
 * Output: [2,3,4,5,7,9,10]
 * Explanation:
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 *
 * Example 2:
 * Input: x = 3, y = 5, bound = 15
 * Output: [2,4,6,8,10,14]
 *
 * Note:
 * 1 <= x <= 100
 * 1 <= y <= 100
 * 0 <= bound <= 10^6
 */

use std::collections::HashSet;

fn main() {
    println!("{:?}", Solution::powerful_integers(2, 3, 10));
    println!("{:?}", Solution::powerful_integers(2, 1, 10));
}

struct Solution {}

impl Solution {
    pub fn powerful_integers(x: i32, y: i32, bound: i32) -> Vec<i32> {
        let mut integers: HashSet<i32> = HashSet::new();
        let a: Vec<i32> = Solution::get(&x, &bound);
        let b: Vec<i32> = Solution::get(&y, &bound);
        for aa in &a {
            for bb in &b {
                let sum: i32 = aa + bb;
                if sum <= bound {
                    integers.insert(sum);
                } else {
                    break;
                }
            }
        }
        let unique: Vec<i32> = integers.iter().cloned().collect();
        return unique;
    }

    fn get(i: &i32, bound: &i32) -> Vec<i32> {
        if *i == 1 {
            return vec![1];
        }
        let mut set: Vec<i32> = vec![];
        let mut base: i32 = 1;
        while base < *bound {
            set.push(base);
            base *= i;
        }
        return set;
    }
}
