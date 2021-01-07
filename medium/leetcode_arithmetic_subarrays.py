# https://leetcode.com/problems/arithmetic-subarrays/

from typing import List

class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        n = len(l)
        res = []
        for i in range(n):
            left = l[i]
            right = r[i]
            if left == right or left + 1 == right:
                res.append(True)
            else:
                subarray = nums[left:right + 1]
                res.append(self.is_arithmetic(subarray))

        return res

    def is_arithmetic(self, subarray):
        subarray.sort()
        diff = subarray[0] - subarray[1]
        i = 1
        while i < len(subarray) - 1:
            if subarray[i] - subarray[i + 1] != diff:
                return False
            i += 1
        return True


def main():
    sol = Solution()
    print(sol.checkArithmeticSubarrays([4,6,5,9,3,7], [0,0,2], [2,3,5]))


if __name__ == '__main__':
    main()
