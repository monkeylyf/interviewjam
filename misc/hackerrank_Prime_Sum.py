"""hackerrank_Prime_Sum

https://www.hackerrank.com/contests/w3/challenges/prime-sum

1 <= T <= 5000 
1 <= N <= 10 ** 12 
1 <= K <= 10 ** 12
"""

import math


def is_prime_sum(N, K):
    """Goldbach's conjecture."""
    if N < 0:
        return False
    elif K == 1:
        return is_prime(N)
    elif K == 2:
        if N % 2 == 0 and N > 4:
            return True
        if is_prime(N - 2):
            return True
    elif N % 2 == 1:
        # Does not work for 7, 2
        return is_prime_sum(N - 3, K - 1)
    else:
        if K % 2 == 1:
            return is_prime_sum(N - 2, K - 1)
        else:
            return N >= K * 2 


def is_prime(n):
    if n <= 1:
        return False
    if n == 2:
        return True
    root = int(math.sqrt(n))
    for i in xrange(2, root + 1):
        if n % i == 0:
            return False

    return True


def main():
    T = int(raw_input()) 
    for _ in xrange(T):
        (N, K) = map(int, raw_input().split())
        print N, K
        if is_prime_sum(N, K):
            print 'Yes'
        else:
            print 'No'


def all_prime(uplimit):
    """First thing off the top of my head is have all prime upto limit then dp.
    After noting that the uplimit is 10 ** 12, simply generating all prime number
    will take forever.
    Not the right direction.
    """
    primes = [2]
    num = 3
    while num <= uplimit:
        if num % 1000000 == 0:
            print num
        root = int(math.sqrt(num))
        is_prime = True
        for i in primes:
            if num % i == 0:
                is_prime = False
                break
            elif i > root:
                break
        if is_prime:
            primes.append(num)
        
        num += 1

    return primes


if __name__ == '__main__':
    main()
