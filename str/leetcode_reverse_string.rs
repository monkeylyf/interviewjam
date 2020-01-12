/*
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 *
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */


fn main() {
    let mut input = "".chars().collect();
    Solution::reverse_string(&mut input);
}

struct Solution { }

impl Solution {
    pub fn reverse_string(s: &mut Vec<char>) {
        if s.is_empty() {
            return
        }
        let mut i: usize = 0;
        let mut j: usize = s.len() - 1;  // When empty, cause usize overflow.
        while i < j {
            let swap: char = s[i];
            s[i] = s[j];
            s[j] = swap;
            i += 1;
            j -= 1;
        }
    }
}
