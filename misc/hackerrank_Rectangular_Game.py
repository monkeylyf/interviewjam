"""Rectanglar_Game

https://www.hackerrank.com/contests/101mar14/challenges/rectangular-game
"""



def main():
    N = int(raw_input())
    row = []
    col = []
    for _ in xrange(N):
        (x, y) = map(int, raw_input().split())
        row.append(x)
        col.append(y)
    print min(row) * min(col)


if __name__ == '__main__':
    main()
