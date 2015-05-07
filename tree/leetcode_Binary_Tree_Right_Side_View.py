"""leetcode_Binary_Tree_Right_Side_View

https://leetcode.com/problems/binary-tree-right-side-view/
"""

from collections import deque


class TreeNode:

    """Tree node class."""

    __slots__ = ('val', 'left', 'right')

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    """BFS"""

    def rightSideView(self, root):
        """BFS by level order

        Push left child before right one if not None so when pop from queue,
        order is from left to right. Then the latest visited node is the
        right-fucking-most one.

        Such kinda of interview questions should be done within 10 minutes and
        bug-free.
        """
        ret = []
        if root is None:
            return ret

        cur_lvl = deque()
        next_lvl = deque()
        cur_lvl.append(root)

        while cur_lvl:
            node = cur_lvl.popleft()
            if node.left is not None:
                next_lvl.append(node.left)
            if node.right is not None:
                next_lvl.append(node.right)
            if not cur_lvl:
                ret.append(node.val)
                cur_lvl = next_lvl
                next_lvl = deque()

        return ret


def main():
    pass


if __name__ == '__main__':
    main()
