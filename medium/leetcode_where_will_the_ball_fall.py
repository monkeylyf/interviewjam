# https://leetcode.com/problems/where-will-the-ball-fall/

from typing import List


class Solution:
    def findBall(self, grid: List[List[int]]) -> List[int]:
        if not grid:
            return []

        def flow(i, grid, n):
            for j in range(n):
                delta = grid[j][i]
                ii = i + delta
                if ii < 0 or ii >= m or grid[j][ii] != grid[j][i]:
                    # Either out of boundary or v shape is formed.
                    return -1
                i = ii
            return i
        n = len(grid)
        m = len(grid[0])

        return [flow(i, grid, n) for i in range(m)]


def main():
    sol = Solution()
    grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
    print(sol.findBall(grid))
    grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
    print(sol.findBall(grid))
    grid = [[-1]]
    print(sol.findBall(grid))


if __name__ == '__main__':
    main()
