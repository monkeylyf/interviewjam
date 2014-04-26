"""hackerrank_Gem_Stones

https://www.hackerrank.com/contests/101apr14/challenges/gem-stones
"""

def main():
    T = int(raw_input())
    base = set(raw_input())
    for i in xrange(1, T):
        stone = raw_input()
        stone = set(stone)
        base = base & stone
    print len(base)

if __name__ == '__main__':
    main()
