"""Verify Preorder Sequence in Binary Search Tree
leetcode

Given an array of numbers, verify whether it is the correct preorder traversal
sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?
"""


class Solution(object):

    def verifyPreorder(self, preorder):
        """
        :type preorder: List[int]
        :rtype: bool
        """
        stack = []
        low = float('-inf')
        for node in preorder:
            if node <= low:
                return False
            while stack and node > stack[-1]:
                # Variable low is updated as inorder, which is the root
                # of right subtree whis loop is visiting. It also set the
                # lowest boundary of the part visited.
                low = stack.pop()
            stack.append(node)
        return True


def main():
    sol = Solution()
    preorder = [10, 5, 1, 7, 40, 50]
    assert sol.verifyPreorder(preorder)


if __name__ == '__main__':
    main()
