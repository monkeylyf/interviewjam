"""Maximal square
leetcode

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Return 4.
"""

class Solution(object):

    def maximalSquare(self, matrix):
        """DP solution."""
        if not matrix:
            return 0
        n = len(matrix)
        m = len(matrix[0])
        dp = [[0 for _ in xrange(m)] for _ in xrange(n)]
        max_length = 0
        for i in xrange(n):
            for j in xrange(m):
                if i == 0 or j == 0:
                    # Upper or left bound.
                    dp[i][j] = int(matrix[i][j])
                elif matrix[i][j] == '1':
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1
                max_length = max(max_length, dp[i][j])
        return max_length ** 2

    def maximalSquareNCubic(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        def is_square(matrix, i, j):
            """"""
            return matrix[i][j] == 1 and \
                   matrix[i][j + 1] == 1 and \
                   matrix[i + 1][j] == 1 and \
                   matrix[i + 1][j + 1] == 1

        if len(matrix) == 0:
            return 0

        n = len(matrix)
        m = len(matrix[0])

        for row in matrix:
            if 1 in row:
                break
        else:
            return 0

        length = 1
        larger_square = True
        larger_square_count = 4

        while larger_square_count >= 4 and n > 0 and m > 0:
            larger_square_count = 0
            for i in xrange(n - 1):
                for j in xrange(m - 1):
                    if not is_square(matrix, i, j):
                        # If is_square then matrix[i][j] is already 1.
                        matrix[i][j] == 0
                    else:
                        larger_square_count += 1
            n -= 1
            m -= 1
            if larger_square_count > 0:
                length += 1

        return length ** 2

def main():
    sol = Solution()
    matrix = [
        ['1', '0', '1', '0', '0'],
        ['1', '0', '1', '1', '1'],
        ['1', '1', '1', '1', '1'],
        ['1', '0', '0', '1', '0'],
    ]
    assert sol.maximalSquare(matrix) == 4

    matrix = [
        ['1', '1', '1'],
        ['1', '1', '1'],
        ['1', '1', '1'],
    ]
    assert sol.maximalSquare(matrix) == 9

    matrix = [
        ['1', '1', '1'],
        ['1', '0', '1'],
        ['1', '1', '1'],
    ]
    assert sol.maximalSquare(matrix) == 1

    matrix = [
        ['0', '1', '1'],
        ['1', '1', '1'],
        ['1', '1', '1'],
    ]
    assert sol.maximalSquare(matrix) == 4

    matrix = [
        ['0', '0', '0'],
        ['0', '0', '0'],
        ['0', '0', '0'],
    ]
    assert sol.maximalSquare(matrix) == 0

    assert sol.maximalSquare([]) == 0

if __name__ == '__main__':
    main()
