"""Number of island II
leetcode

A 2d grid map of m rows and n columns is initially filled with water. We may
perform an addLand operation which turns the water at position (row, col) into
a land. Given a list of positions to operate, count the number of islands after
each addLand operation. An island is surrounded by water and is formed by
connecting adjacent lands horizontally or vertically. You may assume all four
edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water
and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]
"""


class Solution(object):

    def numIslands2(self, m, n, positions):
        """
        :type m: int
        :type n: int
        :type positions: List[List[int]]
        :rtype: List[int]
        """
        islands = []
        num = len(positions)
        parents = range(num)
        seen = {}
        delta = ((-1, 0), (0, -1), (1, 0), (0, 1))
        count = 0
        for i, (x, y) in enumerate(positions):
            x, y = positions[i]
            count += 1
            for dx, dy in delta:
                xx = x + dx
                yy = y + dy
                pos = (xx, yy)
                if xx >= 0 and xx <= m and yy >= 0 and yy <= n and pos in seen:
                    j = seen[pos]  # Neighbor index.
                    i_root = self.find(parents, i)
                    j_root = self.find(parents, j)
                    # Union two islands into one if they haven't been.
                    if i_root != j_root:
                        parents[j_root] = i_root
                        count -= 1
            seen[(x, y)] = i
            islands.append(count)

        return islands

    def find(self, parents, i):
        """Find root parent.

        For root, it points to itself, parents[i] == i.
        """
        while parents[i] != i:
            parents[i] = parents[parents[i]]
            i = parents[i]
        return i


def main():
    sol = Solution()
    positions = [[0, 0], [0, 1], [1, 2], [2, 1]]
    assert sol.numIslands2(3, 3, positions) == [1, 1, 2, 3]

    positions = [[0, 1], [0, 0]]
    assert sol.numIslands2(1, 2, positions) == [1, 1]

    positions = [[0, 0], [7, 1], [6, 1], [3, 3], [4, 1]]
    assert sol.numIslands2(8, 4, positions) == [1, 2, 2, 3, 4]

    positions = [[0, 1], [1, 2], [2, 1], [1, 0], [0, 2], [0, 0], [1, 1]]
    assert sol.numIslands2(3, 3, positions) == [1, 2, 3, 4, 3, 2, 1]


if __name__ == '__main__':
    main()
