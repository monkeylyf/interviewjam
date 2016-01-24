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
        def height(root):
            """Return height of a tree on left most leaf."""
            if root is None:
                return 0
            else:
                return 1 + height(root.left)

        if root is None:
            return 0

        left_node_height = height(root.left)
        right_node_height = height(root.right)

        if left_node_height > right_node_height:
            # TODO: I am not sure about this....
            # node.right is root of a full binary tree with height including root
            # and root.right: 1 + (2 ** height - 1)
            return 2 ** right_node_height + self.countNodes(root.left)
        elif left_node_height == right_node_height:
            # node.left is root of a full binary tree with height including root
            # and root.left: 1 + (2 ** height - 1)
            return 1 + (2 ** left_node_height - 1) + self.countNodes(root.right)
        else:
            raise ValueError('Not a complete binary tree')


def main():
    sol = Solution()

    assert sol.countNodes(None) == 0
    assert sol.countNodes(TreeNode(0)) == 1


if __name__ == '__main__':
    main()
