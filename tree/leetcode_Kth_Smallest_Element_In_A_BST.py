"""Kth smallest element in a bst
leetcode

Given a binary search tree, write a function kthSmallest to find the kth
smallest element in it.

Note:
You may assume k is always valid, 1 <= k <= BST's total elements.
"""

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    COUNTER = 0
    RES = None

    def kthSmallest(self, root, k):
        """This one requires two global(in class scope) varirables
        to track the ith node it's visiting and ref desired node to
        it.

        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        def inorder(root, k):
            if root is None or Solution.RES is not None:
                return

            inorder(root.left, k)
            Solution.COUNTER += 1
            if Solution.COUNTER == k:
                Solution.RES = root
                return
            inorder(root.right, k)

        inorder(root, k)
        return Solution.RES.val

    def kthSmallestWithExtraSpace(self, root, k):
        """Extra O(n) space.

        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        def inorder(root, container):
            if root is not None:
                inorder(root.left, container)
                container.append(root)
                inorder(root.right, container)

        container = []
        inorder(root, container)
        return container[k - 1].val



def main():
    sol = Solution()
    root = TreeNode(1)
    root.right = TreeNode(2)

    assert sol.kthSmallest(root, 2) == 2
    assert sol.kthSmallestWithExtraSpace(root, 2) == 2


if __name__ == '__main__':
    main()
