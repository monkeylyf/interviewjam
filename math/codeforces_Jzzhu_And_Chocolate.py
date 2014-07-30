"""codeforces_Jzzhu_And_Chocolate.py

http://codeforces.com/problemset/problem/449/A
"""

def solve(n, m, k):
    """n >= m.

    Cut as evenly as possible.
    """
    if k > n - 1 + m - 1:
        # Impossible.
        res = -1
    elif k < m:
        # max(all cut in n evenly, all cut in m evenly)
        res = max(n / (k + 1) * m, m / (k + 1) * n)
    elif k < n:
        # max(all cut in n evenly, cut n with max cut then cut m)
        res = max(n / (k + 1) * m, m / (k - (n - 1) + 1))
    else:
        # max(cut m with max cut then cut n, cut n with max cut then cut m)
        res = max(n / (k - (m - 1) + 1), m / (k - (n - 1) + 1))

    print res


def main():
    t = int(raw_input())
    for _ in xrange(t):
        (n, m, k) = map(int, raw_input().split())
        solve(max(n, m), min(n, m), k)


if __name__ == '__main__':
    main()
