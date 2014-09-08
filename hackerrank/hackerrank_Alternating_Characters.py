"""hackerrank_Alternating_Characters

https://www.hackerrank.com/contests/w10/challenges/alternating-characters
"""

def main():
    for _ in xrange(int(raw_input())):
        s = raw_input()
        prev = s[0]

        deletion = 0
        for c in s[1:]:
            if c == prev:
                deletion += 1
            else:
                prev = c
        print deletion


if __name__ == '__main__':
    main()
