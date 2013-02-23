/*Longest_Valid_Parentheses

Given a string containing just the characters '(' and ')', find the length of
the longest valid (well-formed) parentheses substring.
For "(()", the longest valid parentheses substring is "()", which has length=2.
Another example is ")()())", where the longest valid parentheses substring is
"()()", which has length = 4.
*/

class leetcode_Longest_Valid_Parentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses("()()"));
        System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("("));
        System.out.println(longestValidParentheses(")"));
        System.out.println(longestValidParentheses(")"));
        System.out.println(longestValidParentheses("()(()"));
    }
    // Iterate input string twice. Three times will not be accepted by onlinejudge.
    public static int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        // Iterater from left to right.
        for (int i = 0; i < s.length(); ++i) {
            // Count left brace and right brace.
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            // num of left matchs num of right, set max.
            if (left == right && left + right > max) {
                max = left + right;
            // num of right is larger than num of left, reset.
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        // Iterater from right to left.
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right && right + left > max) {
                max = right + left;
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return max;
    }
}
