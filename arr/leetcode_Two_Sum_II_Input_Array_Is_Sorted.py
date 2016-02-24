"""Two Sum II input array is sorted
leetcode

Given an array of integers that is already sorted in ascending order, find two
numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add
up to the target, where index1 must be less than index2. Please note that your
returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
"""


class Solution(object):

    def twoSum(self, numbers, target):
        """Sorted array suggests that a binary search can be applied.
        But dict solution is faster, with a little bit extra space.

        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        mapping = {}
        for i, val in enumerate(numbers, 1):
            if target - val in mapping:
                if target - val == val:
                    return mapping[val], i
                else:
                    b = mapping[target - val]
                    return min(i, b), max(i, b)
            else:
                mapping[val] = i


def main():
    sol = Solution()
    assert sol.twoSum([2, 7, 11, 15], 9) == (1, 2)


if __name__ == '__main__':
    main()
