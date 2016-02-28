"""Subsets II
leetcode

Given a collection of integers that might contain duplicates, nums, return all
possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
"""


class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        container = []
        nums.sort()
        self.dfs(0, [], nums, container)
        return container

    def dfs(self, i, acc, nums, container):
        if i == len(nums):
            container.append(acc[:])
        else:
            acc.append(nums[i])
            self.dfs(i + 1, acc, nums, container)
            acc.pop()

            # Magic here to dedup.
            while i < len(nums) - 1 and nums[i] == nums[i + 1]:
                i += 1
            self.dfs(i + 1, acc, nums, container)


def main():
    sol = Solution()
    print sol.subsetsWithDup([1, 2, 2])


if __name__ == '__main__':
    main()
