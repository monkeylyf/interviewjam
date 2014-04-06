"""hackerrank_Filling_Jars

https://www.hackerrank.com/challenges/filling-jars
"""



def main():
    (N, M) = map(int, raw_input().split())
    s = 0
    for _ in xrange(M):
        (a, b, k) = map(int, raw_input().split())
        s += (b - a + 1) * k
    print s / N

if __name__ == '__main__':
    main()
