/**
 * Find the minimum length word from a given dictionary words, which has all the
 * letters from the string licensePlate. Such a word is said to complete the
 * given string licensePlate
 *
 * Here, for letters we ignore case. For example, "P" on the licensePlate still
 * matches "p" on the word.
 *
 * It is guaranteed an answer exists. If there are multiple answers, return the
 * one that occurs first in the array.
 *
 * The license plate might have the same letter occurring multiple times. For
 * example, given a licensePlate of "PP", the word "pair" does not complete the
 * licensePlate, but the word "supper" does.
 *
 * Example 1:
 * Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * Output: "steps"
 * Explanation: The smallest length word that contains the letters "S", "P",
 * "S", and "T".
 * Note that the answer is not "step", because the letter "s" must occur in the
 * word twice.
 * Also note that we ignored case for the purposes of comparing whether a letter
 * exists in the word.
 *
 * Example 2:
 * Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * Output: "pest"
 * Explanation: There are 3 smallest length words that contains the letters "s".
 * We return the one that occurred first.
 * Note:
 * licensePlate will be a string with length in range [1, 7].
 * licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
 * words will have a length in the range [10, 1000].
 * Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 */

fn main() {
    assert_eq!("steps", Solution::shortest_completing_word(
            "1s3 PSt".to_string(),
            vec!["step".to_string(), "steps".to_string(), "stripe".to_string(), "stepple".to_string()]));
}

struct Solution {}

impl Solution {
    pub fn shortest_completing_word(license_plate: String, words: Vec<String>) -> String {
        let map: [i32; 26] = Solution::to_array_map(&license_plate);
        let mut matched: Vec<&str> = vec![];
        for word in &words {
            let small: [i32; 26] = Solution::to_array_map(word);
            if Solution::contains(map, small) {
                matched.push(word);
            }
        }
        if matched.len() == 1 {
            return matched[0].to_owned();
        }
        let min_len: &usize = &matched.iter().map(|x| x.len()).min().unwrap();
        let first: &str =  &matched.iter().filter(|x| x.len() == *min_len).next().unwrap();
        return first.to_owned();
    }

    fn contains(map: [i32; 26], small: [i32; 26]) -> bool {
        for i in 0..26 as usize {
            if map[i] > small[i] {
                return false;
            }
        }
        return true;
    }

    fn to_array_map(string: &str) -> [i32; 26] {
        let mut map: [i32; 26] = [0; 26];
        for c in string.to_lowercase().chars() {
            if c.is_alphabetic() {
                let index: u32 = c as u32 - 97;
                map[index as usize] += 1
            }
        }
        return map;
    }
}
