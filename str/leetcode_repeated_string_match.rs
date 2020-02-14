/**
 * Given two strings A and B, find the minimum number of times A has to be
 * repeated such that B is a substring of it. If no such solution, return -1.
 *
 * For example, with A = "abcd" and B = "cdabcdab".
 *
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a
 * substring of it; and B is not a substring of A repeated two times
 * ("abcdabcd").
 *
 * Note:
 * The length of A and B will be between 1 and 10000.
 */

fn main() {
    assert_eq!(3, Solution::repeated_string_match("abcd".to_string(), "cdabcdab".to_string()));
}

struct Solution {}

impl Solution {
    pub fn repeated_string_match(a: String, b: String) -> i32 {
        // Basically it goes with my intuition. If repeated length is larger than
        // b's length, it works or it never works no matther how many more repetition.
        let a_length: usize = a.len();
        let b_length: usize = b.len();
        let mut repeated: usize = b_length / a_length;
        if b_length - repeated * a_length > 0 {
            repeated += 1;
        }
        if a.repeat(repeated).contains(&b) {
            return repeated as i32;
        } else if a.repeat(repeated + 1).contains(&b) {
            return repeated as i32 + 1;
        } else {
            return -1;
        }
    }
}
