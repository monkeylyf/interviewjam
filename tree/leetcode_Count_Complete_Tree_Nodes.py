"""Count complete tree nodes
leetcode

Given a complete binary tree, count the number of nodes.
https://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely
filled, and all nodes in the last level are as far left as possible. It can have
between 1 and 2h nodes inclusive at the last level h.
"""


# Definition for a binary tree node.
class TreeNode(object):

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        count = 0
        left_node_height = None
        right_node_height = None
        while root is not None:
            if left_node_height is None:
                left_node_height = self.height(root.left)
            if right_node_height is None:
                right_node_height = self.height(root.right)

            if left_node_height > right_node_height:
                count += 2 ** right_node_height
                root = root.left
                left_node_height -= 1
                right_node_height = None
            elif left_node_height == right_node_height:
                # node.left is root a balanced binary tree with height h
                # Including root and ro0t.left: 1 + (2 ** height - 1)
                count += 1 + (2 ** left_node_height - 1)
                root = root.right
                left_node_height = right_node_height - 1
                right_node_height = None
            else:
                raise ValueError('Not a complete binary tree')
        return count

    def height(self, root):
        """Return height of a tree on left most leaf."""
        count = 0
        while root is not None:
            count += 1
            root = root.left
        return count


def main():
    sol = Solution()

    assert sol.countNodes(None) == 0
    assert sol.countNodes(TreeNode(0)) == 1


if __name__ == '__main__':
    main()
