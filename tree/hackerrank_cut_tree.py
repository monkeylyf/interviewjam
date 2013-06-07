# 20/20 contest
# https://www.hackerrank.com/contests/may13/challenges/cutTree
#

import sys

rl = sys.stdin.readline
n, k = map(int, rl().strip().split())
adj = [ [] for _ in range(n + 1) ]
visited = [ False for _ in range(n + 1) ]
res = 0

for _ in range(n - 1):
    # Read tree as graph represented in adjacency list.
    n1, n2 = map(int, rl().strip().split())
    adj[n1].append(n2)
    adj[n2].append(n1)


def reconstruct(root, visited, adj, tree):
    # fsoto reconstruct tree
    visited[root] = True
    for i in adj[root]:
        if not visited[i]:
            tree[root].append(i)
            reconstruct(i, visited, adj, tree)

# Recontructing tree with root 1.
tree = [ [] for _ in range(n + 1) ]
reconstruct(1, visited, adj, tree)

def dfs(root, k):
    global res
    n = len(tree[root])
    # Reach a leaf.
    if n == 0: 
        dp = [ 0 for _ in range(k + 1) ]
        dp[0] = dp[1] = 1
        res += 1
        return dp
    
    # Cook status matrix of all kid nodes.
    status = [ dfs(kid, k) for kid in tree[root] ]
    # init dp
    dp = [ [ 0 for _ in range(k + 1) ] for _ in range(n) ]
    # Consider only the first kid.
    dp[0] = status[0]
    
    # dp
    for i in range(1, n): # kid #
        for j in range(k + 1): # [1, k]
            for h in range(k + 1):
                if h <= j:
                    dp[i][j] += dp[i - 1][j - h] * status[i][h]
    # Acc res.
    if root == 1:
        # if cur node is the root 1.
        res += sum(dp[n - 1])
    else:
        # if it's not tree root, then this node has an edge connected to its parent.
        # Constrain k will be k - 1
        res += sum(dp[n - 1][:-1])
    # Return status. As a whole subtree. the root of subtree has an edge connected to its parent.
    # Then this subpart has one more way to "choose subpart with one edge connceted."
    dp[n - 1][1] += 1
    return dp[n - 1]

# Find the root and start dfs.
if n == 1:
    print 2
else:
    dfs(1, k) # start dfs from node 1
    print res + 1 # A empty set {} is subtree of given tree as well.
