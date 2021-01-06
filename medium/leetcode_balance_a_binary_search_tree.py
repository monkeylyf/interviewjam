# https://leetcode.com/problems/balance-a-binary-search-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def balanceBST(self, root: TreeNode) -> TreeNode:
        values = []
        self.collect(root, values)
        print(values)
        return self.construct(values)

    def collect(self, root: TreeNode, values: List[int]):
        if root is None:
            return
        self.collect(root.left, values)
        values.append(root.val)
        self.collect(root.right, values)

    def construct(self, values: List[int]) -> TreeNode:
        if not values:
            return None

        mid = (len(values) + 1) // 2 - 1
        node = TreeNode(values[mid])
        node.left = self.construct(values[:mid])
        node.right = self.construct(values[mid + 1:])

        return node
