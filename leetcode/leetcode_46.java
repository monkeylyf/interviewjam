/*Given a string containing just the characters '(' and ')', find the length of
the longest valid (well-formed) parentheses substring.
For "(()", the longest valid parentheses substring is "()", which has length=2.
Another example is ")()())", where the longest valid parentheses substring is
"()()", which has length = 4.
*/

class leetcode_46 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses("()()"));
        System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("("));
        System.out.println(longestValidParentheses(")"));
    }
    public static int longestValidParentheses(String s) {
        int balance = 0;
        int max = 0;
        int cur_num = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                ++balance;
            } else {
                --balance;
                if (balance < 0) {
                    // the valid parentheses has ended.
                    if (cur_num > max) {
                        max = cur_num;
                    }
                    // Reset balance & cur_num.
                    balance = 0;
                    cur_num = 0;
                } else {
                    cur_num += 2;
                }
            }
            ++i;
        }
        if (cur_num > max) max = cur_num;
        return max;
    }
}
