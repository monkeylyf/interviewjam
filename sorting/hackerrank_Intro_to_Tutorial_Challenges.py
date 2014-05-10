""" hackerrank_Intro_to_Tutorial_Challenges

https://www.hackerrank.com/challenges/tutorial-intro
"""


def binary_search(arr, V, start, end):
    while start <= end:
        mid = start + (end - start) / 2

        if arr[mid] == V:
            return mid
        elif arr[mid] > V:
            end = mid - 1
        else:
            start = mid + 1

    return -1


def main():
    V = int(raw_input())
    n = int(raw_input())
    arr = map(int, raw_input().split())

    print binary_search(arr, V, 0, n - 1)


if __name__ == '__main__':
    main()
