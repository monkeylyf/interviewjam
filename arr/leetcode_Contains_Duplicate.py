"""Contains duplicate
leetcode

Given an array of integers, find if the array contains any duplicates. Your
function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct.
"""
class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        #return len(nums) != len(set(nums))
        seen = {}
        for num in nums:
            if num in seen:
                return False
            else:
                seen.add(num)
        return True


def main():
    sol = Solution()


if __name__ == '__main__':
    main()
