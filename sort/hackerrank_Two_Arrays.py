"""hackerrank_Two_Arrays

https://www.hackerrank.com/challenges/two-arrays
"""



def main():
    T = int(raw_input()) 

    for _ in xrange(T):
        (N, K) = map(int, raw_input().split())
        a = sorted(map(int, raw_input().split()))
        b = sorted(map(int, raw_input().split()), reverse=True)

        yes = True
        for i in xrange(N):
            if a[i] + b[i] < K:
                yes = False
                break
        print 'YES' if yes else 'NO'


if __name__ == '__main__':
    main()
