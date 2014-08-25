"""hackerrank_Sansa_And_Xor.py

https://www.hackerrank.com/contests/w9/challenges/sansa-and-xor
"""

def solve(arr, n):
    """ 1 2 3 4 5
    1
    1 2
    1 2 3
    1 2 3 4
    1 2 3 4 5
      2
      2 3
      2 3 4
      2 3 4 5
        3
        3 4
        3 4 5
          4
          4 5
            5

    The # of appearance of the ith element of arr, arr[i], equals to:
    (len(arr) - i) * (i + 1)

    For XOR operation, xor the same number by even number of times will yield 0.
    So count for odd.

    """
    acc = 0

    for i, val in enumerate(arr):
        if (i + 1) % 2 == 1 and  (n - i) % 2 == 1:
            acc ^= val

    return acc


def main():
    t = int(raw_input())
    for _ in xrange(t):
        n = int(raw_input())
        arr = map(int, raw_input().split())
        print solve(arr, n)


if __name__ == '__main__':
    main()
