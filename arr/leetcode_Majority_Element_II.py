"""Majority element II
leetcode

Given an integer array of size n, find all elements that appear more than [n/3]
times. The algorithm should run in linear time and in O(1) space.
"""


class Solution(object):
    def majorityElement(self, nums):
        """Variation of Moore majority vote algorithm.

        https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
        Filter out the top two most frequency elements appeared in this array.
        Then count one more time to check whether they appeared more than n / 3
        times.
        Note that:
        1. Have to do the count because the 'count' used in filtering is not
        real counting but a 'diff'
        2. Top one and top two can be the same number
        3. Two candidates are not guaranteed to be in order of their frequency

        :type nums: List[int]
        :rtype: List[int]
        """
        first = 0
        second = 0
        first_diff = 0
        second_diff = 0

        for i in nums:
            if first == i:
                first_diff += 1
            elif second == i:
                second_diff += 1
            elif first_diff == 0:
                first = i
                first_diff = 1
            elif second_diff == 0:
                second = i
                second_diff = 1
            else:
                first_diff -= 1
                second_diff -= 1

        first_count = nums.count(first)
        second_count = nums.count(second)

        if second_count > first_count:
            first, second = second, first
            first_count, second_count = second_count, first_count

        res = []
        if first_count > len(nums) / 3:
            res.append(first)
        if len(res) > 0 and res[0] != second and second_count > len(nums) / 3:
            res.append(second)

        return res


def main():
    sol = Solution()
    assert sol.majorityElement([0, 0, 0]) == [0]
    assert sol.majorityElement([6, 5, 5]) == [5]


if __name__ == '__main__':
    main()
