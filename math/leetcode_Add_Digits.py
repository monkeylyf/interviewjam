"""Add digits
leetcode

Given a non-negative integer num, repeatedly add all its digits until the result
has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?
"""


class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        while num >= 10:
            i = 0
            while num > 0:
                i += num % 10
                num /= 10
            num = i

        return num


def main():
    sol = Solution()
    assert sol.addDigits(3) == 3
    assert sol.addDigits(10) == 1
    assert sol.addDigits(38) == 2


if __name__ == '__main__':
    main()
