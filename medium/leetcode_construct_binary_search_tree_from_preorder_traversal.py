# https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        if not preorder:
            return None

        node = TreeNode(preorder[0])
        if len(preorder) == 1:
            return node

        val = preorder[0]
        left = [i for i in preorder if i < val]
        right = [i for i in preorder if i > val]
        node.left = self.bstFromPreorder(left)
        node.right = self.bstFromPreorder(right)
        return node
