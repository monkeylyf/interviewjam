"""hackerrank_euler001

https://www.hackerrank.com/contests/projecteuler/challenges/euler001
"""

def main():
    T = int(raw_input())
    calc = lambda n, k : (k + (n - 1) / k * k) * ((n - 1) / k) / 2
    for _ in xrange(T):
        N = int(raw_input())
        print calc(N, 3) + calc(N, 5) - calc(N, 15)

if __name__ == '__main__':
    main()
