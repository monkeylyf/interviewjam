# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque


class Solution:
    def findBottomLeftValue(self, root: TreeNode) -> int:
        if root is None:
            raise ValueError()

        queue = deque([root])
        left_most = root.val
        count = 1
        while queue:
            node = queue.popleft()
            if node.left is not None:
                queue.append(node.left)

            if node.right is not None:
                queue.append(node.right)
            count -= 1
            if count == 0:
                count = len(queue)
                if queue:
                    left_most = queue[0].val

        return left_most
