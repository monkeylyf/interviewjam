/**
 * Let's define a function f(s) over a non-empty string s, which calculates the
 * frequency of the smallest character in s. For example, if s = "dcce" then
 * f(s) = 2 because the smallest character is "c" and its frequency is 2.
 *
 * Now, given string arrays queries and words, return an integer array answer,
 * where each answer[i] is the number of words such that f(queries[i]) < f(W),
 * where W is a word in words.
 *
 * Example 1:
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * Output: [1]
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so
 * f("cbd") < f("zaaaz").
 *
 * Example 2:
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second
 * query both f("aaa") and f("aaaa") are both > f("cc").
 *
 * Constraints:
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] are English lowercase letters.
 */

fn main() {
    let queries: Vec<String> = vec!["bbb".to_string(), "cc".to_string()];
    let words: Vec<String> = vec![
        "a".to_string(), "aa".to_string(), "aaa".to_string(), "aaaa".to_string()];
    assert_eq!(vec![1, 2], Solution::num_smaller_by_frequency(queries, words));
}

struct Solution {}

impl Solution {
    pub fn num_smaller_by_frequency(queries: Vec<String>, words: Vec<String>) -> Vec<i32> {
        let mut ret: Vec<i32> = vec![];
        let q: Vec<i32> = queries.iter().map(|s| Solution::f(s)).collect();
        let mut w: Vec<i32> = words.iter().map(|s| Solution::f(s)).collect();
        let length: usize = words.len();
        // Reverse sorting.
        w.sort_by(|a, b| b.cmp(a));
        for query in q {
            if query > w[0] {
                ret.push(0);
            } else if query < w[length - 1] {
                ret.push(length as i32);
            } else {
                // TODO: can be optimized to binary search.
                for (i, val) in w.iter().enumerate() {
                    if val <= &query {
                        ret.push(i as i32);
                        break;
                    }
                }
            }
        }
        return ret;
    }

    fn f(s: &str) -> i32 {
        let chars: Vec<char> = s.chars().into_iter().collect();
        let mut count: i32 = 1;
        let mut smallest_c: char = chars[0];
        for i in 1..s.len() {
            let c: char = chars[i];
            if c < smallest_c {
                smallest_c = c;
                count = 1;
            } else if c == smallest_c {
                count += 1;
            } else {
            }
        }
        return count;
    }
}


/*
class Solution:
    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
        a = [self.f(i) for i in queries]
        b = sorted((self.f(i) for i in words), reverse=True)
        ret = []
        length = len(b)
        for i in a:
            if i > b[0]:
                ret.append(0)
            elif i < b[-1]:
                ret.append(length)
            else:
                # Can be optimized with binary search.
                for j, val in enumerate(b):
                    if val <= i:
                        ret.append(j)
                        break
        return ret

    def f(self, arr):
        min_char = arr[0]
        count = 1
        for i in range(1, len(arr)):
            char = arr[i]
            if char < min_char:
                min_char = char
                count = 1
            elif char == min_char:
                count += 1
            else:
                pass
        return count
 */
