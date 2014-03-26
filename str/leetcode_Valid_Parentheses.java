/*Valid_Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid
but "(]" and "([)]" are not.
*/

import java.util.Stack;

class leetcode_Valid_Parentheses {
    public static void main(String[] args) {
        isValid("()[]{}");
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLeft(c)) {
                stack.push(c);
            } else {
                // is right parentheses.
                if (stack.empty()) {
                    // Extra right, return false.
                    return false;
                }
                if (!match(stack.pop(),  c)) {
                    // Last left parenthese must match right parentheses.
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isLeft(char c) {
        return c == '{' || c == '[' || c == '(';
    }
    public static boolean match(char c, char d) {
        return (c == '(' && d == ')') || (c == '[' && d == ']') || (c == '{' && d == '}');
    }
}


/* Python Version
def isValid(self, s):
    stack = []
    switch = {')': '(', ']': '[', '}': '{'}
    
    for p in s:
        if p in ('(', '[', '{'):
            stack.append(p)
        else:
            if not stack:
                return False
            elif switch[p] == stack[-1]:
                stack.pop()
            else:
                return False

    return not stack
*/
