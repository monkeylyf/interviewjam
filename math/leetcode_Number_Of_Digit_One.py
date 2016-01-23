"""Number of digit one
leetcode

Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
"""


class Solution(object):
    def countDigitOne(self, n):
        """

        :type n: int
        :rtype: int
        """
        count = (n + 9) / 10  # 1s as last digit.
        base = 10
        while n >= base:
            num = n / base
            count += ((num + 8) / 10) * base # 1s as base
            if num % 10 == 1:
                count += n % base + 1 # leftover
            base *= 10
        return count


def main():
    sol = Solution()
    assert sol.countDigitOne(10) == 2
    assert sol.countDigitOne(13) == 6
    assert sol.countDigitOne(999) == 300


if __name__ == '__main__':
    main()
