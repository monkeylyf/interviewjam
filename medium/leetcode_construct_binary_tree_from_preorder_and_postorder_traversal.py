# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def constructFromPrePost(self, pre: List[int], post: List[int]) -> TreeNode:
        if not pre or not post:
            return None

        root = TreeNode(pre[0])
        i = 0
        left = set()
        right = set()
        found = False
        while not found and i < len(pre) - 1:
            left.add(pre[i + 1])
            right.add(post[i])
            found = left == right
            i += 1
        root.left = self.constructFromPrePost(pre[1:i + 1], post[:i])
        root.right = self.constructFromPrePost(pre[i + 1], post[i:])
        return root


def main():
    sol = Solution()
    print(sol.constructFromPrePost([], []))


if __name__ == '__main__':
    main()
