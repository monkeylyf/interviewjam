"""hackerrank_Closest_Numbers

https://www.hackerrank.com/challenges/closest-numbers
"""


def solve(arr):
    min_diff = 20000001
    num = []

    for i in xrange(1, len(arr)):
        if arr[i] - arr[i - 1] == min_diff:
            num += [arr[i - 1], arr[i]]
        elif arr[i] - arr[i - 1] < min_diff:
            num = [arr[i - 1], arr[i]]
            min_diff = arr[i] - arr[i - 1]
        else:
            pass

    print ' '.join(map(str, num))

def main():
    N = int(raw_input())
    arr = sorted(map(int, raw_input().split()))
    solve(arr)


if __name__ == '__main__':
    main()
