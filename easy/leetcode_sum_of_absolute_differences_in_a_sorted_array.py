# https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/

from typing import List

class Solution:
    def getSumAbsoluteDifferences(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        n = len(nums)
        if n == 1:
            return []

        res = [0] * n
        left_acc = 0
        right_acc = sum(nums)
        for i, val in enumerate(nums):
            right_acc -= val  # Right/left acc excludes val.
            left = val * i - left_acc
            right = right_acc - val * (n - i - 1)
            res[i] = left + right
            left_acc += val

        return res


def main():
    sol = Solution()
    print(sol.getSumAbsoluteDifferences([1,4,6,8,10]))
    print(sol.getSumAbsoluteDifferences([2, 3, 5]))


if __name__ == '__main__':
    main()
