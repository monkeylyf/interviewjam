"""Minimum Height Tree
leetcode

For a undirected graph with tree characteristics, we can choose any node as the
root. The result graph is then a rooted tree. Among all possible rooted trees,
those with minimum height are called minimum height trees (MHTs). Given such a
graph, write a function to find all the MHTs and return a list of their root
labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given
the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges
are undirected, [0, 1] is the same as [1, 0] and thus will not appear together
in edges.
"""

from collections import defaultdict


class Solution(object):
    def findMinHeightTrees(self, n, edges):
        """Return the node that as root it's MHT.

        Root of MHT cannot be the tree leaves if number of nodes are larger than
        3. When 0 - 1, both of the nodes are qualified. When 0 - 1 - 2, 1 is
        qualified only.
        The approach is 'stripping' the tree by its leafs. After a round of
        stripping it forms a new tree with new leaves and keep stripping til
        it has no more than 4 nodes(5 edges). T

        :type n: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        if n == 1:
            # One node.
            return [0]

        # Build graph with adj set.
        tree = defaultdict(set)
        for node1, node2 in edges:
            tree[node1].add(node2)
            tree[node2].add(node1)

        # Peeling leaves util it's a two or one node tree.
        while len(tree.keys()) > 2:
            leaves = [node for node in tree if len(tree[node]) == 1]
            for leaf in leaves:
                for sub_leaf in tree[leaf]:
                    sub_leaf_neighbor = tree[sub_leaf]
                    tree[sub_leaf].remove(leaf) # Remove edge.
                # Peel node.
                tree.pop(leaf)

        return tree.keys()


def main():
    sol = Solution()
    assert sol.findMinHeightTrees(4, [[1, 0], [1, 2], [1, 3]]) == [1]
    assert sol.findMinHeightTrees(6, [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]) == [3, 4]


if __name__ == '__main__':
    main()
