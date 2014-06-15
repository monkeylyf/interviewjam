"""hackerrank_Anagram

https://www.hackerrank.com/challenges/anagram
"""

from collections import Counter


def solve(s):
    length = len(s)
    if length % 2 == 1:
        return -1

    a = Counter(s[: length / 2])
    b = Counter(s[length / 2 :])

    for key, value in a.iteritems():
        try:
            a[key] = value - b[key] if value >= b[key] else 0
        except KeyError:
            pass

    return sum(a.values())


def main():
    T = int(raw_input())
    for _ in xrange(T):
        s = raw_input()
        print solve(s)


if __name__ == '__main__':
    main()
