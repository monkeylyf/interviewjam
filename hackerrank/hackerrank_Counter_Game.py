"""hackerrank_Counter_Game.py

https://www.hackerrank.com/contests/w8/challenges/counter-game
"""

def solve(n):
    count = 0

    while n != 1:
        s = bin(n)[2:]
        n = int(s[:-1], 2) if s.count('0') == len(s) - 1 else int(s[1:], 2)
        count += 1

    print 'Richard' if count % 2 == 0 else 'Louise'


def main():
    t = int(raw_input())
    for _ in xrange(t):
        solve(int(raw_input()))


if __name__ == '__main__':
    main()
