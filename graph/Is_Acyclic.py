#!/usr/bin/python


def is_acyclic(adj_list):
    def next(v):
        visited[v] = True
        for i in adj_list[v]:
            if not visited[i]:
                next(i)
        s.append(v)

    def dfs(v):
        visited[v] = True
        for i in rev_graph[v]:
            if not visited[i]:
                dfs(i)

    n = len(adj_list)
    visited = [ False for _ in xrange(n) ]
    s = []
    for v in xrange(n):
        if not visited[v]:
            next(v)

    rev_graph = reverse_graph(adj_list)
    visited = [ False for _ in xrange(n) ]
    scc_count = 0
    while s:
        v = s.pop()
        if not visited[v]:
            dfs(v)
            scc_count += 1
    return scc_count == n



def reverse_graph(adj_list):
    n = len(adj_list)
    rev = [ [] for _ in xrange(n) ]
    for v in xrange(n):
        for i in adj_list[v]:
            rev[i].append(v)
    return rev


def main():
    # Test case 1
    adj_list = [
                [1, 2],
                [2],
                [3],
                []
               ]
    assert(is_acyclic(adj_list) == True)
    # Test case 2
    adj_list = [
                [1],
                [2],
                [0, 3],
                []
               ]
    assert(is_acyclic(adj_list) == False)




if __name__ == '__main__':
    main()
