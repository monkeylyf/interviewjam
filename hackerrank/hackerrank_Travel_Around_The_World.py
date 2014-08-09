"""hackerrank_Travel_Around_The_World.py

https://www.hackerrank.com/contests/w2/challenges/travel-around-the-world
"""


def solve(n, c, gas, cost):
    """"""
    # dp[n] represents minimum gas you need to travel to (n + 1) % n given
    # dp[(n + 1) % n], which is the minimum gas you need to travel to (n + 2) % n
    dp = [ 0 ] * n

    # First iter is init. Second is complete the circle.
    for _ in range(2):
        for i in reversed(range(n)):
            next_i = (i + 1) % n
            # Minimum gas you need if you want to continue to travel given next dp status
            # without considering tank capacity.
            dp[i] = max(0, dp[next_i] + cost[i] - gas[i])
            # Sanity check with considering tank capacity if this city is a valid starting
            # point.
            if min(dp[i] + gas[i], c) < cost[i] + dp[next_i]:
                return 0

    return dp.count(0)


def main():
    (n, c) = map(int, raw_input().split())
    gas  = map(int, raw_input().split())
    cost = map(int, raw_input().split())
    print(solve(n, c, gas, cost))


if __name__ == '__main__':
    main()
