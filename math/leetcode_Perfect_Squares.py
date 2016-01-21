"""Perfect squares
leetcode

Given a positive integer n, find the least number of perfect square numbers
(for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
return 2 because 13 = 4 + 9.
"""

class Solution(object):
    def numSquares(self, n):
        """https://en.wikipedia.org/wiki/Lagrange%27s_four-square_theorem."""
        while n % 4 == 0:
            n /= 4

        if n % 8 == 7:
            return 4

        a = 0
        while a * a <= n:
            b = int((n - a * a) ** 0.5)
            if a ** 2 + b ** 2 == n:
                return (1 if a > 0 else 0) + (1 if b > 0 else 0)
            a += 1
        return 3

    def numSquaresDP(self, n):
        """DP. TLE.

        Obviously greedy won't work:
        12 = 4 + 4 + 4 = 9 + 1 + 1 + 1.

        :type n: int
        :rtype: int
        """
        dp = [float('+inf')] * (n + 1)
        dp[0] = 0
        for i in xrange(n + 1):
            j = 1
            while i + j * j <= n:
                dp[i + j * j] = min(dp[i + j * j], dp[i] + 1)
                j += 1

        return dp[-1]


def main():
    sol = Solution()
    assert sol.numSquares(1) == 1
    assert sol.numSquares(2) == 2
    assert sol.numSquares(3) == 3
    assert sol.numSquares(4) == 1
    assert sol.numSquares(5) == 2
    assert sol.numSquares(6) == 3
    assert sol.numSquares(7) == 4
    assert sol.numSquares(8) == 2
    assert sol.numSquares(9) == 1
    assert sol.numSquares(10) == 2
    assert sol.numSquares(11) == 3
    assert sol.numSquares(12) == 3
    assert sol.numSquares(13) == 2
    assert sol.numSquares(16) == 1
    assert sol.numSquares(18) == 2
    assert sol.numSquares(19) == 3


if __name__ == '__main__':
    main()
