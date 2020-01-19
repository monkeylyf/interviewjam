/**
 *Return the number of permutations of 1 to n so that prime numbers are at prime
 indices (1-indexed.)
 *
 * (Recall that an integer is prime if and only if it is greater than 1, and
 * cannot be written as a product of two positive integers both smaller than it.)
 *
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 *
 * Example 1:
 * Input: n = 5
 * Output: 12
 * Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1]
 * is not because the prime number 5 is at index 1.
 *
 * Example 2:
 * Input: n = 100
 * Output: 682289015
 *
 * Constraints:
 * 1 <= n <= 100
 */

fn main() {
    assert_eq!(682289015, Solution::num_prime_arrangements(100));
}

struct Solution { }

impl Solution {
    pub fn num_prime_arrangements(n: i32) -> i32 {
        let num_of_primes: i32 = Solution::get_number_of_primes(n);
        let modulus: i64 = 1_000_000_007;
        let mut acc: i64 = 1;
        // Permutation of primes in prime indices.
        for i in 1..=num_of_primes {
            acc = acc * i as i64;
            if acc >= modulus {
                acc = acc - (acc / modulus) * modulus;
            }
        }
        // Permutation of non primes.
        for i in 1..=(n - num_of_primes) {
            acc = acc * i as i64;
            if acc >= modulus {
                acc = acc - (acc / modulus) * modulus;
            }
        }
        return acc as i32;
    }

    fn get_number_of_primes(n: i32) -> i32 {
        if n <= 1 {
            return 0;
        } else {
            let mut count: i32 = 0;
            for i in 2..=n {
                if Solution::is_prime(i) {
                    count += 1;
                }
            }
            return count;
        }
    }

    fn is_prime(n: i32) -> bool {
        if n <= 1 {
            return false;
        } else if n == 2{
            return true;
        } else {
            for i in 2..((n as f64).sqrt() as i32 + 1) {
                if n % i == 0 {
                    return false;
                }
            }
            return true;
        }
    }
}
