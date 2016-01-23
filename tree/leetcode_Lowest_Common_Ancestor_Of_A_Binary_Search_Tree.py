"""Lowest common ancestor of a binary search tree
leetcode

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two
given nodes in the BST.

According to the definition of LCA on Wikipedia: "The lowest common ancestor is
defined between two nodes v and w as the lowest node in T that has both v and w
as descendants (where we allow a node to be a descendant of itself)."

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another
example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of
itself according to the LCA definition.
"""

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """Return LCA.

        The different between a binary tree and BST is, for binary tree
        a full traversal O(n) is needed to find the path but for BST it only
        takes O(lgn).

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
                elif node.val < root.val:
                    left_path = path(root.left, node)
                    if left_path:
                        left_path.append(root)
                        return left_path
                    else:
                        return []
                else:
                    right_path = path(root.right, node)
                    if right_path:
                        right_path.append(root)
                        return right_path
                    else:
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


if __name__ == '__main__':
    main()
