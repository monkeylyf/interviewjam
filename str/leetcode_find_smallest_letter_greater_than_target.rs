/**
 * Given a list of sorted characters letters containing only lowercase letters,
 * and given a target letter target, find the smallest element in the list that
 * is larger than the given target.
 *
 * Letters also wrap around. For example, if the target is target = 'z' and
 * letters = ['a', 'b'], the answer is 'a'.
 *
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 *
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 * Note:
 * letters has a length in range [2, 10000].
 * letters consists of lowercase letters, and contains at least 2 unique letters.
 * target is a lowercase letter.
 */

fn main() {
    assert_eq!('c', Solution::next_greatest_letter(vec!['c', 'f', 'j'], 'a'));
    assert_eq!('f', Solution::next_greatest_letter(vec!['c', 'f', 'j'], 'c'));
    assert_eq!('f', Solution::next_greatest_letter(vec!['c', 'f', 'j'], 'd'));
    assert_eq!('j', Solution::next_greatest_letter(vec!['c', 'f', 'j'], 'g'));
    assert_eq!('c', Solution::next_greatest_letter(vec!['c', 'f', 'j'], 'j'));
    assert_eq!('c', Solution::next_greatest_letter(vec!['c', 'f', 'j'], 'k'));
}

struct Solution {}

impl Solution {
    pub fn next_greatest_letter(letters: Vec<char>, target: char) -> char {
        let min_greatest: Option<&char> = letters.iter().filter(|x| *x > &target).min();
        return if min_greatest.is_some() {
            *min_greatest.unwrap()
        } else {
            *letters.iter().min().unwrap()
        };
    }
}
