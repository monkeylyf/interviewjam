"""Radix sort

https://en.wikipedia.org/wiki/Radix_sort
"""


def radix_sort(nums):
    """Radix sort.

    :param nums: list, of int
    """
    max_val = max(nums)
    base = 1
    while base <= max_val:
        # Sort by digit until digit position is larger than one of max value.
        radix_sort_util(nums, base)
        base *= 10


def radix_sort_util(nums, base):
    """Radix sort by digit.

    :param nums: list, of int
    :param base: int, base digit
    """
    count = [0] * 10
    for val in nums:
        digit = (val / base) % 10
        count[digit] += 1

    for i in range(1, 10):
        # Accumulate the count. After this, count[i] means how many number are
        # there <= nums[i], further by the index it should belong to in new arr
        # by count[i] - 1
        count[i] += count[i - 1]

    # A trick here to assign the elements in the same bucket in reversed order.
    buckets = [None] * len(nums)
    i = len(nums) - 1
    while i >= 0:
        val = nums[i]
        digit = (val / base) % 10
        counter = count[digit]
        buckets[counter - 1] = nums[i]
        count[digit] -= 1
        # Decrement by 1 so if there is another number share the same bucket
        # it will be assign to idx - 1
        i -= 1

    for i, val in enumerate(buckets):
        nums[i] = val


def main():
    nums = [170, 45, 75, 90, 802, 2, 24, 66]
    radix_sort(nums)
    assert nums == sorted(nums)


if __name__ == '__main__':
    main()
