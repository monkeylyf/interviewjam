"""Closet binary search tree value
leetcode

Given a non-empty binary search tree and a target value, find the value in the
BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to
the target.
"""


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def closestValue(self, root, target):
        """
        :type root: TreeNode
        :type target: float
        :rtype: int
        """
        if root is None:
            raise ValueError('Empty root')
        val = root.val
        while root is not None:
            if abs(target - root.val) < abs(target - val):
                val = root.val

            if root.val > target:
                root = root.left
            else:
                root = root.right
        return val


def main():
    sol = Solution()


if __name__ == '__main__':
    main()
