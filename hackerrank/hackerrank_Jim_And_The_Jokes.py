"""hackerrank_Jim_And_The_Jokes.py

https://www.hackerrank.com/contests/101hack18/challenges/jim-and-the-jokes
"""

def main():
    n = int(raw_input())
    mapping = {}
    for _ in xrange(n):
        (m, d) = map(int, raw_input().split())
        if d / 10 >= m or d % 10 >= m:
            continue

        decimal = d / 10 * m + d % 10
        try:
            mapping[decimal] += 1
        except KeyError:
            mapping[decimal] = 1

    count = 0

    for v in mapping.itervalues():
        count += v * (v - 1) / 2

    print count


if __name__ == '__main__':
    main()
