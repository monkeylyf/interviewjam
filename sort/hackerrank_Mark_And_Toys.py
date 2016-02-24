""" hackerrank_Mark_And_Toys.py

https://www.hackerrank.com/challenges/mark-and-toys
"""



def main():
    (N, K) = map(int, raw_input().split())

    prices = sorted(map(int, raw_input().split()))

    for i, val in enumerate(prices):
        if K >= val:
            K -= val
        else:
            print i
            break



if __name__ == '__main__':
    main()
