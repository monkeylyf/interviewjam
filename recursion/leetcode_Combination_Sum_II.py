"""Combination Sum II
leetcode

Given a collection of candidate numbers (C) and a target number (T), find all
unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ... , ak) must be in non-descending order.
(ie, a1 <= a2 <= ... <= ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8,
A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
"""


class Solution(object):

    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        container = []
        candidates.sort()
        self.dfs(0, [], candidates, target, container)
        return container

    def dfs(self, i, acc, candidates, target, container):
        if target < 0:
            return
        elif target == 0:
            container.append(acc[:])
        else:
            while i < len(candidates):
                acc.append(candidates[i])
                self.dfs(i + 1, acc, candidates, target - candidates[i], container)
                acc.pop()
                i += 1
                while i < len(candidates) and candidates[i - 1] == candidates[i]:
                    i += 1


def main():
    sol = Solution()
    candidates = [10, 1, 2, 7, 6, 1, 5]
    target = 8
    assert sol.combinationSum2(candidates, target) == [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]


if __name__ == '__main__':
    main()
