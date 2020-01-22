/**
 * Given words first and second, consider occurrences in some text of the form
 * "first second third", where second comes immediately after first, and third
 * comes immediately after second.
 *
 * For each such occurrence, add "third" to the answer, and return the answer.
 *
 * Example 1:
 * Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
 * Output: ["girl","student"]
 *
 * Example 2:
 * Input: text = "we will we will rock you", first = "we", second = "will"
 * Output: ["we","rock"]
 */

fn main() {
    let text = "we will we will rock you".to_string();
    let first = "we".to_string();
    let second = "will".to_string();
    assert_eq!(vec!["we", "rock"], Solution::find_ocurrences(text, first, second));
}

struct Solution {
}

impl Solution {
    pub fn find_ocurrences(text: String, first: String, second: String) -> Vec<String> {
        let mut ret: Vec<String> = vec![];
        let words: Vec<&str> = text.split(" ").into_iter().collect();
        if words.len() <= 2 {
            return ret;
        }
        let mut a: &str = words[0];
        let mut b: &str = words[1];
        let mut i: usize = 2;
        while i < words.len() {
            let cur: &str = words[i];
            if a == first && b == second {
                ret.push(cur.to_string());
            }
            a = b;
            b = cur;
            i += 1;
        }
        return ret;
    }
}
