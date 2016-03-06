"""Find a ascending triplet

Given an unsorted array, find one increasing subsequence of length 3.

Formally the function should:
Return a list of integer with length 3, [i, j, k], which satisfy
such that arr[i] < arr[j] < arr[k] given 0 <= i < j < k <= n-1
If there is not such triplets, return empty list.

For example, given [12, 11, 10, 5, 6, 2, 30], return [5, 6, 30]
And [5, 4, 3, 2, 1] return []
"""



def find_a_triplet(nums):
    """Return an ascending triplet.

    Scan from left to right find the smaller element on each one's right.
    Then scan from right to left to find the match. Return anyone will do.

    :param nums: list, of int
    :param return: list, of int
    """
    n = len(nums)
    smaller = [-1] * n

    min_idx = 0
    for i in xrange(1, n):
        if nums[i] <= nums[min_idx]:
            min_idx = i
        else:
            smaller[i] = min_idx

    max_idx = n - 1
    for i in reversed(xrange(n - 1)):
        if nums[i] >= nums[max_idx]:
            max_idx = i
        elif smaller[i] != -1:
            return [smaller[i], i, max_idx]
        else:
            pass
    return []


def main():
    nums = [12, 11, 10, 5, 6, 2, 30]
    assert find_a_triplet(nums) == [3, 4, 6]

    nums = [5, 4, 3, 2, 1]
    assert find_a_triplet(nums) == []


if __name__ == '__main__':
    main()
