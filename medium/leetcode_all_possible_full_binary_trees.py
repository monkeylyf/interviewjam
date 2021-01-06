# https://leetcode.com/problems/all-possible-full-binary-trees/

from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def allPossibleFBT(self, N: int) -> List[TreeNode]:
        if N % 2 == 0:
            return []

        return self.rec(N)

    def rec(self, n: int):
        if n == 1:
            return [TreeNode(0)]

        acc = []
        for left in range(1, n, 2):
            left_trees = self.rec(left)
            right_trees = self.rec(n - 1 - left)
            for l in left_trees:
                for r in right_trees:
                    node = TreeNode(0)
                    node.left = l
                    node.right = r
                    acc.append(node)
        return acc



def main():
    sol = Solution()
    print(len(sol.allPossibleFBT(7)))


if __name__ == '__main__':
    main()
