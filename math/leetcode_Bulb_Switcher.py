"""Bulb switcher
leetcode

It's more a mind trick instead of an algorithm challenge.
"""


class Solution(object):
    def bulbSwitch(self, n):
        """
        :type n: int
        :rtype: int
        """
        # Only numbers can be expressed as i^2 will be switched in odd time
        # to left to be on.
        # Return how manay numbers are there within range[1, n]
        return int(n ** 0.5)


def main():
    sol = Solution()
    assert sol.bulbSwitch(4) == 2
    assert sol.bulbSwitch(4) == 1


if __name__ == '__main__':
    main()
