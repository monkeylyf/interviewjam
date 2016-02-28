"""Subsets

Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
"""


class Solution(object):
    def subsets(self, nums):
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
            self.dfs(i + 1, acc, nums, container)


def main():
    sol = Solution()
    assert sol.subsets([1, 2, 3]) == [
        [1, 2, 3],
        [1, 2],
        [1, 3],
        [1],
        [2, 3],
        [2],
        [3],
        []
    ]


if __name__ == '__main__':
    main()
