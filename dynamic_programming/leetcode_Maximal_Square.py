"""Maximal square
leetcode

Given a 2D binary matrix filled with 0's and 1's, find the largest square
containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
"""


class Solution(object):

    def maximalSquare(self, matrix):
        """DP solution.

        dp[i][j] means the maximal square of all 1's with right bottom corner
        at (i, j)
        DP relation:
        dp[i][j] = int[matrix[i][j]] if i == 0 or j == 0
                   0                 if matrix[i][j] == 0
                   min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1 if matrix[i][j] == 1

        :param matrix: list, of list of char, either '1' or '0'
        """
        if not matrix:
            return 0
        n = len(matrix)
        m = len(matrix[0])
        dp = [[0 for _ in xrange(m)] for _ in xrange(n)]
        max_area = 0
        for i in xrange(n):
            for j in xrange(m):
                if i == 0 or j == 0:
                    dp[i][j] = int(matrix[i][j])
                elif int(matrix[i][j]) == 1:
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1
                else:
                    pass
                max_area = max(max_area, dp[i][j])
        return max_area * max_area


def main():
    sol = Solution()

    matrix = [
        ['1', '0', '1', '0', '0'],
        ['1', '0', '1', '1', '1'],
        ['1', '1', '1', '1', '1'],
        ['1', '0', '0', '1', '0'],
    ]
    assert sol.maximalSquare(matrix) == 4


if __name__ == '__main__':
    main()
