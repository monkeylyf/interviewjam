"""Ugly number
leetcode

Write a program to check whether a given number is an ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For
example, 6, 8 are ugly while 14 is not ugly since it includes another prime
factor 7.

Note that 1 is typically treated as an ugly number.
"""


class Solution(object):
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num == 0:
            return False
        for ugly in (2, 3, 5):
            while num % ugly == 0:
                num /= ugly

        return num == 1


def main():
    sol = Solution()
    assert sol.isUgly(1)
    assert sol.isUgly(2)

    assert not sol.isUgly(0)
    assert not sol.isUgly(14)


if __name__ == '__main__':
    main()
