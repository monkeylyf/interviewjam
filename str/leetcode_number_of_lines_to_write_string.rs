/**
 * We are to write the letters of a given string S, from left to right into
 * lines. Each line has maximum width 100 units, and if writing a letter would
 * cause the width of the line to exceed 100 units, it is written on the next
 * line. We are given an array widths, an array where widths[0] is the width of
 * 'a', widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.
 *
 * Now answer two questions: how many lines have at least one character from S,
 * and what is the width used by the last such line? Return your answer as an
 * integer list of length 2.
 *
 * Example :
 * Input:
 * widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "abcdefghijklmnopqrstuvwxyz"
 * Output: [3, 60]
 * Explanation:
 * All letters have the same length of 10. To write all 26 letters,
 * we need two full lines and one line with 60 units.
 *
 * Example :
 * Input:
 * widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "bbbcccdddaaa"
 * Output: [2, 4]
 * Explanation:
 * All letters except 'a' have the same length of 10, and
 * "bbbcccdddaa" will cover 9 * 10 + 2 * 4 = 98 units.
 * For the last 'a', it is written on the second line because
 * there is only 2 units left in the first line.
 * So the answer is 2 lines, plus 4 units in the second line.
 */

fn main() {
    let widths: Vec<i32> = vec![10; 26];
    assert_eq!(vec![3, 60], Solution::number_of_lines(widths, "abcdefghijklmnopqrstuvwxyz".to_string()));
    let widths2: Vec<i32> = vec![4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10];
    assert_eq!(vec![2, 4], Solution::number_of_lines(widths2, "bbbcccdddaaa".to_string()));
}

struct Solution {}

impl Solution {
    pub fn number_of_lines(widths: Vec<i32>, s: String) -> Vec<i32> {
        let mut line: i32 = 1;
        let mut number_of_chars: i32 = 0;
        for c in s.chars() {
            let index: u32 = c as u32 - 97;
            let width: i32 = widths[index as usize];
            if number_of_chars + width > 100 {
                line += 1;
                number_of_chars = width;
            } else {
                number_of_chars += width;
            }
        }
        return vec![line, number_of_chars];
    }
}
