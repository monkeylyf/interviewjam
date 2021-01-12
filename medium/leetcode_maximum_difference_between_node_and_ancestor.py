# https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def maxAncestorDiff(self, root: TreeNode) -> int:
        def rec(node, visited_max, visited_min):
            if not node:
                return -float('inf')

            val = node.val
            local_visited_min = min(visited_min, val)
            local_visited_max = max(visited_max, val)
            left = rec(node.left, local_visited_max, local_visited_min)
            right = rec(node.right, local_visited_max, local_visited_min)

            return max([left, right, visited_max - val, val - visited_min])
        if not root:
            return -float('inf')
        else:
            val = root.val
            return max(rec(root.left, val, val), rec(root.right, val, val))


def main():
    sol = Solution()
    print(sol.maxAncestorDiff(TreeNode(3)))


if __name__ == '__main__':
    main()
