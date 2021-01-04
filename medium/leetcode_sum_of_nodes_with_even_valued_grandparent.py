# https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def sumEvenGrandparent(self, root: TreeNode) -> int:
        return self.rec(root, False, False)

    def rec(self, root: TreeNode, isGrandParentEvent: bool, isParentEven: bool) -> int:
        if not root:
            return 0
        is_current_even = root.val % 2 == 0
        left = self.rec(root.left, isParentEven, is_current_even)
        right = self.rec(root.right, isParentEven, is_current_even)
        if isGrandParentEvent:
            return root.val + left + right
        else:
            return left + right
