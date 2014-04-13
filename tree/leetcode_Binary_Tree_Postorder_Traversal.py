#leetcode_Binary_Tree_Postorder_Traversal


class Solution:
    # @param root, a tree node
    # @return a list of integers
    def postorderTraversal(self, root):
        """Using two stacks.
        
        Bacially it is same as preorder traversal.
        There is the solution using one stack but more complicated and meaningless:
        http://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
        """
        if not root:
            return []
            
        s = [root]
        ret = []
        
        while s:
            cur = s.pop()
            ret.append(cur.val)
            if cur.left:
                s.append(cur.left)
            if cur.right:
                s.append(cur.right)
            
        return list(reversed(ret))

    def run(self):
        print '1'
        root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.right.right = TreeNode(4)

        print self.postorderTraversal(root)


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def main():
    Solution().run()


if __name__ == '__main__':
    main()
