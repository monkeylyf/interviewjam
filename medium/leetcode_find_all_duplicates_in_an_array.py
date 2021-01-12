# https://leetcode.com/problems/find-all-duplicates-in-an-array/

from typing import List

class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        res = []
        for i in nums:
            index = abs(i) - 1
            if nums[index] > 0:
                nums[index] = -nums[index]
            else:
                res.append(abs(i))

        return res


def main():
    sol = Solution()
    print(sol.findDuplicates([4,3,2,7,8,2,3,1]))


if __name__ == '__main__':
    main()
