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

        dp = map(int, matrix[0])
        max_length = max(dp)
        for i in xrange(1, n):
            nx_dp = [0] * m
            for j in xrange(m):
                if j == 0:
                    nx_dp[0] = int(matrix[i][j])
                elif matrix[i][j] == '1':
                    # Draw it then you will understand it.
                    nx_dp[j] = min(nx_dp[j - 1], dp[j - 1], dp[j]) + 1
                else:
                    pass

                max_length = max(max_length, nx_dp[j])
            dp = nx_dp
        return max_length * max_length


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
