"""Sum root to leaf numbers
leetcode

Given a binary tree containing digits from 0-9 only, each root-to-leaf path
could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
"""


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def sumNumbers(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0

        total = 0
        queue = [(root, 0)]
        while queue:
            node, parent_sum = queue.pop()

            current_sum = parent_sum * 10 + node.val
            if node.left is None and node.right is None:
                total += current_sum

            if node.left is not None:
                queue.append((node.left, current_sum))
            if node.right is not None:
                queue.append((node.right, current_sum))

        return total


def main():
    sol = Solution()

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)

    assert sol.sumNumbers(root) == 25


if __name__ == '__main__':
    main()
