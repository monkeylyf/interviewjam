"""hackerrank_Marble_Cut.py

https://www.hackerrank.com/contests/101hack22/challenges/marble-cut
"""


def main():
    """Fuck this one.

    Checking the mods of both l and b is the right direction but there is
    special case when mods are both equal to 2.

    2 x 2 will be left with 2 x 2, but 5 x 5 will be left with 1 x 1.
    - - - | |
    - - - | |
    | | H | |
    | | - - -
    | | - - -
    """
    t = int(raw_input())
    for i in xrange(t):
        l, b = map(int, raw_input().split())
        l_mod = l % 3
        b_mod = b % 3
        if l_mod == 0 or b_mod == 0:
            print 'YES'
        elif l_mod == 2 and b_mod == 2 and (l == 2 or b == 2):
            print 'NO 4'
        else:
            print 'NO {}'.format(l_mod * b_mod % 3)


if __name__ == '__main__':
    main()
