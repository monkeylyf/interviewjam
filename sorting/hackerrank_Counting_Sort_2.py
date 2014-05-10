"""Counting Sort 2

https://www.hackerrank.com/challenges/countingsort2
"""



def main():
    """Calling sorted and that's it?!"""
    N = int(raw_input())
    arr = map(int, raw_input().split())
    arr = sorted(arr)
    for i in arr:
        print i,
    print ''


if __name__ == '__main__':
    main()
