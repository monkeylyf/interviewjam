"""Binary tree path
leetcode

Given a binary tree, return all root-to-leaf paths.
For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
"""


# Definition for a binary tree node.
class TreeNode(object):

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        def inorder(root, acc, container):
            """"""
            if root is None:
                return
            else:
                acc.append(str(root.val))
                if root.left is None and root.right is None:
                    # Leaf node. Check out!
                    container.append('->'.join(acc))
                else:
                    inorder(root.left, acc, container)
                    inorder(root.right, acc, container)
                acc.pop()

        container = []
        inorder(root, [], container)
        return container


def main():
    sol = Solution()

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.right = TreeNode(5)
    assert sol.binaryTreePaths(root) == ['1->2->5', '1->3']


if __name__ == '__main__':
    main()
