"""Insertion sort.py

https://en.wikipedia.org/wiki/Insertion_sort
"""


def insertion_sort(arr):
    for i in xrange(1, len(arr)):
        j = i
        while j > 0:
            if arr[j - 1] > arr[j]:
                arr[j - 1], arr[j] = arr[j], arr[j - 1]
                j -= 1
            else:
                break


def main():
    arr = [3, 2, 1, 5, 7, 0, 6]
    insertion_sort(arr)
    print arr


if __name__ == '__main__':
    main()
