"""hackerrank_Cavity_Map.py

https://www.hackerrank.com/contests/101jul14/challenges/cavity-map
"""


def solve(matrix, N):
    """"""
    for i in xrange(1, N - 1):
        for j in xrange(1, N - 1):
            if abs(matrix[i][j]) > abs(matrix[i - 1][j]) and \
               abs(matrix[i][j]) > abs(matrix[i][j - 1]) and \
               abs(matrix[i][j]) > abs(matrix[i + 1][j]) and \
               abs(matrix[i][j]) > abs(matrix[i][j + 1]):
               matrix[i][j] = -matrix[i][j]

    for i in xrange(N):
        print ''.join(map(lambda x: 'X' if x < 0 else str(x) , matrix[i]))


def main():
    N = int(raw_input())
    matrix = [map(int, list(raw_input())) for _ in xrange(N)]
    solve(matrix, N)


if __name__ == '__main__':
    main()
