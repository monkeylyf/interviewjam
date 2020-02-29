/**
 * Count the number of segments in a string, where a segment is defined to be a
 * contiguous sequence of non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 *
 * Example:
 * Input: "Hello, my name is John"
 * Output: 5
 */

fn main() {
    assert_eq!(5, Solution::count_segments("Hello, my name is John".to_string()));
    assert_eq!(0, Solution::count_segments("".to_string()));
    assert_eq!(0, Solution::count_segments("".to_string()));
    assert_eq!(1, Solution::count_segments(" a ".to_string()));
    assert_eq!(2, Solution::count_segments(" a b ".to_string()));
}

struct Solution {}

impl Solution {
    pub fn count_segments(s: String) -> i32 {
        let mut count: i32 = 0;
        let mut start: usize = 0;
        for (i, c) in s.chars().enumerate() {
            if c == ' ' {
                if i > start {
                    count += 1;
                }
                start = i + 1;
            }
        }
        return if start < s.len() { count + 1} else { count };
    }
}
