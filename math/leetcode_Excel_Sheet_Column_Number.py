"""Excel Sheet Column Number
leetcode

Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
"""


class Solution(object):

    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        # Base 26 conversion.
        num = 0
        i = len(s) - 1
        base = 1
        while i >= 0:
            c = ord(s[i]) - ord('A') + 1
            num += c * base
            i -= 1
            base *= 26
        return num


def main():
    sol = Solution()
    assert sol.titleToNumber('A') == 1
    assert sol.titleToNumber('AA') == 27


if __name__ == '__main__':
    main()
