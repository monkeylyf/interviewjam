# https://leetcode.com/problems/delete-leaves-with-a-given-value/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def removeLeafNodes(self, root: TreeNode, target: int) -> TreeNode:
        def rec(parent, cur, target):
            if cur is None:
                return
            rec(cur, cur.left, target)
            rec(cur, cur.right, target)

            if cur.val == target and cur.left is None and cur.right is None:
                # Is leaf
                if parent.left is cur:
                    parent.left = None
                elif parent.right is cur:
                    parent.right = None
                return

        dummy = TreeNode(0)
        dummy.left = root

        rec(dummy, root, target)

        node = dummy.left
        dummy.left = None

        return node
