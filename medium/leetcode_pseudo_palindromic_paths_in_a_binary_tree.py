# https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

from collections import Counter

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right



class Solution:
    def pseudoPalindromicPaths (self, root: TreeNode) -> int:
        return self.rec(root, set())

    def rec(self, root, c):
        if root is None:
            return 0

        if root.val in c:
            c.remove(root.val)
        else:
            c.add(root.val)
        if root.left is None and root.right is None:
            # is leaf
            res = 1 if len(c) <= 1 else 0
            if root.val in c:
                c.remove(root.val)
            else:
                c.add(root.val)
            return res

        count = 0
        if root.left is not None:
            count += self.rec(root.left, c)
        if root.right is not None:
            count += self.rec(root.right, c)

        if root.val in c:
            c.remove(root.val)
        else:
            c.add(root.val)
        return count
