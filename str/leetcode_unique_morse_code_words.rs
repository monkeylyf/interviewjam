/**
 * International Morse Code defines a standard encoding where each letter is
 * mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps
 * to "-...", "c" maps to "-.-.", and so on.
 *
 * For convenience, the full table for the 26 letters of the English alphabet is
 * given below:
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
 *  "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-",
 *  "-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of
 * the Morse code of each letter. For example, "cba" can be written as
 * "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call
 * such a concatenation, the transformation of a word.
 *
 * Return the number of different transformations among all words we have.
 *
 * Example:
 * Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation:
 * The transformation of each word is:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 *
 * There are 2 different transformations, "--...-." and "--...--.".
 * Note:
 *
 * The length of words will be at most 100.
 * Each words[i] will have length in range [1, 12].
 * words[i] will only consist of lowercase letters.
 */

use std::collections::HashSet;

static MORSE_CODE: &'static [&str] = &[
    ".-",
    "-...",
    "-.-.",
    "-..",
    ".",
    "..-.",
    "--.",
    "....",
    "..",
    ".---",
    "-.-",
    ".-..",
    "--",
    "-.",
    "---",
    ".--.",
    "--.-",
    ".-.",
    "...",
    "-",
    "..-",
    "...-",
    ".--",
    "-..-",
    "-.--",
    "--.."];

fn main() {
    assert_eq!(2, Solution::unique_morse_representations(
            vec!["gin".to_string(), "zen".to_string(), "gig".to_string(), "msg".to_string()]));
}

struct Solution {}

impl Solution {
    pub fn unique_morse_representations(words: Vec<String>) -> i32 {
        let mut set: HashSet<String> = HashSet::new();
        let mut acc: Vec<&str> = vec![];
        for word in words {
            for c in word.chars() {
                let index: u32 = c as u32 - 97;
                let morse_code: &str = MORSE_CODE[index as usize];
                acc.push(morse_code);
            }
            let code: String = acc.join("");
            set.insert(code);
            acc.clear();
        }
        return set.len() as i32;
    }
}
