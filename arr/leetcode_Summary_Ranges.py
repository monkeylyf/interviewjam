"""Summary ranges.
leetcode

Given a sorted integer array without duplicates, return the summary of its ranges.
For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
"""

class Solution(object):
    def summaryRanges(self, nums):
        """Checkout when discontinuity observed or last element reached.

        :type nums: List[int]
        :rtype: List[str]
        """
        ret = []
        i = 0
        while i < len(nums):
            j = i
            while j < len(nums) - 1 and nums[j] + 1 == nums[j + 1]:
                j += 1
            if i == j:
                ret.append(str(nums[i]))
            else:
                ret.append('{}->{}'.format(nums[i], nums[j]))
            i = j + 1
        return ret


def main():
    sol = Solution()
    assert sol.summaryRanges([0, 1, 2, 4, 5, 7]) == ["0->2", "4->5", "7"]
    assert sol.summaryRanges([1]) == ["1"]


if __name__ == '__main__':
    main()
