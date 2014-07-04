"""hackerrank_ACM_ICPC_Team

https://www.hackerrank.com/contests/w6/challenges/acm-icpc-team
"""


def main():
    (N, M) = map(int, raw_input().split())
    arr = [int(raw_input(), 2) for _ in xrange(N)]
    local_max = 0
    num = 0

    for i in xrange(N - 1):
        for j in xrange(i + 1, N):
            res = arr[i] | arr[j]
            count = "{0:b}".format(res).count('1')
            if count > local_max:
                local_max = count
                num = 1
            elif count == local_max:
                num += 1
            else:
                continue

    print local_max
    print num

if __name__ == '__main__':
    main()
