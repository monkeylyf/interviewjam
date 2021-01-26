# https://leetcode.com/problems/number-of-closed-islands/


from typing import List

class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0

        number_of_closed = 0
        n = len(grid)
        m = len(grid[0])

        directions = ((1, 0), (-1, 0), (0, -1), (0, 1))

        for i in range(n):
            for j in range(m):
                if grid[i][j] == 0:
                    is_surrounded = True
                    # BFS
                    queue = [(i, j)]
                    while queue:
                        x, y = queue.pop()
                        grid[x][y] = -1  # Mark as visited.
                        for dx, dy in directions:
                            xx = x + dx
                            yy = y + dy
                            if 0 <= xx and xx < n and 0 <= yy and yy < m:
                                if grid[xx][yy] == 0:
                                    queue.append((xx, yy))
                            elif is_surrounded:
                                is_surrounded = False
                    if is_surrounded:
                        number_of_closed += 1

        return number_of_closed
