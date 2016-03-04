"""Number of digit one
leetcode

Given an integer n, count the total number of digit 1 appearing in all
non-negative integers less than or equal to n.

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
        base = 1
        count = 0
        num = n
        while num > 0:
            last_digit = num % 10
            num /= 10
            count += num * base  # When none-last-digit changes
            if last_digit == 1:
                count += n % base + 1  # Count partial right part
            elif last_digit > 1:
                count += base # Count the all right part
            else:
                pass
            base *= 10
        return count


def main():
    sol = Solution()
    assert sol.countDigitOne(10) == 2
    assert sol.countDigitOne(13) == 6
    assert sol.countDigitOne(999) == 300


if __name__ == '__main__':
    main()
