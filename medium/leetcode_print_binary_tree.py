# https://leetcode.com/problems/print-binary-tree/

from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def printTree(self, root: TreeNode) -> List[List[str]]:
        if not root:
            return []
        height = self.find_height(root)
        width = 2 ** height - 1
        grid = [["" for _ in range(width)] for _ in range(height)]
        self.print_bfs(root, width, grid)
        return grid

    def print_bfs(self, node, width, grid):
        queue = [(node, 0, 0, width - 1)]
        while queue:
            n, h, s, e = queue.pop()
            i = (s + e) // 2
            grid[h][i] = str(n.val)
            if n.left is not None:
                queue.append((n.left, h + 1, s, i - 1))
            if n.right is not None:
                queue.append((n.right, h + 1, i + 1, e))

    def print_dfs(self, node, height, start, end, grid):
        if not node:
            return

        i = (start + end) // 2
        grid[height][i] = str(node.val)
        self.print(node.left, height + 1, start, i - 1, grid)
        self.print(node.right, height + 1, i + 1, end, grid)

    def find_height(self, root):
        if not root:
            return 0

        left = self.find_height(root.left)
        right = self.find_height(root.right)
        return 1 + max(left, right)
