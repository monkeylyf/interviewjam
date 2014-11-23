"""codeforces_Inna_And_Nine.

http://codeforces.com/contest/374/problem/B
"""
def solve(n):
    """The idea is to find the pattern like: a, 9 - a, a, 9 - a...

    If the pattner has even length, say 4. In order to get as many as nines
    there is only one way to sum them to 9, which does not matter.
    If the length is odd, then we have multiple way to sum the nines meanwhiling
    guaranteeing as many as nines. for example, 1, 8, 1, 8, 1. You want get 2 pairs
    of nine, and that means you can get rid of one 1. There are three 1s in it. Thus
    there are 3 ways to transform the sequence with as many as nines possible.
    """
    pattern_length = 1
    prev = n[0]
    total = 0

    for i, digit in enumerate(n[1:]):
        if int(digit) + int(prev) == 9:
            pattern_length += 1
        elif pattern_length != 1 and pattern_length % 2 == 1:
            # End of the pattern, Sum it up.
            total += (pattern_length + 1) / 2
            pattern_length = 1
        else:
            pattern_length = 1

        prev = digit

    if pattern_length % 2 == 1:
        total += (pattern_length + 1) / 2

    return 1 if total == 0 else total


def main():
    for _ in xrange(int(raw_input())):
        n = raw_input()
        print solve(n)


if __name__ == '__main__':
    main()
