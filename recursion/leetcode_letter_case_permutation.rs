/**
 * Given a string S, we can transform every letter individually to be lowercase
 * or uppercase to create another string.  Return a list of all possible strings
 * we could create.
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 *
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */

fn main() {
    assert_eq!(vec!["a1b2".to_string(), "a1B2".to_string(), "A1b2".to_string(), "A1B2".to_string()],
               Solution::letter_case_permutation("a1b2".to_string()));
    assert_eq!(vec!["3z4".to_string(), "3Z4".to_string()],
               Solution::letter_case_permutation("3z4".to_string()));
    assert_eq!(vec!["12345".to_string()], Solution::letter_case_permutation("12345".to_string()));
}

struct Solution {}

impl Solution {
    pub fn letter_case_permutation(s: String) -> Vec<String> {
        let chars: Vec<char> = s.chars().into_iter().collect();
        let mut permutations: Vec<String> = vec![];
        let mut acc: Vec<char> = vec![];
        Solution::permutate(0 as usize, &chars, &mut acc, &mut permutations);
        return permutations;
    }

    fn permutate(i: usize, chars: &Vec<char>, acc: &mut Vec<char>,
                 permutations: &mut Vec<String>) {
        if i == chars.len() {
            permutations.push(acc.iter().collect());
        } else {
            let c: char = chars[i];
            if c.is_digit(10) {
                acc.push(c);
                Solution::permutate(i + 1, chars, acc, permutations);
                acc.pop();
            } else {
                // Do not flip.
                acc.push(c);
                Solution::permutate(i + 1, chars, acc, permutations);
                acc.pop();
                // Flip.
                acc.push(Solution::flip(c));
                Solution::permutate(i + 1, chars, acc, permutations);
                acc.pop();
            }
        }
    }

    fn flip(c: char) -> char {
        return if c.is_lowercase() {
            c.to_uppercase().next().unwrap()
        } else {
            c.to_lowercase().next().unwrap()
        };
    }
}
