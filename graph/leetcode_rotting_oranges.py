"""
https://leetcode.com/problems/rotting-oranges/submissions/
"""
from collections import deque
from typing import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        total_orange = 0
        total_rotten = 0

        queue = deque()

        directions = ((1, 0), (0, -1), (0, 1), (-1, 0))

        minute = 0
        n = len(grid)
        m = len(grid[0])
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    total_orange += 1
                elif grid[i][j] == 2:
                    total_orange += 1
                    total_rotten += 1
                    queue.append((i, j))
                else:
                    pass
        if total_rotten == total_orange:
            return 0

        count = len(queue)
        while queue:
            i, j = queue.popleft()
            count -= 1
            for dx, dy in directions:
                ii = i + dx
                jj = j + dy
                if 0 <= ii < n and 0 <= jj < m and grid[ii][jj] == 1:
                    grid[ii][jj] = 2
                    queue.append((ii, jj))
                    total_rotten += 1

            if count == 0:
                minute += 1
                count = len(queue)
        return minute - 1 if total_rotten == total_orange else -1
