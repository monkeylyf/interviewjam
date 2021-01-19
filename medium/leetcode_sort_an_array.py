# https://leetcode.com/problems/sort-an-array/

from typing import List

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        return self.quick_sort(nums)

    def quick_sort(self, nums: List[int]) -> List[int]:
        if not nums or len(nums) == 1:
            return nums

        pivot = nums[0]
        left = [i for i in nums if i < pivot]
        right = [i for i in nums if i > pivot]
        return self.quick_sort(left) + [pivot] * nums.count(pivot) + self.quick_sort(right)


def main():
    sol = Solution()
    print(sol.sortArray([5, 5, 3, 0, 4, 1]))


if __name__ == '__main__':
    main()
