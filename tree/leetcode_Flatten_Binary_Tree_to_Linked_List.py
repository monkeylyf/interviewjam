"""Flaten binary tree to linked list
leetcode

Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
"""


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        flatten_left = root.left
        self.flatten(root.left)
        root.left = None
        right = root.right
        if flatten_left:
            root.right = flatten_left
            while flatten_left.right:
                flatten_left = flatten_left.right
            flatten_left.right = right
        self.flatten(right)


def main():
    sol = Solution()

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)

    sol.flatten(root)

    while root:
        print root.val,
        root = root.right


if __name__ == '__main__':
    main()
