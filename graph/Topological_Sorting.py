"""Toposort.

Author: yifeng
"""

def toposort_iterative(adj_list):
    """Finding the toposort order iteratively.

    Using indegree of each vertex. It's guaranteed that there is at least one
    vertex has 0 indegree otherwise there will be a cycle ih the graph that does
    not apply to toposort.

    Find the node and mark it. Decrease the indegree of its neighbors and iterate.
    """
    n = len(adj_list)
    in_degree = [0] * n

    for neighbors in adj_list:
        for neighbor in neighbors:
            in_degree[neighbor] += 1

    visited = [False] * n
    topo_order = []

    for i in xrange(n):
        v = -1
        for j in xrange(n):
            if v >= 0:
                break
            if in_degree[j] == 0 and not visited[j]:
                v = j
        if v < 0:
            break

        visited[v] = True
        topo_order.append(v)

        for j in adj_list[v]:
            in_degree[j] -= 1

    return topo_order


def toposort_recursive(adj_list):
    def dfs(v):
        visited.add(v)
        for i in adj_list[v]:
            if i not in visited:
                dfs(i)
        s.append(v)

    visited = set()
    s = []
    for v in xrange(len(adj_list)):
        if v not in visited:
            dfs(v)

    s.reverse()
    return s


def main():
    # Test case
    #
    # 0-->1
    #  \   \
    #   \----->2--->3
    #
    adj_list = [
                [1, 2],
                [2],
                [3],
                []
               ]
    print toposort_recursive(adj_list)
    print toposort_iterative(adj_list)


if __name__ == '__main__':
    main()
