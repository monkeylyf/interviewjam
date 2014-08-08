"""hackerrank_Red_John_Is_Back.py

https://www.hackerrank.com/challenges/red-john-is-back
"""


def solve(n):
    dp = [0] * (n + 1)

    for i in xrange(n + 1):
        dp[i] = 1 if i < 4 else dp[i - 4] + dp[i - 1]

    return dp[-1]

def get_prime():
    MAX_VAL = 300000
    count = [ 0 ] * (MAX_VAL + 1)
    for i in xrange(1, MAX_VAL + 1):
        if is_prime(i):
            count[i] = count[i - 1] + 1
        else:
            count[i] = count[i - 1]

    return count

def is_prime(n):
    if n <= 1:
        return False
    if n == 2:
        return True
    root = int(n ** 0.5)
    for i in xrange(2, root + 1):
        if n % i == 0:
            return False

    return True


def main():
    count = get_prime()
    t = int(raw_input())
    for _ in xrange(t):
        N = int(raw_input())
        num = solve(N)
        print count[num]


if __name__ == '__main__':
    main()
