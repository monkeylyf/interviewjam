"""hackerrank_Two_String.py

https://www.hackerrank.com/contests/101hack19/challenges/two-strings
"""


def main():
    t = int(raw_input())
    for _ in xrange(t):
        a = raw_input()
        b = raw_input()
        print 'YES' if set(a) & set(b) else 'NO'


if  __name__ == '__main__':
    main()
