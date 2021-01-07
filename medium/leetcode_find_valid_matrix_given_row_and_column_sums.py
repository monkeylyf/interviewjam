# https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/

from typing import List


class Solution:
    def restoreMatrix(self, rowSum: List[int], colSum: List[int]) -> List[List[int]]:
        n = len(rowSum)
        m = len(colSum)
        matrix = [[0 for _ in range(m)] for _ in range(n)]
        for i in range(n):
            for j in range(m):
                min_val = min(rowSum[i], colSum[j])
                matrix[i][j] = min_val
                rowSum[i] -= min_val
                colSum[j] -= min_val

        return matrix


def main():
    sol = Solution()
    # print(sol.restoreMatrix([3, 8], [4, 7]))
    print(sol.restoreMatrix([5, 7, 10], [8, 6, 8]))


if __name__ == '__main__':
    main()
