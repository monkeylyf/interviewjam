# https://leetcode.com/problems/path-with-maximum-gold/

from typing import List

class Solution:
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0

        n = len(grid)
        m = len(grid[0])

        max_gold = 0

        for i in range(n):
            for j in range(m):
                if grid[i][j] == 0:
                    continue
                visited = [[False for _ in range(m)] for _ in range(n)]
                local_max = self.dfs(i, j, grid, n, m, visited)
                if local_max > max_gold:
                    max_gold = local_max

        return max_gold

    def dfs(self, x, y, grid, n, m, visited):
        directions = ((1, 0), (-1, 0), (0, 1), (0, -1))
        visited[x][y] = True
        local_max = 0
        for dx, dy in directions:
            xx = x + dx
            yy = y + dy
            if (0 <= xx and xx < n and 0 <= yy and yy < m and
                    not visited[xx][yy] and grid[xx][yy] != 0):
                max_val = self.dfs(xx, yy, grid, n, m, visited)
                if max_val > local_max:
                    local_max = max_val
        visited[x][y] = False
        return grid[x][y] + local_max


def main():
    sol = Solution()
    print(sol.getMaximumGold([[0,6,0],[5,8,7],[0,9,0]]))


if __name__ == '__main__':
    main()
