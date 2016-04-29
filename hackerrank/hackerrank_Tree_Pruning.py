"""hackerrank_Tree_Pruning.py


"""

from pprint import pprint


def pre_order(root):
    """"""
    print root, len(root.kids)

    for kid in root.kids:
        pre_order(kid)


def dfs(root):
    """"""
    weight_sum = root.weight
    for kid in root.kids:
        weight_sum += dfs(kid)

    print root, len(root.kids), weight_sum
    return weight_sum


def build_tree(adj_list, n, weights):
    """"""
    def dfs(idx, visited):
        node = TreeNode(idx, weights[idx - 1]) # Weight is 0-based index.

        for neighbor in adj_list[idx]:
            if visited[neighbor]:
                continue
            visited[neighbor] = True
            node.kids.append(dfs(neighbor, visited))

        return node

    visited = [False] * (n + 1)
    visited[1] = True
    root = dfs(1, visited) # root starts at index 1.

    return root


def main():
    (n, k) = map(int, raw_input().split())
    adj_list = [[] for _ in xrange(n + 1)]
    weights = map(int, raw_input().split())
    for _ in xrange(n - 1):
        (u, v) = map(int, raw_input().split())
        adj_list[u].append(v)
        adj_list[v].append(u)
    pprint(adj_list)
    root = build_tree(adj_list, n, weights)
    #pre_order(root)
    dfs(root)


class TreeNode(object):

    """"""

    __slots__ = ('idx', 'weight', 'kids')

    def __init__(self, idx, weight):
        """"""
        self.idx = idx
        self.weight = weight
        self.kids = []

    def __repr__(self):
        """"""
        return "<{0}: {1}>".format(self.idx, self.weight)


if __name__ == '__main__':
    main()
