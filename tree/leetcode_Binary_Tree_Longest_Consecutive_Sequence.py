"""Binary tree longest consecutive sequence.
leetcode

Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    /
   2
  /
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
"""

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def longestConsecutive(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.solve(root, None, 0)

    def solve(self, node, parent, length):
        if node is None:
            return length

        if parent is not None and parent.val + 1 == node.val:
            length += 1
        else:
            length = 1

        return max(length, self.solve(node.left, node, length), self.solve(node.right, node, length))


def main():
    sol = Solution()
    root = TreeNode(1)
    root.right = TreeNode(3)
    root.right.left = TreeNode(2)
    root.right.right = TreeNode(4)
    root.right.right.right = TreeNode(5)

    assert sol.longestConsecutive(root) == 3


if __name__ == '__main__':
    main()
