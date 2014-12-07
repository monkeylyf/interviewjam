"""archery.py

https://www.hackerrank.com/contests/quora-haqathon/challenges/archery
"""

def binary_search(arr, target):
    head = 0
    tail = len(arr) - 1

    while head <= tail:
        mid = (tail - head) / 2 + head

        if arr[mid] > target:
            tail = mid - 1
        elif arr[mid] < target:
            head = mid + 1
        else:
            return mid

    return head

def main():
    n = int(raw_input())
    radii = map(int, raw_input().split())
    radii.sort()
    m = int(raw_input())
    Q_count = 0
    for _ in xrange(m):
        x1, y1, x2, y2 = map(int, raw_input().split())
        d1 = (x1 * x1 + y1 * y1) ** .5
        d2 = (x2 * x2 + y2 * y2) ** .5

        closer_to_origin = min(d1, d2)
        further_from_origin = max(d1, d2)
        i = binary_search(radii, closer_to_origin)
        j = binary_search(radii, further_from_origin)

        Q_count += j - i

    print Q_count


if __name__ == '__main__':
    main()
