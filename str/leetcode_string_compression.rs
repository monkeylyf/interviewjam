/**
 * Given an array of characters, compress it in-place.
 *
 * The length after compression must always be smaller than or equal to the
 * original array.
 *
 * Every element of the array should be a character (not int) of length 1.
 *
 * After you are done modifying the input array in-place, return the new length
 * of the array.
 *
 * Follow up:
 * Could you solve it using only O(1) extra space?
 *
 * Example 1:
 * Input:
 * ["a","a","b","b","c","c","c"]
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 *
 * Example 2:
 * Input:
 * ["a"]
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * Explanation:
 * Nothing is replaced.
 *
 * Example 3:
 * Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output:
 * Return 4, and the first 4 characters of the input array should be:
 * ["a","b","1","2"].
 *
 * Explanation:
 * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb"
 * is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 *
 * Note:
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 */

fn main() {
    let mut chars1: Vec<char> = vec!['a', 'a', 'b', 'b', 'c', 'c', 'c'];
    assert_eq!(6, Solution::compress(&mut chars1));
    assert_eq!(vec!['a', '2', 'b', '2', 'c', '3'], &chars1[0..6]);

    let mut chars2: Vec<char> = vec!['a'];
    assert_eq!(1, Solution::compress(&mut chars2));
    assert_eq!(vec!['a'], &chars1[0..1]);

    let mut chars1: Vec<char> = vec!['a', 'b', 'b', 'b', 'b', 'b', 'b' ,'b', 'b', 'b', 'b', 'b', 'b'];
    assert_eq!(4, Solution::compress(&mut chars1));
    assert_eq!(vec!['a', 'b', '1', '2'], &chars1[0..4]);
}

struct Solution {}

impl Solution {
    pub fn compress(chars: &mut Vec<char>) -> i32 {
        let mut i: usize = 0;
        let mut start: usize = 0;
        while start < chars.len() {
            let c: char = chars[start];
            let mut end: usize = start + 1;
            while end < chars.len() && chars[end] == c {
                end += 1;
            }
            let count: usize = end - start;
            chars[i] = c;
            i += 1;
            if count > 1 {
                let count_string: String = count.to_string();
                let mut string = count_string.chars();
                while let Some(cc) = string.next() {
                    chars[i] = cc;
                    i += 1;
                }
            }
            start = end;
        }
        return i as i32;
    }
}
