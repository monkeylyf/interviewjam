"""hackerrank_Special_numbers

https://www.hackerrank.com/contests/addepar/challenges/special-numbers
"""

def precompute():
    N = 100000
    s = set()
    container = []

    for i in xrange(1, N + 1):
        num = 0
        for j in xrange(1, i + 1):
            if i % j == 0:
                #print j,
                num += 1
        if not num in s:
            s.add(num)
            print i
            container.append(i)
    print container


def solve(N):
    nums = [1, 2, 4, 6, 12, 16, 24, 36, 48, 60, 64, 120, 144, 180, 192, 240, 360, 576, 720, 840, 900, 960, 1024, 1260, 1296, 1680, 2520, 2880, 3072, 3600, 4096, 5040, 5184, 6300, 6480, 6720, 7560, 9216, 10080, 12288, 14400, 15120, 15360, 20160, 25200, 25920, 27720, 32400, 36864, 44100, 45360, 46080, 46656, 50400, 55440, 60480, 61440, 65536, 82944, 83160]

    s = 0
    for val in nums:
        if val <= N:
            s += val

    return s

def main():
    N = int(raw_input())
    print solve(N)
    #precompute()


if __name__ == '__main__':
    main()
