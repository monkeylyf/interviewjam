"""hackerrank_Find_The_Median

https://www.hackerrank.com/challenges/find-median
"""



def main():
    n = int(raw_input())
    arr = sorted(map(int, raw_input().split()))
    print arr[len(arr) / 2]


if __name__ == '__main__':
    main()
