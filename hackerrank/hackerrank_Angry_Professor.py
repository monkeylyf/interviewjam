"""hackerrank_Angry_Professor.py

https://www.hackerrank.com/contests/101hack21/challenges/angry-professor
"""


def main():
    t = int(raw_input())
    for _ in xrange(t):
        n, k = map(int, raw_input().split())

        arr = map(int, raw_input().split())
        for i in arr:
            if i <= 0:
                k -= 1
            if k == 0:
                print 'NO'
                break
        else:
            print 'YES'


if __name__ == '__main__':
    main()
