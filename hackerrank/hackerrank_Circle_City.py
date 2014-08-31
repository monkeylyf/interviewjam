"""hackerrank_Circle_City.py

https://www.hackerrank.com/contests/101aug14/challenges/circle-city
"""


def main():
    """Brutal force."""
    for _ in xrange(int(raw_input())):
        (r, k) = map(int, raw_input().split())
        count = 0
        for x in xrange(int(r ** 0.5) + 1):
            y = int((r - x ** 2) ** 0.5)
            if x > y:
                break
            if x ** 2 + y ** 2 == r:
                count += 8 if x > 0 and x != y else 4

        print 'possible' if k >= count else 'impossible'


if __name__ == '__main__':
    main()
