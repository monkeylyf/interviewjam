"""Roman to Integer
leetcode

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
"""


class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        mapping = {'M': 1000, 'D': 500, 'C': 100, 'L': 50, 'X': 10, 'V': 5, 'I': 1 }

        num = 0
        for i, c in enumerate(s):
            if i == len(s) - 1:
                num += mapping[c]
            else:
                cur = mapping[c]
                nex = mapping[s[i + 1]]
                if cur < nex:
                    num -= cur
                else:
                    num += cur
        return num


def main():
    sol = Solution()
    assert sol.romanToInt('MIV') == 1004


if __name__ == '__main__':
    main()
