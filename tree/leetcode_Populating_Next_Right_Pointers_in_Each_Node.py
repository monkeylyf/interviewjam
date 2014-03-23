"""leetcode_Populating_Next_Right_Pointers_in_Each_Node
leetcode

http://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
"""


class TreeNode:

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None


class Solution:
    # @param root, a tree node
    # @return nothing
    def connect(self, root):
        def preorder(node):
            """Nested function."""
            if not node:
                return
            
            if node.left and node.right:
                node.left.next = node.right
                if node.next:
                    node.right.next = node.next.left
            preorder(node.left)
            preorder(node.right)

        if not root:
            return
        # Take care of the next pointer of root first.
        root.next = None
        preorder(root)

    def run(self):
        pass


def main():
    Solution().run()


if __name__ == '__main__':
    main()
