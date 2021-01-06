# https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        arr1 = []
        self.inorder(root1, arr1)
        arr2 = []
        self.inorder(root2, arr2)
        n = len(arr1)
        m = len(arr2)
        arr = []
        i = 0
        j = 0
        while i < n and j < m:
            a = arr1[i]
            b = arr2[j]
            if a <= b:
                arr.append(a)
                i += 1
            else:
                arr.append(b)
                j += 1

        while i < n:
            arr.append(arr1[i])
            i += 1

        while j < m:
            arr.append(arr2[j])
            j += 1

        return arr

    def inorder(self, root, acc):
        if not root:
            return

        self.inorder(root.left, acc)
        acc.append(root.val)
        self.inorder(root.right, acc)


def main():
    sol = Solution()
    root1 = TreeNode(2)
    root1.left = TreeNode(1)
    root1.right = TreeNode(4)
    root2 = TreeNode(1)
    root2.left = TreeNode(0)
    root2.right = TreeNode(3)
    print(sol.getAllElements(root1, root2))


if __name__ == '__main__':
    main()
