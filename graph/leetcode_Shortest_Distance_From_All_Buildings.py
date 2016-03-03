"""Shortest distance from alll buildings
leetcode

You want to build a house on an empty land which reaches all buildings in the
shortest amount of distance. You can only move up, down, left and right. You
are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at
(0,2):

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

The point (1,2) is an ideal empty land to build a house, as the total travel
distance of 3+3+1=7 is minimal. So return 7.

Note:
There will be at least one building. If it is not possible to build such house
according to the above rules, return -1.
"""


from collections import deque


class Solution(object):

    """Standarf BFS solution.

    BFS from each building to mark the dist from it in accumulative fashion.
    To make sure the candidates are accessible from all building, using another
    matrix to indicate the number of buildings accessible from this empty land

    However I believe there are a faster way to achieve this by BFS with all
    buildings together as first level of BFS. The problem is how to track which
    cell is visited by which building already. The first cell that accessed by
    all is the one with shortest distance.
    """

    def shortestDistance(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not grid:
            return -1

        n = len(grid)
        m = len(grid[0])
        deltas = ((1, 0), (-1, 0), (0, 1), (0, -1))

        empty_land_count = 0
        for i in xrange(n):
            for j in xrange(m):
                if grid[i][j] == 0:
                    empty_land_count += 1

        hits = [[0 for _ in xrange(m)] for _ in xrange(n)]
        dist = [[0 for _ in xrange(m)] for _ in xrange(n)]
        houses = 0
        queue = deque()
        for i in xrange(n):
            for j in xrange(m):
                if grid[i][j] == 1:
                    houses += 1
                    self.bfs(dist, hits, i, j, grid, n, m, deltas)
        min_dist = -1
        for i in xrange(n):
            for j in xrange(m):
                if hits[i][j] == houses:
                    if min_dist == -1 or min_dist > dist[i][j]:
                        min_dist = dist[i][j]
        return min_dist

    def bfs(self, dist, hits, i, j, grid, n, m, deltas):
        """Breadth first search."""
        queue = deque([(i, j)])
        count = 1
        visited = [[False for _ in xrange(m)] for _ in xrange(n)]
        visited[i][j] = True
        step = 1
        while queue:
            x, y = queue.popleft()
            count -= 1
            for dx, dy in deltas:
                xx = x + dx
                yy = y + dy

                if 0 <= xx and xx < n and 0 <= yy and yy < m and \
                   grid[xx][yy] != 2 and grid[xx][yy] != 1 and \
                   not visited[xx][yy]:
                    queue.append((xx, yy))
                    visited[xx][yy] = True
                    dist[xx][yy] += step
                    hits[xx][yy] += 1

            if count == 0:
                count = len(queue)
                step += 1


def main():
    sol = Solution()
    grid = [
        [1, 0, 2, 0, 1],
        [0, 0, 0, 0, 0],
        [0, 0, 1, 0, 0],
    ]
    assert sol.shortestDistance(grid) == 7

    grid = [
        [1, 1, 1, 1, 1, 0],
        [0, 0, 0, 0, 0, 1],
        [0, 1, 1, 0, 0, 1],
        [1, 0, 0, 1, 0, 1],
        [1, 0, 1, 0, 0, 1],
        [1, 0, 0, 0, 0, 1],
        [0, 1, 1, 1, 1, 0]
    ]
    assert sol.shortestDistance(grid) == 88


if __name__ == '__main__':
    main()
