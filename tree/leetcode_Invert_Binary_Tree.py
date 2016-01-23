"""Invert binary tree
leetcode

Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
"""

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def invertTree(self, root):
        """The description of this question is vague. Invert implies that the
        tree should be modified in-place. Can you? I am not sure. But I think
        what this one really wants is a mirror copy of given tree.
        There are totally different questions. The latter one is way too easy.

        :type root: TreeNode
        :rtype: TreeNode
        """
        if root is None:
            return None:
        else:
            node = TreeNode(root.val)
            node.left = self.invertTree(root.right)
            node.right = self.invertTree(root.left)
            return node


def main():
    sol = Solution()


if __name__ == '__main__':
    main()
