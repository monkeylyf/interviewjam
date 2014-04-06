"""hackerrank_Angry_Children

https://www.hackerrank.com/challenges/angry-children
"""


def solve(N, K, candies):
    candies = sorted(candies)
    local_min = candies[-1]
    for i in xrange(N - K + 1):
        local_min = min(local_min, candies[i + K - 1] - candies[i])

    return local_min



def main():
    N = int(raw_input())
    K = int(raw_input())
    candies = [ 0 ] * N
    for i in xrange(N):
        candies[i] = int(raw_input())
    if K == 1:
        print 0
    else:
        print solve(N, K, candies)


if __name__ == '__main__':
    main()
