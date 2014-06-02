"""hackerrank_Sherlock_and_Array

https://www.hackerrank.com/contests/101may14/challenges/sherlock-and-array
"""

def solve(arr, N):
    acc = 0
    forward = [ 0 ] * N

    for i, val in enumerate(arr):
        acc += val
        forward[i] = acc

    backward = [ 0 ] * N

    acc = 0
    for i in reversed(xrange(N)):
        acc += arr[i]
        backward[i] = acc

    for i in xrange(N):
        if forward[i] == backward[i]:
            return 'YES'

    return 'NO'

def main():
    T = int(raw_input())

    for _ in xrange(T):
        N = int(raw_input())
        arr = map(int, raw_input().split())

        print solve(arr, N)


if __name__ == '__main__':
    main()
