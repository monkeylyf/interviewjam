"""hackerrank_Play_Game

https://www.hackerrank.com/contests/101apr14/challenges/play-game
"""

def solve(N, arr):
    """DP solution.
    
    :param arr: int array. Reversed.
    :param N: int. Length of arr.

    dp[i] reprensents max you can take given arr[:i + 1]
    """
    dp = [ 0 ] * N
    acc = [ 0 ] * N

    # Setup accumulatives.
    for i in xrange(N):
        acc[i] = arr[i] if i == 0 else acc[i - 1] + arr[i]
    print acc

    # Init dp
    for i in xrange(min(3, N)):
        dp[i] = acc[i]

    for i in xrange(3, N):
        for j in xrange(1, 4):
            # acc[i] is sum and dp[i - j] where j in (1, 2, 3)
            # that your friend will take optimally. The diff is
            # The max you can take when your friend play optimally.
            # Bascially you are playing against yourself.
            dp[i] = max(dp[i], acc[i] - dp[i - j])

    print dp[-1]


def main():
    T = int(raw_input())
    for _ in xrange(T):
        N = int(raw_input())
        arr = list(reversed(map(int, raw_input().split())))
        solve(N, arr)



if __name__ == '__main__':
    main()
