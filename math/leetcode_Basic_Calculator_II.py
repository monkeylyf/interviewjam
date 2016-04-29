"""Basic Calculator
leetcode

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators
and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
"""


class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        # Remove all whitespaces.
        s = ''.join(c for c in s if c != ' ')
        result = 0
        prev = 0
        sign = '+'
        i = 0
        while i < len(s):
            # Get number as many digits as possible.
            j = i
            while i < len(s) and s[i].isdigit():
                i += 1
            num = int(s[j:i])
            if sign == '+':
                result += prev
                prev = num
            elif sign == '-':
                result += prev
                prev = -num
            elif sign == '*':
                prev = prev * num
            elif sign == '/':
                # For Python, -3 / 2 = -2 but -1 is wanted
                if prev < 0:
                    prev = -1 * (-prev / num)
                else:
                    prev = prev / num
            else:
                raise ValueError('Invalid Sign: {}'.format(sign))
            if i < len(s):
                sign = s[i]
                i += 1
        return result + prev


def main():
    sol = Solution()
    assert sol.calculate('3 + 2 * 2') == 7
    assert sol.calculate(' 3+5 / 2 ') == 5
    assert sol.calculate(' 3  / 2 ') == 1
    assert sol.calculate(' 14-3/2 ') == 13
    assert sol.calculate("10000-1000/10+100*1") == 10000


if __name__ == '__main__':
    main()
