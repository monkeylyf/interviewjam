# https://leetcode.com/problems/binary-tree-pruning/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def pruneTree(self, root: TreeNode) -> TreeNode:
        dummy = TreeNode(2)
        dummy.left = root

        def prune(parent):
            if not parent:
                return True

            to_prune_left = prune(parent.left)
            if to_prune_left:
                parent.left = None
            to_prune_right = prune(parent.right)
            if to_prune_right:
                parent.right = None

            return to_prune_left and to_prune_right and parent.val != 1

        to_prune = prune(dummy)
        dummy.left = None
        if to_prune:
            return None
        else:
            return root

