"""Binary Tree Preorder Traversal
leetcode

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].
"""


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # @param root, a tree node
    # @return a list of integers
    def preorderTraversal(self, root):
        """This code works for both preorder and inorder traversal in interative way"""
        stack = []
        preorder = []
        while stack or root is not None:
            while root is not None:
                preorder.append(root.val)
                stack.append(root)
                root = root.left
            root = stack.pop()
            root = root.right
        return preorder


def main():
    sol = Solution()
    root = TreeNode(1)
    root.right = TreeNode(2)
    root.right.left = TreeNode(3)

    assert sol.preorderTraversal(root) == [1, 2, 3]


if __name__ == '__main__':
    main()
