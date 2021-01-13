# https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def lcaDeepestLeaves(self, root: TreeNode) -> TreeNode:
        if not root:
            return None

        # Leverage map since node.val is unique in tree.
        path = {}
        queue = [root]
        next_level = []
        current_queue = [root]
        while queue:
            node = queue.pop()
            if node.left is not None:
                path[node.left.val] = node
                next_level.append(node.left)
            if node.right is not None:
                next_level.append(node.right)
                path[node.right.val] = node

            if not queue:
                if not next_level:
                    break
                else:
                    queue = next_level
                    current_queue = next_level[::]
                    next_level =[]

        upper_level = []
        while len(current_queue) > 1:
            for node in current_queue:
                upper_level.append(path[node.val])
            i = 0
            all_same = True
            while all_same and i < len(upper_level) - 1:
                if upper_level[i] is not upper_level[i + 1]:
                    all_same = False
                i += 1
            if all_same:
                return upper_level[0]
            else:
                # Keep check the upper level.
                current_queue = upper_level
                upper_level = []

        return current_queue[0]
