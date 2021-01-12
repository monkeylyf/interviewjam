# https://leetcode.com/problems/delete-nodes-and-return-forest/

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def delNodes(self, root: TreeNode, to_delete: List[int]) -> List[TreeNode]:
        def rec(parent, node, to_delete, container):
            if not node:
                return
            left = node.left
            right = node.right
            if node.val in to_delete:
                # Disconnect node from parent>
                if parent:
                    if parent.left is node:
                        parent.left = None
                    if parent.right is node:
                        parent.right = None
                # Disconnect left child from node.
                if left is not None:
                    node.left = None
                    if left.val not in to_delete:
                        container.append(left)
                # Disconnect right child from node.
                if right is not None:
                    node.right = None
                    if right.val not in to_delete:
                        container.append(right)
            rec(node, left, to_delete, container)
            rec(node, right, to_delete, container)

        if root is None:
            return []

        # Add a dummy root to make life a little bit easier.
        dummy = TreeNode(-1)
        dummy.left = root
        to_delete = set(to_delete)
        # Handle root as one of the entrypoint.
        container = [] if root.val in to_delete else [root]
        rec(dummy, root, to_delete, container)
        # Detach dummy root.
        dummy.left = None

        return container
