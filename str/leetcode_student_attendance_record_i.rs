/**
 * You are given a string representing an attendance record for a student. The
 * record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more
 * than one 'A' (absent) or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his
 * attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */

fn main() {
    assert!(Solution::check_record("PPALLP".to_string()));
    assert!(!Solution::check_record("PPALLL".to_string()));
    assert!(Solution::check_record("LALL".to_string()));
}

struct Solution {}

impl Solution {
    pub fn check_record(s: String) -> bool {
        let mut a: i32 = 0;
        let mut l: usize = 0;
        let chars: Vec<char> = s.chars().collect();
        let mut i: usize = 0;
        while i < s.len() {
            let c: char = chars[i];
            if c == 'A' {
                a += 1;
                i += 1;
            } else if c == 'L' {
                let mut j: usize = i + 1;
                while j < s.len() && chars[j] == 'L' {
                    j += 1;
                }
                if j - i > l {
                    l = j - i;
                }
                i = j;
            } else {
                i += 1;
            }
        }
        return a <= 1 && l <= 2;
    }
}
