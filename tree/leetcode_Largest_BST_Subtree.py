"""Largest sbt subtree
leetcode

Given a binary tree, find the largest subtree which is a Binary Search Tree
(BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:
    10
    / \
   5  15
  / \   \
 1   8   7
The Largest BST Subtree in this case is the highlighted one.
The return value is the subtree's size, which is 3.
"""

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):

    class Result(object):

        __slots__ = ('min', 'max', 'size', 'is_bst')

        def __init__(self, min, max, size=0, is_bst=True):
            self.min = min
            self.max = max
            self.size = size
            self.is_bst = is_bst

    def largestBSTSubtree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def rec_bst(root):
            left_res = rec_bst(root.left) if root.left is not None else Solution.Result(root.val, root.val)
            right_res = rec_bst(root.right) if root.right is not None else Solution.Result(root.val, root.val)

            if left_res.is_bst and right_res.is_bst and left_res.max <= root.val and root.val <= right_res.min:
                left_res.max = right_res.max
                left_res.size += right_res.size + 1
                left_res.is_bst = True
            else:
                left_res.max = right_res.max
                left_res.size = max(left_res.size, right_res.size)
                left_res.is_bst = False
            return left_res

        return rec_bst(root).size if root else 0


def main():
    sol = Solution()
    root = TreeNode(2)
    root.left = TreeNode(3)
    root.left.left = TreeNode(1)
    assert sol.largestBSTSubtree(root) == 2

    root = TreeNode(10)
    root.left = TreeNode(5)
    root.right = TreeNode(15)
    root.left.left = TreeNode(1)
    root.left.right = TreeNode(8)
    root.right.right = TreeNode(7)
    assert sol.largestBSTSubtree(root) == 3


if __name__ == '__main__':
    main()
