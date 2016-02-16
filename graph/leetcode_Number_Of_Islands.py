"""leetcode_Number_Of_Islands

https://leetcode.com/problems/number-of-islands/
"""

from collections import deque


class Solution:

    """Graph or union-find."""

    def numIslandsGraph(self, grid):
        """BFS approach(coloring)."""
        # Edge case.
        if not grid:
            return 0
        n = len(grid)
        m = len(grid[0])

        visited = [[0 for _ in xrange(m)] for _ in xrange(n)]
        num_of_islands = 0

        for i in xrange(n):
            for j in xrange(m):
                found_island, visited = self.bfs(i, j, grid, n, m, visited)
                num_of_islands += found_island

        return num_of_islands

    def bfs(self, i, j, grid, n, m, visited, shifts=((-1, 0), (1, 0), (0, -1), (0, 1))):
        """Standard bfs."""
        if visited[i][j] == 1 or grid[i][j] == '0':
            return 0, visited

        q = deque()
        q.append((i, j))

        while q:
            x, y = q.popleft()
            for dx, dy in shifts:
                xx = dx + x
                yy = dy + y
                if 0 <= xx and xx < n and 0 <= yy and yy < m and \
                    visited[xx][yy] == 0 and grid[xx][yy] == '1':
                    visited[xx][yy] = 1
                    q.append((xx, yy))

        return 1, visited

    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid:
            return 0
        n = len(grid)
        m = len(grid[0])

        cells = []

        for i in xrange(n):
            for j in xrange(m):
                if grid[i][j] == '1':
                    cells.append((i, j))

        total = len(cells)
        parents = range(total)
        size = [1] * total
        mapping = {}
        delta = ((-1, 0), (0, -1), (1, 0), (0, 1))
        for i, (x, y) in enumerate(cells):
            for dx, dy in delta:
                xx = x + dx
                yy = y + dy
                pos = (xx, yy)
                if xx >= 0 and xx < n and yy >= 0 and yy < m and pos in mapping:
                    idx = mapping[pos]
                    i_parent = self.find(parents, i)
                    j_parent = self.find(parents, idx)
                    if i_parent != j_parent:
                        parents[i_parent] = j_parent
                        size[i_parent] = 0
            mapping[(x, y)] = i
        return sum(size)

    def find(self, parents, i):
        if i != parents[i]:
            parents[i] = parents[parents[i]]
            i = parents[i]
        return i


def main():
    s = Solution()
    grid = [
        '11110',
        '11010',
        '11000',
        '00000',
    ]
    assert s.numIslands(grid) == 1
    grid = [
        '11000',
        '11000',
        '00100',
        '00011',
    ]
    assert s.numIslands(grid) == 3



if __name__ == '__main__':
    main()
