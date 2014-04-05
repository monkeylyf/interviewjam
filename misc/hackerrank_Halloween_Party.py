"""hackerrank_Halloween_Party

https://www.hackerrank.com/challenges/halloween-party
"""



def solve(n):
    print (n / 2) * (n - n / 2)


def main():
    T = int(raw_input())
    for _ in xrange(T):
        solve(int(raw_input()))


if __name__ == '__main__':
    main()
