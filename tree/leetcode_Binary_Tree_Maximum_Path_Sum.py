"""Binary tree maximum path sum
leetcode

Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting
node to any node in the tree along the parent-child connections. The path does
not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
"""


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.dfs(root)[1]

    def dfs(self, root):
        if root is None:
            return float('-inf'), float('-inf')

        left, left_max = self.dfs(root.left)
        right, right_max = self.dfs(root.right)

        local = root.val
        left_path = root.val
        right_path = root.val
        if left > 0:
            local += left
            left_path += left
        if right > 0:
            local += right
            right_path += right

        return max(left_path, right_path), max(left_max, right_max, local)
