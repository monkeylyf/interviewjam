"""Permutations
leetcode

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
"""


class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        container = []
        nums.sort()
        self.dfs(0, [None] * len(nums), nums, [False] * len(nums), container)
        return container

    def dfs(self, idx, acc, nums, visited, container):
        if idx == len(nums):
            container.append(acc[:])
        else:
            i = 0
            while i < len(nums):
                num = nums[i]
                if not visited[i]:
                    visited[i] = True
                    acc[idx] = num
                    self.dfs(idx + 1, acc, nums, visited, container)
                    visited[i] = False
                    i += 1
                    while i < len(nums) and nums[i - 1] == nums[i]:
                        i += 1
                else:
                    i += 1


def main():
    sol = Solution()
    assert sol.permuteUnique([1, 2, 3]) == [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]


if __name__ == '__main__':
    main()
