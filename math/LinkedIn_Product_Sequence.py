"""LinkedIn_Product_Sequence.py
LinkedIn

Given a positive number A, output all possible sequence with product equal to
A. No duplicates and all factors should be no-descending order.
"""

def solve(n):
    """Factorization is a wrong direction.

    Simple recursion should be good enough to solve this problem.
    """
    def rec(x, prev_factor, acc, container):
        if x == 1:
            container.append('*'.join(map(str, acc)))
        for factor in xrange(prev_factor, x + 1):
            if x % factor == 0:
                rec(x / factor, factor, acc + [factor], container)

    container = []
    rec(n, 2, [], container)

    return container


def main():
    print solve(24)


if __name__ == '__main__':
    main()
