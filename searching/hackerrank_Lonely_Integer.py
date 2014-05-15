"""hackerrank_Lonely_Integer

https://www.hackerrank.com/challenges/lonely-integer
"""

def main():
    N = int(raw_input())
    print reduce(lambda x, y: x ^ y, map(int, raw_input().split()), 0)


if __name__ == '__main__':
    main()
