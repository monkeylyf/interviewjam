"""Walls and Gates

You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to
represent INF as you may assume that the distance to a gate is less than
2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible
to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
"""


from collections import deque

INF = 2147483647


class Solution(object):

    def wallsAndGates(self, rooms):
        """BFS based solution.

        The trick is BFS by level(dis). The init layer are those cells with
        value 0.

        :type rooms: List[List[int]]
        :rtype: void Do not return anything, modify rooms in-place instead.
        """
        if not rooms:
            return
        n = len(rooms)
        m = len(rooms[0])

        # Collect all starting points.
        starting_points = []
        for i in xrange(n):
            for j in xrange(m):
                if rooms[i][j] == 0:
                    starting_points.append((i, j))

        queue = deque(starting_points)
        count = len(starting_points)
        dis = 1
        deltas = ((1, 0), (-1, 0), (0, 1), (0, -1))
        while queue:
            x, y = queue.popleft()
            count -= 1
            for dx, dy in deltas:
                xx = x + dx
                yy = y + dy
                if xx >= 0 and xx < n and \
                   yy >= 0 and yy < m and \
                   rooms[xx][yy] > dis + 1:  # Trimming. No need to continue if dis is already min
                    queue.append((xx, yy))
                    # Update distance.
                    rooms[xx][yy] = dis

            if count == 0:
                count = len(queue)
                dis += 1


def main():
    sol = Solution()
    rooms = [
        [INF, -1, 0, INF],
        [INF, INF, INF, -1],
        [INF, -1, INF, -1],
        [0, -1, INF, INF]
    ]
    sol.wallsAndGates(rooms)
    assert rooms == [[3, -1, 0, 1], [2, 2, 1, -1], [1, -1, 2, -1], [0, -1, 3, 4]]


if __name__ == '__main__':
    main()
