/*
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 * The rules of Goat Latin are as follows:
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 *
 * For example, the word "goat" becomes "oatgma".
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 * Example 1:
 *
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 *
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 */
use std::collections::HashSet;


fn main() {
    let input1 = String::from("I speak Goat Latin");
    assert_eq!("Imaa peaksmaaa oatGmaaaa atinLmaaaaa",
               Solution::to_goat_latin(input1));

    let input2 = String::from("The quick brown fox jumped over the lazy dog");
    assert_eq!("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa",
               Solution::to_goat_latin(input2));
}

struct Solution { }

impl Solution {
    pub fn to_goat_latin(s: String) -> String {
        let vowels: HashSet<String> = vec![
            "a".to_string(), "e".to_string(), "i".to_string(), "o".to_string(), "u".to_string()]
                .into_iter().collect();
        let tokens = s.split_whitespace();
        let mut latins: Vec<String> = Vec::new();
        for (i, word) in tokens.enumerate() {
            let first_char = &word[0..1];
            let is_first_char_vowel: bool = vowels.contains(&first_char.to_lowercase());
            if is_first_char_vowel {
                latins.push(format!("{}{}{}", word, "ma", "a".repeat(i + 1)));
            } else {
                latins.push(format!("{}{}{}{}", &word[1..], first_char, "ma", "a".repeat(i + 1)));
            };
        }
        return latins.join(" ")
    }
}



/*
class Solution:
    def toGoatLatin(self, S: str) -> str:
        vowels = frozenset(('a', 'e', 'i', 'o', 'u'))
        words = S.split()
        latins = [None] * len(words)
        for i, word in enumerate(words, start=1):
            first_char = word[0]
            prefix = word if first_char.lower() in vowels else word[1:] + first_char
            latins[i - 1] = prefix + 'ma' + 'a' * i
        return ' '.join(latins)
 */
