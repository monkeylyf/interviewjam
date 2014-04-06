"""hackerrank_Is_Fibo

https://www.hackerrank.com/challenges/is-fibo
"""


def fibo(n):
    fibonacci = set()
    if n == 1 or n == 2:
        return 1
    c0 = c1 = 1
    fibonacci.add(c0)

    for _ in xrange(n):
        c1 += c0
        c0 = c1 - c0
        fibonacci.add(c1)

    return fibonacci


def main():
    T = int(raw_input())
    container = fibo(50)

    for _ in xrange(T):
        if int(raw_input()) in container:
            print 'IsFibo'
        else:
            print 'IsNotFibo'



if __name__ == '__main__':
    main()
