# https://leetcode.com/problems/minimum-falling-path-sum/

from typing import List

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if not A:
            return 0

        n = len(A)
        m = len(A[0])

        prev = A[0]
        cur = [0] * m

        for i in range(1, n):
            for j in range(m):
                local = prev[j]
                if j - 1 >= 0 and prev[j - 1] < local:
                    local = prev[j - 1]
                if j + 1 < n and prev[j + 1] < local:
                    local = prev[j + 1]

                cur[j] = local + A[i][j]
            prev = cur
            cur = [0] * m
        return min(prev)


def main():
    sol = Solution()
    print(sol.minFallingPathSum([[1,2,3],[4,5,6],[7,8,9]]))
    print(sol.minFallingPathSum([[1,2,3]]))
    print(sol.minFallingPathSum([]))


if __name__ == '__main__':
    main()
