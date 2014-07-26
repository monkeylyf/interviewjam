"""hackerrank_Bus_Station.py

https://www.hackerrank.com/contests/101jul14/challenges/bus-station
"""

def factors(n):
    """Fast way to generate all factors of given integer n.

    It is faster than:

    for i in xrange(1, n + 1):
        if n % i == 0:
            yield i
    """
    return set(reduce(list.__add__,
            ([i, n / i] for i in range(1, int(n ** 0.5) + 1) if not n % i)))


def solve(N, men):
    acc = set()
    prev = 0
    for i in men:
        prev += i
        acc.add(prev)

    total = prev
    res = []

    for i in factors(total):
        for factor in xrange(1, total / i + 1):
            if (factor * i) not in acc:
                break
        else:
            res.append(i)

    print ' '.join(map(str, sorted(res)))


def main():
    N = int(raw_input())
    men = map(int, raw_input().split())
    solve(N, men)


if __name__ == '__main__':
    main()
