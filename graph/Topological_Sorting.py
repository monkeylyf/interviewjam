#!/usr/bin/python
# Author: yifeng

def toposort(adj_list):
    #def next(v, adj_list):
    def next(v):
        visited[v] = True
        for i in adj_list[v]:
            if not visited[i]:
                next(i)
        s.append(v)

    n = len(adj_list)
    visited = [ False for _ in xrange(n) ]
    s = []
    for v in xrange(n):
        if not visited[v]:
            next(v)
    s.reverse()
    return s


def main():
    # Test case
    adj_list = [
                [1, 2],
                [2],
                [3],
                []
               ]
    print toposort(adj_list)


if __name__ == '__main__':
    main()
