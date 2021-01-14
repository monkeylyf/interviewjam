# https://leetcode.com/problems/delete-node-in-a-bst/

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        if not root:
            return None

        dummyRoot = TreeNode(-1)
        dummyRoot.left = root

        parent = dummyRoot
        node = root
        found = False
        while not found:
            if node.val > key:
                parent = node
                node = node.left
            elif node.val < key:
                parent = node
                node = node.right
            else:
                found = True

        if node is None:
            # Key not found.
            dummyRoot.left = None
            return root

        is_right_child = parent.right is node  # Else then left child.
        if node.right is None:
            if is_right_child:
                parent.right = node.left
            else:
                parent.left = node.left
            node.left = None
        else:
            # Get the left-most leaf
            left_most = node.right
            while left_most.left is not None:
                left_most = left_most.left
            if is_right_child:
                parent.right = node.right
                left_most.left = node.left
            else:
                parent.left = node.right
                left_most.left = node.left
            # Disconnect children of target node.
            node.right = None
            node.left = None

        root = dummyRoot.left
        dummyRoot.left = None
        return root


def main():
    sol = Solution()
    print(sol.deleteNode(None, 1))


if __name__ == '__main__':
    main()
