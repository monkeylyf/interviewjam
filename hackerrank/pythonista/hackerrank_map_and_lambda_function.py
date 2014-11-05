"""hackerrank_map_and_lambda_function.py

https://www.hackerrank.com/contests/pythonista-practice-session/challenges/map-and-lambda-expression
"""

def fibb(n):
    if n == 0:
        return 0
    if n in (1, 2):
        return 1

    return fibb(n - 1) + fibb(n - 2)


def main():
    n = int(raw_input())
    print map(lambda x : x ** 3, map(fibb, xrange(n)))


if __name__ == '__main__':
    main()
