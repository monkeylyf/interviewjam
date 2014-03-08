#hackerrank_Sherlock_and_Pairs.py
#https://www.hackerrank.com/contests/101feb14/challenges/sherlock-and-pairs
#



N = int(raw_input())

for i in xrange(N):
    K = int(raw_input())
    arr = sorted(map(int, raw_input().split()))

    idx = 0
    total = 0
    while idx < K:
        cur_idx = idx
        while idx < K - 1 and arr[idx] == arr[idx + 1]:
            idx += 1
        total += (idx - cur_idx + 1) * (idx - cur_idx)
        idx += 1
    print total
