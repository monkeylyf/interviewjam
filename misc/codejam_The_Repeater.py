"""codejam_The_Repeater

https://code.google.com/codejam/contest/2994486/dashboard#s=p0
"""

def solve(t, string):
    op = 0

    idx = []
    while any(string):
        for s in string:
            if s:
                char = s[0]
                break 
        for i, s in enumerate(string):
            if not s or s[0] != char:
                print 'Case #{0}: Fegla Won'.format(t)
                return
            else:
                last_idx = find_last_idx(0, s, char)
                idx.append(last_idx)
                string[i] = s[last_idx + 1 : ]

        idx = sorted(idx)
        #print idx
        median = idx[len(idx) / 2]
        for i in idx:
            op += abs(i - median)

        idx = []

    print 'Case #{0}: {1}'.format(t, op)


def find_last_idx(i, s, char):
    while i + 1 < len(s) and s[i + 1] == char:
        i += 1

    return i


def main():
    T = int(raw_input())

    for t in xrange(1, T + 1):
        n = int(raw_input())
        string = []
        for _ in xrange(n):
            string.append(raw_input())

        solve(t, string)


if __name__ == '__main__':
    main()
