/**
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B,
 * where A and B are valid parentheses strings, and + represents string
 * concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid
 * parentheses strings.
 *
 * A valid parentheses string S is primitive if it is nonempty, and there does
 * not exist a way to split it into S = A+B, with A and B nonempty valid
 * parentheses strings.
 *
 * Given a valid parentheses string S, consider its primitive decomposition:
 * S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 *
 * Return S after removing the outermost parentheses of every primitive string
 * in the primitive decomposition of S.
 *
 * Example 1:
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 *
 * Example 2:
 * Input: "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation:
 * The input string is "(()())(())(()(()))", with primitive decomposition
 * "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is
 * "()()" + "()" + "()(())" = "()()()()(())".
 *
 * Example 3:
 * Input: "()()"
 * Output: ""
 * Explanation:
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 *
 * Note:
 * S.length <= 10000
 * S[i] is "(" or ")"
 * S is a valid parentheses string
 */

fn main() {
    println!("{:?}", Solution::remove_outer_parentheses("(()())(())(()(()))".to_string()));
}

struct Solution {}

impl Solution {
    pub fn remove_outer_parentheses(s: String) -> String {
        let length: usize = s.len();
        let mut prev: usize = 0;
        let mut count: i32 = 0;
        let mut removed: String = "".to_string();
        for (i, c) in s.chars().enumerate() {
            if c == '(' {
                count += 1;
            } else {
                count -= 1;
            }
            if count == 0 {
                removed.push_str(&s[prev + 1..i]);
                prev = i + 1;
            }
        }
        return removed.to_string();
    }
}

/*
class Solution:
    def removeOuterParentheses(self, S: str) -> str:
        count = 0
        prev = 0
        i = 0
        length = len(S)
        parentheses = []
        while i < length:
            char = S[i]
            if char == '(':
                count += 1
            else:
                count -= 1
            if count == 0:
                parentheses.append(S[prev + 1:i])
                prev = i + 1
            i += 1

        return ''.join(parentheses)
 */
