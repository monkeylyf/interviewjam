# https://leetcode.com/problems/distribute-coins-in-binary-tree/

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def distributeCoins(self, root: TreeNode) -> int:
        def rec(node):
			"""Calculates how many coins the subtree needs or lacks.

            :return: (a, b) a represents how many coins the current subtree needs or lacks
                            b represents total move operations are done
			"""
            if node is None:
                return 0, 0

            left, left_op = rec(node.left)
            right, right_op = rec(node.right)
            total = node.val + left + right
            diff = total - 1  # The absolute value of diff is # of operations needed
            return total - 1, left_op + right_op + abs(diff)

        return rec(root)[1]
