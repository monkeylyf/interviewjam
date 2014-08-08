"""hackerrank_Girlfriend_and_Necklace.py

https://www.hackerrank.com/contests/w8/challenges/gneck
"""

def is_good_necklace(s, l):
    """
    """
    for i in xrange(len(s) - l + 1):
        subseq = s[i:i + l]
        if subseq.count('R') < subseq.count('B'):
            return False
    return True


def perm(n):
    def rec(acc, container):
        if len(acc) == n:
            container.append(''.join(acc))
        else:
            rec(acc + ['R'], container)
            rec(acc + ['B'], container)

    container = []
    rec([], container)

    return container


def matrix_multiply(a, b):
    def multiply(i, j, h, k, l, m):
        return ((i * k) % mod + (j * l) % mod + (h * m) % mod) % mod

    mod = 10 ** 9 + 7
    ((i, j, k), (x, y, z), (l, m, n)) = a
    ((d, e, f), (u, v, w), (o, p, q)) = b

    return ((multiply(i, j, k, d, u, o), multiply(i, j, k, e, v, p), multiply(i, j, k, f, w, q)),
            (multiply(x, y, z, d, u, o), multiply(x, y, z, e, v, p), multiply(x, y, z, f, w, q)),
            (multiply(l, m, n, d, u, o), multiply(l, m, n, e, v, p), multiply(l, m, n, f, w, q)))


def matrix_pow(matrix, n):
    """"""
    ret  = ((1, 0, 0), (0, 1, 0), (0, 0, 1))

    while n:
        if n % 2 == 1:
            ret = matrix_multiply(ret, matrix)
        matrix = matrix_multiply(matrix, matrix)
        n /= 2

    return ret


def solve(n):
    """Variable of fibb.

    An = An-1 + An-3.
    A3n+3   2 1 1 ^ n  A3
    A3n+2 = 1 1 1      A2
    A3n+1   1 0 1      A1
    """
    if n == 2:
        return 3
    if n == 3:
        return 4

    mod = 10 ** 9 + 7
    ((i, j, k), (x, y, z), (d, e, f)) = matrix_pow(((2, 1, 1), (1, 1, 1), (1, 0, 1)), (n + 2) / 3 - 1)
    (a3, a2, a1) = (2, 3, 4)

    if n % 3 == 0:
        return (i * a1 + j * a2 + k * a3) % mod
    elif n % 3 == 2:
        return (x * a1 + y * a2 + z * a3) % mod
    else:
        return (d * a1 + e * a2 + f * a3) % mod


def main():
    t = int(raw_input())
    for _ in xrange(t):
        n = int(raw_input())
        print solve(n)


if __name__ == '__main__':
    main()
