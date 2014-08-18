"""hackerrank_Volleyball_Match

https://www.hackerrank.com/contests/w1/challenges/volleyball-match
"""

def combination(n, k):
    ret = 1
    mod = 10 ** 9 + 7

    for i in xrange(k):
        ret = ret * (n - i) / (i + 1)

    return ret % mod


def solve(a, b):
    if b < 25:
        return 0
    elif b == 25:
        if a >= 24:
            return 0
        else:
            return combination(24 + a, a)
    elif b - a != 2:
        return 0
    else:
        mod = 10 ** 9 + 7
        # Need to tie at 24:24 and tie for next y - 26 rounds.
        return (combination(24 + 24, 24) * pow(2, a - 24, mod) % mod)


def main():
    a = int(raw_input())
    b = int(raw_input())

    (a, b) = (min(a, b), max(a, b))
    print solve(a, b)


if __name__ == '__main__':
    main()
