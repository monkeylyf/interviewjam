"""hackerrank_Sherlock_and_Anagrams.py

https://www.hackerrank.com/contests/w13/challenges/sherlock-and-anagrams
"""

from collections import Counter, defaultdict


def solve(s):
    n = len(s)

    pick_two = lambda x: x * (x - 1) / 2

    total = 0

    for i in xrange(1, n):
        seen = defaultdict(int)
        for j in xrange(n - i + 1):
            c = Counter(s[j:j+i])

            key = []
            for k in sorted(c.viewkeys()):
                key.append(k)
                key.append(str(c[k]))
            key = ''.join(key)
            seen[key] += 1

        for val in seen.viewvalues():
            total += pick_two(val)

    return total


def main():
    t = int(raw_input())

    for _ in xrange(t):
        print solve(raw_input())


if __name__ == '__main__':
    main()
