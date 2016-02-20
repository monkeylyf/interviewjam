"""Inorder successor in BST
leetcode

Given a binary search tree and a node in it, find the in-order successor of that
node in the BST.
Note: If the given node has no in-order successor in the tree, return null.
"""

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def inorderSuccessor(self, root, p):
        """Two cases:
        1. p has right child, return left-most child of p.right
        2. p has not right child, Ok, read the code to save the verbose
           explanation.
        :type root: TreeNode
        :type p: TreeNode
        :rtype: TreeNode
        """
        if p.right:
            successor = p.right
            while successor.left:
                successor = successor.left
            return successor
        else:
            node = root
            successor = None
            while node is not p:
                if node.val > p.val:
                    successor = node
                    node = node.left
                else:
                    node = node.right
            return successor

    def inorderSuccessorExtraSpace(self, root, p):
        """With extra space.
        :type root: TreeNode
        :type p: TreeNode
        :rtype: TreeNode
        """
        inorder = []
        self.inorder_traversal(root, inorder)

        for i, node in enumerate(inorder):
            if node is p:
                break
        if i == len(inorder) - 1:
            return None
        else:
            return inorder[i + 1]

    def inorder_traversal(self, root, inorder):
        if root is None:
            return
        else:
            self.inorder_traversal(root.left, inorder)
            inorder.append(root)
            self.inorder_traversal(root.right, inorder)


def main():
    sol = Solution()


if __name__ == '__main__':
    main()
