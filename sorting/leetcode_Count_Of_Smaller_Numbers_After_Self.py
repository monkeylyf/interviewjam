"""Count of smaller numbers after self
leetcode

You are given an integer array nums and you have to return a new counts array.
The counts array has the property where counts[i] is the number of smaller
elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].
"""

class Token(object):

    __slots__ = ('val', 'idx', 'count')

    def __init__(self, val, idx, count):
        """"""
        self.val = val
        self.idx = idx
        self.count = count

    def __cmp__(self, other):
        """Comparison operation."""
        return cmp(self.val, other.val)

    def __repr__(self):
        return 'val: {} count: {}'.format(self.val, self.count)


class Solution(object):

    def countSmaller(self, nums):
        """Merge sort like solution.

        The problem gets tricky when what's asked for is elements smaller instead
        of no larger than. The reason is during merge operation, when left[i] >=
        right[j], you cannot tell how many element on the right side of right[j]
        are smaller than left[i] because of there might be multiple elements with
        the same value of right[j] after right[j].

        Think the opposite: In order to count the smaller numbers after self, we
        count the number no larger than self after self. Since the given array
        has fixed length, we can do:
        # of smaller of arr[i] = (len(arr) - i - 1) - # of no larger than of arr[i]

        This will be hell of easier to implementw without considering sequantial
        same numbers.

        :type nums: List[int]
        :rtype: List[int]
        """
        def merge(left, right):
            """Merge two sorted arrays.

            :param left: list, of token objects
            :param right: list, of token objects
            """
            i = 0
            j = 0
            merged = []
            while i < len(left) and j < len(right):
                left_token = left[i]
                right_token = right[j]
                if left_token <= right_token:
                    # Key line.
                    left_token.count = left_token.count + (len(right) - 1 - j) + 1
                    merged.append(left_token)
                    i += 1
                else:
                    merged.append(right_token)
                    j += 1

            if i < len(left):
                merged.extend(left[i:])
            if j < len(right):
                merged.extend(right[j:])
            return merged

        def dnc(nums, start, end):
            """Divide and conquer.

            Just like merge sort.

            :param nums: list
            :param start: int
            :param end: int
            :param return: list
            """
            if start > end:
                return []
            elif start == end:
                return [Token(nums[start], start, 0)]
            else:
                mid = (end - start) / 2 + start
                left = dnc(nums, start, mid)
                right = dnc(nums, mid + 1, end)
                return merge(left, right)

        n = len(nums)
        tokens = dnc(nums, 0, n - 1)
        res = [None] * n
        for token in tokens:
            res[token.idx] = n - token.idx - 1 - token.count
        return res


def main():
    sol = Solution()
    assert sol.countSmaller([5, 2, 6, 1]) == [2, 1, 1, 0]
    assert sol.countSmaller([]) == []
    assert sol.countSmaller([1]) == [0]
    assert sol.countSmaller([1, 2]) == [0, 0]
    assert sol.countSmaller([2, 1]) == [1, 0]
    assert sol.countSmaller([1, 1, 1, 1]) == [0, 0, 0, 0]
    assert sol.countSmaller([51,9,21,84,66,65,36,100,41]) == [4, 0, 0, 4, 3, 2, 0, 1, 0]


if __name__ == '__main__':
    main()
