"""hackerrank_The_Love_Letter_Mystery.py

https://www.hackerrank.com/contests/w3/challenges/the-love-letter-mystery
"""


def solve(s):
    head = 0
    tail = len(s) - 1
    
    ops = 0
    while head < tail:
        ops += abs(ord(s[head]) - ord(s[tail]))
        head += 1
        tail -= 1
    print ops




def main():
    T = int(raw_input()) 
    for _ in xrange(T):
        s = raw_input()
        solve(s)


if __name__ == '__main__':
    main()
