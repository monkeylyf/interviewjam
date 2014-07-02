""" hackerrank_Consecutive_Subsequences

https://www.hackerrank.com/contests/w6/challenges/consecutive-subsequences
"""

from collections import Counter

def solve(arr, n, k):
    acc = [ None ] * n
    for i, val in enumerate(arr):
        acc[i] = val  % k if i == 0 else (acc[i - 1] + val) % k

    res = 0

    count = Counter(acc)
    for  i in count.values():
        if i <= 1:
            continue
        res += 1 if i == 2 else i * (i - 1) / 2 # C(x 2) combination,
    res += count.get(0, 0) # 0 itself is a consecutive subseq from index 0.
    print res


def main():
    T = int(raw_input())
    for _ in xrange(T):
        (n, k) = map(int, raw_input().split())
        arr = map(int, raw_input().split())
        solve(arr, n, k)


if __name__ == '__main__':
    main()
