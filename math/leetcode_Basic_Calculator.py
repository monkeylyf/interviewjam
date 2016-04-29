"""Basic Caculator
leetcode

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus +
or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
"""


class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack = []
        unary_op = 1
        result = 0
        n = len(s)
        i = 0
        while i < n:
            char = s[i]
            if char.isdigit():
                j = i
                while i + 1 < n and s[i + 1].isdigit():
                    i += 1
                result += int(s[j:i + 1]) * unary_op
            elif char == '+':
                unary_op = 1
            elif char == '-':
                unary_op = -1
            elif char == '(':
                stack.append(result)
                stack.append(unary_op)
                result = 0
                unary_op = 1
            elif char == ')':
                unary_op = stack.pop()
                prev_result = stack.pop()
                result = result * unary_op + prev_result
            else:
                # Bypass whitespace.
                pass
            i += 1
        return result


def main():
    sol = Solution()
    assert sol.calculate("1 + 1") == 2
    assert sol.calculate(" 2-1 + 2 ") == 3
    assert sol.calculate("(1+(4+5+2)-3)+(6+8)") == 23


if __name__ == '__main__':
    main()
