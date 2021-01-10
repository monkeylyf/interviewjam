# https://leetcode.com/problems/count-good-nodes-in-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        if root is None:
            return 0
        return 1 + self.rec(root.val, root.left) + self.rec(root.val, root.right)

    def rec(self, prev, node):
        if node is None:
            return 0

        good = prev <= node.val
        val = 1 if good else 0
        max_val = max(prev, node.val)
        return val + self.rec(max_val, node.left) + self.rec(max_val, node.right)
