"""https://leetcode.com/problems/find-largest-value-in-each-tree-row/submissions/"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        largest = []
        if root is None:
            return largest

        largest_per_row = float('-inf')

        queue = deque([root])
        count = 1

        while queue:
            node = queue.popleft()
            count -= 1
            largest_per_row = max(largest_per_row, node.val)

            if node.left is not None:
                queue.append(node.left)
            if node.right is not None:
                queue.append(node.right)

            if count == 0:
                count = len(queue)
                largest.append(largest_per_row)
                largest_per_row = float('-inf')
        return largest
