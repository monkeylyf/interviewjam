# https://leetcode.com/problems/matrix-block-sum/

from typing import List

def get_row_sum(row, j, k, m):
    start_j = max(0, j - k)
    end_j = min(j + k, m - 1)

    total = 0

    for i in range(start_j, end_j + 1):
        total += row[i]

    return total


def get_block_sum(mat, i, j, k, n, m):
    start_i = max(0, i - k)
    end_i = min(i + k, n - 1)

    total = 0
    for i in range(start_i, end_i + 1):
        total += get_row_sum(mat[i], j, k, m)

    return total


class Solution:
    def matrixBlockSum(self, mat: List[List[int]], K: int) -> List[List[int]]:
        n = len(mat)
        m = len(mat[0])

        blocks = [[0 for _ in range(m)] for _ in range(n)]
        for j in range(m):
            base = get_block_sum(mat, 0, j, K, n, m)
            print(base)
            blocks[0][j] = base
            for i in range(1, n):
                start_i = i - K
                end_i = i + K
                # Key: only calulate the slide-out row and slide-in row.
                if start_i - 1 >= 0:
                    base -= get_row_sum(mat[start_i - 1], j, K, m)
                if i + K < n:
                    base += get_row_sum(mat[end_i], j, K, m)
                blocks[i][j] = base

        return blocks


def main():
    sol = Solution()
    matrix = [[1,2,3],[4,5,6],[7,8,9]]
    #print(sol.matrixBlockSum(matrix, 1))
    matrix = [[67,64,78],[99,98,38],[82,46,46],[6,52,55],[55,99,45]]
    print(sol.matrixBlockSum(matrix, 3))


if __name__ == '__main__':
    main()
