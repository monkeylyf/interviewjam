"""3Sum
leetcode

Given an array S of n integers, are there elements a, b, c in S such that
a + b + c = 0? Find all unique triplets in the array which gives the sum of
zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order.
(ie, a <= b <= c)
The solution set must not contain duplicate triplets.
For example, given array S = {-1 0 1 2 -1 -4},

A solution set is:
(-1, 0, 1)
(-1, -1, 2)
"""


class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        n = len(nums)
        nums.sort()
        triplets = []
        i = 0
        while i < n - 2:
            head = i + 1
            tail = n - 1
            while head < tail:
                local_sum = nums[head] + nums[tail]
                if local_sum == -nums[i]:
                    triplets.append([nums[i], nums[head], nums[tail]])
                    head += 1
                    tail -= 1
                    # Dedup.
                    while head < tail and nums[head - 1] == nums[head]:
                        head += 1
                    while tail > head and nums[tail + 1] == nums[tail]:
                        tail -= 1
                elif local_sum > -nums[i]:
                    tail -= 1
                else:
                    head += 1
            i += 1
            while i < n and nums[i - 1] == nums[i]:
                i += 1

        return triplets


def main():
    sol = Solution()
    nums = [-1, 0, 1, 2, -1, -4]
    assert sol.threeSum(nums) == [[-1, -1, 2], [-1, 0, 1]]


if __name__ == '__main__':
    main()
