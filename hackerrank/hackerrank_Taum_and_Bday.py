"""hackerrank_Taum_and_Bday.py

https://www.hackerrank.com/contests/w13/challenges/taum-and-bday
"""


def main():
    t = int(raw_input())

    for _ in xrange(t):
        (b, w) = map(int, raw_input().split())
        (x, y, z) = map(int, raw_input().split())

        if x + z < y:
            # buying black and converting them into white is cheaper than
            # buying white directly.
            print x * b + (x + z) * w
        elif y + z < x:
            # buying white and converting them into black is cheaper than
            # buying black directly.
            print (y + z) * b + y * w
        else:
            print x * b + y * w



if __name__ == '__main__':
    main()
