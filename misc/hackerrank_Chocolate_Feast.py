"""hackerrank_Chocolate_Feast

https://www.hackerrank.com/challenges/chocolate-feast
"""


def solve(N, C, M):
    wrapper = N / C
    eaten = wrapper

    while wrapper >= M:
        exchanged = wrapper / M
        wrapper = wrapper % M + exchanged
        eaten += exchanged
    return eaten


def main():
    T = int(raw_input())
    for _ in xrange(T):
        (N, C, M) = map(int, raw_input().split())
        print solve(N, C, M)


if __name__ == '__main__':
    main()
