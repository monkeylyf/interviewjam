"""Lowest common ancestor of a binary tree
leetcode

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
in the tree.
According to the definition of LCA on Wikipedia: "The lowest common ancestor is
defined between two nodes v and w as the lowest node in T that has both v and w
as descendants (where we allow a node to be a descendant of itself)."

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
"""

#Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __repr__(self):
        return '{}'.format(self.val)


class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """Find the path from root to given node.

        If two paths have different length, truncate the longer one so that
        they are the same length. Using the analogy of moving the node that
        is deeper up until it's at the same level as another node.
        Then Find the first same node on their path from down to root.

        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        def path(root, node):
            """"""
            if root is not None:
                if root is node:
                    return [root]
                left_path = path(root.left, node)
                if left_path:
                    left_path.append(root)
                    return left_path
                right_path = path(root.right, node)
                if right_path:
                    right_path.append(root)
                    return right_path
            return []

        if p is q:
            # Two nodes are same.
            return p

        p_path = path(root, p)
        q_path = path(root, q)

        n = len(p_path)
        m = len(q_path)

        if n > m:
            p_path = p_path[n - m:]
        elif n < m:
            q_path = q_path[m - n:]

        i = 0
        found = False
        while not found and i < len(p_path):
            if p_path[i] is q_path[i]:
                found = True
            else:
                i += 1

        if not found:
            raise ValueError('wtf')
        return p_path[i]


def main():
    sol = Solution()
    root = TreeNode(3)
    root.left = TreeNode(5)
    root.left.left  = TreeNode(6)
    root.left.right  = TreeNode(2)
    root.left.right.left  = TreeNode(7)
    root.left.right.right  = TreeNode(4)
    root.right = TreeNode(1)
    root.right.left = TreeNode(0)
    root.right.right = TreeNode(8)

    assert str(sol.lowestCommonAncestor(root, root.left.left, root.left.right.right)) == '5'


if __name__ == '__main__':
    main()
