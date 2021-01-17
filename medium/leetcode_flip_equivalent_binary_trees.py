# https://leetcode.com/problems/flip-equivalent-binary-trees/

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def flipEquiv(self, root1: TreeNode, root2: TreeNode) -> bool:
        if root1 is None and root2 is None:
            return True
        elif root1 is None and root2 is not None:
            return False
        elif root1 is not None and root2 is None:
            return False
        elif root1.val != root2.val:
            return False
        else:
            return ((self.flipEquiv(root1.left, root2.right) and
                    self.flipEquiv(root1.right, root2.left)) or
                   (self.flipEquiv(root1.left, root2.left) and
                    self.flipEquiv(root1.right, root2.right)))



def main():
    sol = Solution()
    print(sol.flipEquiv(None, None))


if __name__ == '__main__':
    main()
