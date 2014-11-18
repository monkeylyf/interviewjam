"""hackerrank_Priyanka_And_Toys.py

https://www.hackerrank.com/contests/w12/challenges/priyanka-and-toys
"""


def main():
    n = int(raw_input())
    height = map(int, raw_input().split())
    height.sort()

    unit = 0
    i, j = 0, 0
    while j < len(height):
        while j < len(height) and height[i] + 4 >= height[j]:
            j += 1

        unit += 1
        i = j

    print unit


if __name__ == '__main__':
    main()
