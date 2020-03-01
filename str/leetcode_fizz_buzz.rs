/**
 * Write a program that outputs the string representation of numbers from 1 to
 * n.
 *
 * But for multiples of three it should output “Fizz” instead of the number and
 * for the multiples of five output “Buzz”. For numbers which are multiples of
 * both three and five output “FizzBuzz”.
 *
 * Example:
 * n = 15,
 * Return:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 */

fn main() {
    println!("{:?}", Solution::fizz_buzz(15));
}

struct Solution {}

impl Solution {
    pub fn fizz_buzz(n: i32) -> Vec<String> {
        (1..=n)
            .map(|x| Self::to(x))
            .collect::<Vec<String>>()
    }

    fn to(i: i32) -> String {
        if i % 3 == 0 && i % 5 == 0 {
            "FizzBuzz".to_owned()
        } else if i % 3 == 0 {
            "Fizz".to_owned()
        } else if i % 5 == 0 {
            "Buzz".to_owned()
        } else {
            i.to_string()
        }
    }
}
