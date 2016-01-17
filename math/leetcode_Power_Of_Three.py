"""Power of three
leetcode

Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
"""

class Solution(object):

    def isPowerOfThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n == 1:
            return True
        if n == 0 or n % 3 != 0:
            return False
        return self.isPowerOfThree(n / 3)


def main():
    sol = Solution()
    assert not sol.isPowerOfThree(0)
    assert sol.isPowerOfThree(1)
    assert sol.isPowerOfThree(3)
    assert sol.isPowerOfThree(27)
    assert not sol.isPowerOfThree(26)


if __name__ == '__main__':
    main()
