"""hackerrank_Even_Odd_Query

https://www.hackerrank.com/contests/w5/challenges/even-odd-query
"""

def solve(x, y, arr):
    """ arr contains [0, 9] and usualy the even/odd is decided by the base.

    The only exception is if there is a trailing zero right after the base.

    pow(n, 0) give 1 no matther what n is.
    """
    if x != y and x < len(arr) - 1 and arr[x + 1] == 0:
        return 1
    else:
        return arr[x]


def main():
    N = int(raw_input())
    arr = map(int, raw_input().split())
    Q = int(raw_input())

    for _ in xrange(Q):
        (x, y) = map(int, raw_input().split())
        out = 'Even' if solve(x - 1, y - 1, arr) % 2 == 0 else 'Odd'
        print out


if __name__ == '__main__':
    main()
