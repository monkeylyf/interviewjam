"""hackerrank_Grid_Challenge

https://www.hackerrank.com/contests/101hack18/challenges/grid-challenge.
"""

def main():
    """Swap is a hoax. You can rearange the string as you want.

    So the only thing needs to be done is to compare the current
    string to previous one and make sure it's strickly alphabetically
    no less than the previous one.
    """
    t = int(raw_input())
    for i in xrange(t):
        n = int(raw_input())
        prev = sorted(list(raw_input()))
        res = True
        for j in xrange(n - 1):
            s = raw_input()
            if not res:
                continue
            s = sorted(list(s))
            if not all((prev[i] <= s[i] for i in xrange(len(s)))):
                res = False
            prev = s
        print 'YES' if res else 'NO'


if __name__ == '__main__':
    main()
