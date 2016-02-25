"""Binary tree upside down.
leetcode

Given a binary tree where all the right nodes are either leaf nodes with a
sibling (a left node that shares the same parent node) or empty, flip it upside
down and turn it into a tree where the original right nodes turned into left
leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1
"""


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __repr__(self):
        return '{}'.format(self.val)


class Solution(object):

    def upsideDownBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root is None:
            return root

        # Unlink children for root only. Children of all the left childrens
        # will be re-pointed but root. If don't do that, root and root.left
        # will be pointing to each other and cause
        left = root.left
        right = root.right
        root.left = None
        root.right = None
        while left is not None:
            # Save reference before re-pointing.
            left_left = left.left
            left_right = left.right
            # Re-pointing
            left.left = right
            left.right = root
            # For next level.
            root = left
            left = left_left
            right = left_right
        return root


def bfs(root):
    from collections import deque
    queue = deque([root])
    lvl_count = 1

    while queue:
        node = queue.popleft()
        print node,
        lvl_count -= 1

        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)

        if lvl_count == 0:
            lvl_count = len(queue)
            print


def main():
    sol = Solution()
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    print 'before'
    bfs(root)
    root = sol.upsideDownBinaryTree(root)
    print 'after'
    bfs(root)


if __name__ == '__main__':
    main()
