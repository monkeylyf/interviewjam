"""hackerrank_Worst_Permutation
hackerrank

https://www.hackerrank.com/contests/w14/challenges/worst-permutation
"""


def swap(arr, i, j):
    tmp = arr[i]
    arr[i] = arr[j]
    arr[j] = tmp

    return arr


def main():
    """Find and swap.

    Lexicalgraphically worst mean larger numbers go as left as possible.

    Try to swap N if N is not left enough. Note that if N is already is the
    position, you don't need to swap it and save it for other swap.
    """
    (n, k) = map(int, raw_input().split())
    arr = map(int, raw_input().split())

    swap_used = 0
    for i in xrange(n):
        target = n - i
        if target == arr[i]:
            continue
        index = arr.index(target)
        swap(arr, i, index)
        swap_used += 1
        if swap_used == k:
            # All swaps used up.
            break

    print ' '.join(map(str, arr))


if __name__ == '__main__':
    main()
