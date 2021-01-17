# https://leetcode.com/problems/maximum-binary-tree-ii/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def insertIntoMaxTree(self, root: TreeNode, val: int) -> TreeNode:
        if not root:
            return TreeNode(val)
        if root.val < val:
            node = TreeNode(val)
            node.left = root
            return node

        # Based on the description, the vale is APPENDED to the orginal array.
		# Given how the tree is constructed by divide and conquer, it first goes
		# right. When the val should be inserted between two nodes, the child node
		# must be reconnect as the left child.
        parent = root
        right = root.right

        while right is not None and right.val > val:
            parent = right
            right = right.right

        if right is None:
            parent.right = TreeNode(val)
        else:
            parent.right = TreeNode(val)
            parent.right.left = right

        return root
