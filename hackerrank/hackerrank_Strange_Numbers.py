"""hackerrank_Strange_Numbers.py

https://www.hackerrank.com/contests/w11/challenges/strange-numbers
"""


def strange_num_generator(n, batch=None):
    """The idea is construct all strange numbers instead of iterating through
    every the numbers from 1 to 10 ** 18 to check.

    Base on the definition of strange numbers, numbers with length n - 1, multiplied
    by n, if the results are of length n, then they are strange numbers as well.
    For those new strange numbers with length n, multiplied by n, if the results are
    still of length n, then they are strange numbers as well. Looping until you see
    results with length n + 1.

    :param n:int, the number of digits of a number, which represents a range.
    :param batch;list, all the strange numbers with n - 1 length.

    :return numbers:list, all the strange numbers with n length.
    """
    if n == 1:
        return range(10)

    if not batch:
        return []

    numbers = []
    threshold = 10 ** (n - 1) / n
    batch = filter(lambda x : x >= threshold, batch)

    uplimit = 10 ** n

    while 1:
        batch = map(lambda x : x * n, batch)
        if batch[-1] > uplimit:
            numbers += filter(lambda x : x < uplimit, batch)
            break
        else:
            numbers += batch

    return numbers


def main():
    """Pre-compute all strange numbers and hard-code them in the script will work
    as well but it's not elegent.
    """
    strange_number_pool = []
    for i in xrange(1, 18 + 1):
        # length of the numnber is in [1, 18]
        pool = strange_num_generator(i, batch=strange_number_pool)
        strange_number_pool += pool

    for _ in xrange(int(raw_input())):
        l, r = map(int, raw_input().split())
        count = 0
        for i in strange_number_pool:
            if l <= i and i <= r:
                count += 1
        print count


if __name__ == '__main__':
    main()
