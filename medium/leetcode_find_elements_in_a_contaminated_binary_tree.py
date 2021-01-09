# https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/submissions/


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

def recover(root, nodes=None):
    if nodes is None:
        nodes = set()

    val = root.val
    nodes.add(val)
    if root.left is not None:
        root.left.val = 2 * val + 1
        recover(root.left, nodes)
    if root.right is not None:
        root.right.val = 2 * val + 2
        recover(root.right, nodes)
    return nodes

class FindElements:

    def __init__(self, root: TreeNode):
        self.root = root
        root.val = 0
        self.nodes = recover(root)

    def find(self, target: int) -> bool:
        return target in self.nodes



# Your FindElements object will be instantiated and called as such:
# obj = FindElements(root)
# param_1 = obj.find(target)
