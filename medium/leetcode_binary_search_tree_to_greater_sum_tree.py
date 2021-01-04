# https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def bstToGst(self, root: TreeNode) -> TreeNode:
        self.update(root, 0)
        return root

    def update(self, root: TreeNode, acc: int) -> int:
        if not root:
            return 0

        right = self.update(root.right, acc)
        original_val = root.val
        root.val += right + acc
        left = self.update(root.left, right + original_val + acc)
        return left + original_val + right
