"""Binary tree vertical order traversal
leetcode

Given a binary tree, return the vertical order traversal of its nodes' values.
(ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to
right.

Examples:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,20,4,5,2,7],
    _3_
   /   \
  9    20
 / \   / \
4   5 2   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,5,2],
  [20],
  [7]
]
"""

from collections import deque, defaultdict

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def verticalOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        mapping = defaultdict(list)
        queue = deque([(root, 0)])
        min_col = 0
        max_col = 0
        while queue:
            node, col = queue.popleft()
            mapping[col].append(node.val)
            if node.left is not None:
                min_col = min(min_col, col - 1)
                queue.append((node.left, col - 1))
            if node.right is not None:
                max_col = max(max_col, col + 1)
                queue.append((node.right, col + 1))
        container = []

        for i in xrange(min_col, max_col + 1):
            container.append(mapping[i])
        return container


def main():
    sol = Solution()
    root = TreeNode(6)
    root.left = TreeNode(1)
    root.left.right = TreeNode(3)
    root.left.right.left = TreeNode(2)
    root.left.right.right = TreeNode(5)
    root.left.right.right.left = TreeNode(4)

    print sol.verticalOrder(root)


if __name__ == '__main__':
    main()
