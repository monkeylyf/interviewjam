"""hackerrank_Flipping_Bits

https://www.hackerrank.com/contests/101hack20/challenges/flipping-bits
"""

def main():
    max_val = 2 ** 32
    for _ in xrange(int(raw_input())):
        b = int(raw_input())
        print max_val - b - 1


if __name__ == '__main__':
    main()
