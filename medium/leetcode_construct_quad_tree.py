# https://leetcode.com/problems/construct-quad-tree/

from typing import List

# Definition for a QuadTree node.
class Node:
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight

class Solution:
    def construct(self, grid: List[List[int]]) -> Node:
        if not grid:
            return None

        n = len(grid)
        return self._construct(grid, (0, 0), n)

    def _construct(self, grid, top_left, width):
        (rs, cs) = top_left
        if width == 1:
            return Node(grid[rs][cs], True, None, None, None, None)

        total = 0
        for i in range(width):
            for j in range(width):
                total += grid[rs + i][cs + j]
        if total == 0:
            return Node(0, True, None, None, None, None)
        if total == width * width:
            return Node(1, True, None, None, None, None)

        half = width // 2
        top_left = self._construct(grid, (rs, cs), half)
        top_right = self._construct(grid, (rs, cs + half), half)
        down_left = self._construct(grid, (rs + half, cs), half)
        down_right = self._construct(grid, (rs + half, cs + half), half)

        return Node(1, False, top_left, top_right, down_left, down_right)


def main():
    sol = Solution()
    print(sol.construct([[1]]))


if __name__ == '__main__':
    main()
