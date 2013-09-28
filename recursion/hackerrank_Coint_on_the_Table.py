# https://www.hackerrank.com/challenges/coin-on-the-table

import sys



rl = sys.stdin.readline


N, M, K = map(int, rl().strip().split())
board = [ rl().strip() for _ in range(N) ]


x = -1
y = -1

# Find destination *.
for i in xrange(N):
    for j in xrange(M):
        if board[i][j] == '*':
            x, y = i , j
            break

# Init dp states.
# For any board, you can make the coin be any spot at time t with t operations
# So set the limit ops to K + 1.
dp = [ [ K + 1 for _ in range(M) ] for _ in range(N) ]

def dfs(i, j, cur_t, ops):
    if i < 0 or j < 0 or i >= N or j >= M or cur_t > K or dp[i][j] <= ops:
        # Return eather out of boundary or take more steps than required
        # or  exceed max ops.
        return

    dp[i][j] = min(dp[i][j], ops)

    dfs(i - 1, j, cur_t + 1, ops if board[i][j] == 'U' else ops + 1)
    dfs(i, j - 1, cur_t + 1, ops if board[i][j] == 'L' else ops + 1)
    dfs(i + 1, j, cur_t + 1, ops if board[i][j] == 'D' else ops + 1)
    dfs(i, j + 1, cur_t + 1, ops if board[i][j] == 'R' else ops + 1)



dfs(0, 0, 0, 0)

if dp[x][y] == K + 1:
    print -1
else:
    print dp[x][y]
