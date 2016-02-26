"""Binary Tree Postorder Traversal
leetcode

Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].
"""

from collections import deque


class TreeNode:

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # @param root, a tree node
    # @return a list of integers
    def postorderTraversal(self, root):
        """Same as preorder/inorder.

        Instead of going left, go right.
        """
        postorder = deque()
        stack = []
        while stack or root is not None:
            while root is not None:
                postorder.appendleft(root.val)
                stack.append(root)
                root = root.right

            root = stack.pop()
            root = root.left

        return list(postorder)


def main():
    sol = Solution()
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.right.right = TreeNode(4)

    print sol.postorderTraversal(root)

    root = TreeNode(3)
    root.left = TreeNode(1)
    root.right = TreeNode(2)

    print sol.postorderTraversal(root)


if __name__ == '__main__':
    main()
