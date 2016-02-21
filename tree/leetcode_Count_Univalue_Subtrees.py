"""Count univalue subtrees
leetcode

Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.
"""


# Definition for a binary tree node.
class TreeNode(object):

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def countUnivalSubtrees(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        is_uniq, size = self.solve(root)
        return size

    def solve(self, root):
        if root is None:
            return True, 0
        left_is_uniq, left_size = self.solve(root.left)
        right_is_uniq, right_size = self.solve(root.right)

        if left_is_uniq and \
           (root.left is None or root.val == root.left.val) and \
           right_is_uniq and \
           (root.right is None or root.val == root.right.val):
            return True, 1 + left_size + right_size
        else:
            return False, left_size + right_size


def main():
    sol = Solution()

    root = TreeNode(5)
    root.left = TreeNode(5)
    root.right = TreeNode(5)
    root.left.left = TreeNode(5)
    root.left.right = TreeNode(5)
    root.right.right = TreeNode(5)

    assert sol.countUnivalSubtrees(root) == 6

    root = TreeNode(5)
    root.left = TreeNode(1)
    root.right = TreeNode(5)
    root.left.left = TreeNode(5)
    root.left.right = TreeNode(5)
    root.right.right = TreeNode(5)

    assert sol.countUnivalSubtrees(root) == 4


if __name__ == '__main__':
    main()
