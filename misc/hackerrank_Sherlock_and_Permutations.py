"""hackerrank_Sherlock_and_Permutations

https://www.hackerrank.com/contests/infinitum-may14/challenges/sherlock-and-permutations
"""


def solve(N, M):
    MOD = 10 ** 9 + 7

    (numerator, denominator) = (1, 1)

    k = N

    while k > 0:
        numerator = numerator * M
        denominator = denominator * k
        k -=1
        M -=1

    return numerator / denominator % MOD


def main():
    cache = {}
    T = int(raw_input())
    for _ in xrange(T):
        (N, M) = map(int, raw_input().split())
        key = '{0}:{1}'.format(min(N, M - 1), M - 1 + N)
        if key not in cache:
            cache[key] = solve(N, M - 1 + N)
        print cache[key]


if __name__ == '__main__':
    main()
