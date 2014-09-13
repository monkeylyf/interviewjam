"""hackerrank_Roys_Rectangle.py

https://www.hackerrank.com/contests/csindia/challenges/roys-rectangle
"""


def main():
    for _ in xrange(int(raw_input())):
        (x, y, x1, y1, x2, y2) = map(int, raw_input().split())
        print min(abs(x1 - x), abs(x2 - x), abs(y1 - y), abs(y2 - y))


if __name__ == '__main__':
    main()
