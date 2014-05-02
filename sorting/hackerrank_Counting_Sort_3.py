"""hackerrank_Counting_Sort_3

https://www.hackerrank.com/challenges/countingsort3
"""

from collections import defaultdict


def main():
    T = int(raw_input())
    d = defaultdict(int)

    for _ in xrange(T):
        i = int(raw_input().split()[0])
        d[i] += 1

    acc = 0
    for i in xrange(100):
        acc += d[i]
        print acc,
    print '' 

if __name__ == '__main__':
    main()
