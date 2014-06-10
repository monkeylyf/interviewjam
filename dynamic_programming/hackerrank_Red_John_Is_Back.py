"""hackerrank_Red_John_Is_Back.py

https://www.hackerrank.com/challenges/red-john-is-back
"""

import math


def solve(N):
    dp = [ 0 ] * (N + 1)

    for i in xrange(N + 1):
        if i < 4:
            dp[i] = 1
        else:
            dp[i] = dp[i - 4] + dp[i - 1]

    return dp[-1]

def get_prime():
    MAX_VAL = 300000
    count = [ 0 ] * (MAX_VAL + 1)
    for i in xrange(1, MAX_VAL + 1):
        if is_prime(i):
            count[i] = count[i - 1] + 1
        else:
            count[i] = count[i - 1]

    return count

def is_prime(n):
    if n <= 1:
        return False
    if n == 2:
        return True
    root = int(math.sqrt(n))
    for i in xrange(2, root + 1):
        if n % i == 0:
            return False

    return True


def main():
    count = get_prime()
    T = int(raw_input())
    for _ in xrange(T):
        N = int(raw_input())
        num = solve(N)
        print count[num]


if __name__ == '__main__':
    main()
