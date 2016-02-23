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
        if root is None:
            return []

        count = 1
        queue = deque([root])
        view = [root.val]
        while queue:
            node = queue.popleft()
            count -= 1
            if node.left is not None:
                queue.append(node.left)
            if node.right is not None:
                queue.append(node.right)
            if count == 0:
                if queue:
                    view.append(queue[-1].val)
                count = len(queue)
        return view


def main():
    sol = Solution()
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.right.right = TreeNode(4)
    assert sol.rightSideView(root) == [1, 3, 4]


if __name__ == '__main__':
    main()
