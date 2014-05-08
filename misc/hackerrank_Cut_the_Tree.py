"""hackerrank_Cut_the_Tree

https://www.hackerrank.com/contests/w2/challenges/cut-the-tree
"""


def traverse(node, adj, visited):
    s = [0]
    preorder = []

    while s:
        node = s.pop() 
        if visited[node]:
            continue

        preorder.append(node)
        visited[node] = True

        for child in adj[node][::-1]:
            s.append(child)
    
    return preorder

def main():
    N = int(raw_input())
    weights = map(int, raw_input().split())
    total_weight = sum(weights)
    adj = [ [] for _ in xrange(N) ]

    for _ in xrange(N - 1):
        (a, b) = map(int, raw_input().split())
        adj[a - 1].append(b - 1)
        adj[b - 1].append(a - 1)

    tree = [ [] for _ in xrange(N) ]
    visited = [ False ] * N

    preorder = traverse(0, adj, visited)

    subtree_weights = [ 0 ] * N

    while preorder:
        node = preorder.pop()
        subtree_weights[node] = weights[node]
        # Small magic here:
        # For the parent node, subtree_weights[parent] will be 0
        # Since it's postorder.
        for neighbor in adj[node]:
            subtree_weights[node] += subtree_weights[neighbor]

    print min([ abs(subtree_weights[0] - 2 * weight) for weight in subtree_weights ])


if __name__ == '__main__':
    main()
