"""Combination Sum
leetcode

Given a set of candidate numbers (C) and a target number (T), find all unique
combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ... , ak) must be in non-descending order.
(ie, a1 <= a2 <= ... <= ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3]
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
                self.dfs(i, acc, candidates, target - candidates[i], container)
                acc.pop()
                i += 1


def main():
    sol = Solution()
    candidates = [2, 3, 6, 7]
    target = 7
    assert sol.combinationSum2(candidates, target) == [[2, 2, 3], [7]]


if __name__ == '__main__':
    main()
