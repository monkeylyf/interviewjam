"""Minimum size subarray sum
leetcode

Given an array of n positive integers and a positive integer s, find the
minimal length of a subarray of which the sum >= s. If there isn't one, return
0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
"""


class Solution(object):
    def minSubArrayLen(self, s, nums):
        """Two pointers.
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        sum_of_array = 0
        i = 0
        j = 0
        acc = 0
        min_length = float('+inf')
        while j < len(nums):
            acc += nums[j]
            sum_of_array += nums[j]
            if acc >= s:
                # Move head to right most that ac still >= s
                while acc - nums[i] >= s:
                    acc -= nums[i]
                    i += 1
                min_length = min(min_length, j - i + 1)
            j += 1
        if sum_of_array == s:
            return j
        elif sum_of_array < s:
            return 0
        else:
            return min_length


def main():
    sol = Solution()
    assert sol.minSubArrayLen(4, [1, 4, 4]) == 1
    assert sol.minSubArrayLen(7, [2, 3, 1, 2, 4, 3]) == 2
    assert sol.minSubArrayLen(5, [2, 3, 1, 1, 1, 1]) == 2


if __name__ == '__main__':
    main()
