"""hackerrank_Jim_and_the_Orders.py

https://www.hackerrank.com/contests/101sep14/challenges/jim-and-the-orders
"""


def main():
    n = int(raw_input())

    orders = []
    for i in xrange(1, n + 1):
        (t, d) = map(int, raw_input().split())
        orders.append((t + d, i))

    orders.sort()
    print ' '.join([str(i) for _, i in orders])

if __name__ == '__main__':
    main()
