"""hackerrank_Manasa_And_Stones

https://www.hackerrank.com/contests/w2/challenges/manasa-and-stones
"""




def solve(n, a, b):
    s = set([0])
    for _ in xrange(n - 1):
        ss = set()

        for e in s:
            ss.add(e + a)
            ss.add(e + b)

        s = ss
    print ' '.join(map(str, sorted(list(s))))



def main():
    T = int(raw_input())

    for _ in xrange(T):
        n = int(raw_input())
        a = int(raw_input())
        b = int(raw_input())
        solve(n, a, b)



if __name__ == '__main__':
    main()
