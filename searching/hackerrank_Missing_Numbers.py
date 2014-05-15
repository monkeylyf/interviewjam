"""hackerrank_Missing_Numbers

https://www.hackerrank.com/challenges/missing-numbers
"""

from collections import Counter

def solve(a, b):
    for key in sorted(a.keys()):
        if key not in b or a[key] > b[key]:
            print key,

    print ''

def main():
    x = int(raw_input())
    a = map(int, raw_input().split())

    y = int(raw_input())
    b = map(int, raw_input().split())

    # Make sure len(a) >= len(b)
    (a, b) = (b, a) if x < y else (a, b)
    solve(Counter(a), Counter(b))

if __name__ == '__main__':
    main()
