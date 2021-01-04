# https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

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
