# https://leetcode.com/problems/max-increase-to-keep-city-skyline/

from typing import List


class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        n = len(grid)
        m = len(grid[0])
        left_to_right = [max(row) for row in grid]
        top_to_bottom = [None] * m
        for i in range(m):
            top_to_bottom[i] = max(grid[j][i] for j in range(n))

        total = 0
        for i in range(n):
            for j in range(m):
                total += min(left_to_right[i], top_to_bottom[j]) - grid[i][j]

        return total


def main():
    sol = Solution()
    grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
    print(sol.maxIncreaseKeepingSkyline(grid))


if __name__ == '__main__':
    main()
