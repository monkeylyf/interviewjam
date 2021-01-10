# https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def maxLevelSum(self, root: TreeNode) -> int:
        if not root:
            return 0

        queue = [root]
        next_level = []
        s = 0
        max_sum = -float('inf')
        max_level = 1
        level = 1
        while queue:
            node = queue.pop()
            s += node.val
            if node.left is not None:
                next_level.append(node.left)
            if node.right is not None:
                next_level.append(node.right)

            if not queue:
                if max_sum < s:
                    max_sum = s
                    max_level = level
                # Reset.
                queue = next_level
                next_level = []
                s = 0
                level += 1
        return max_level


def main():
    sol = Solution()
    root = TreeNode(989)
    root.right = TreeNode(10250)
    root.right.left = TreeNode(98693)
    root.right.right = TreeNode(-89388)
    root.right.right.right = TreeNode(-32127)
    #print(sol.maxLevelSum(root))
    root = TreeNode(-100)
    root.left = TreeNode(-200)
    root.right = TreeNode(-300)
    root.left.left = TreeNode(-20)
    root.left.right = TreeNode(-5)
    root.right.left = TreeNode(-10)
    print(sol.maxLevelSum(root))


if __name__ == '__main__':
    main()
