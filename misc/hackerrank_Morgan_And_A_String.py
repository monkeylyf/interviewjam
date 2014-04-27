""" hackerrank_Morgan_And_A_String

https://www.hackerrank.com/contests/101apr14/challenges/morgan-and-a-string
"""


def solve(a, b):
    # Padding for case
    # "B" "BA"
    # Without padding, it will give BBA because "B" < "BA"
    # "Bz" > "BAZ" w/ padding, "B" is chosen when continue with "Bz" and "Az"
     
    a += 'z'
    b += 'z'

    i = j = 0

    ret = []
    while i < len(a) and j < len(b):
        if a[i:] < b[j:]:
            ret.append(a[i]) 
            i += 1
        else:
            ret.append(b[j])
            j += 1

    ret = ret[:-1]

    if i < len(a):
        ret += a[i : -1]
    if j < len(b):
        ret += b[j : -1]
    print ''.join(ret)


def main():
    T = int(raw_input())
    for _ in xrange(T):
        a = raw_input()
        b = raw_input()
        solve(a, b)


if __name__ == '__main__':
    main()
