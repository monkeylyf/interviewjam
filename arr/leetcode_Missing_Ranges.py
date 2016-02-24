"""Missing ranges
leetcode

Given a sorted integer array where the range of elements are [lower, upper]
inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return
["2", "4->49", "51->74", "76->99"].
"""


class Solution(object):
    def findMissingRanges(self, nums, lower, upper):
        """O(n)

        1. Set start as lower and iterate through nums.
        2. if the element is larger than start point, we have a missing range,
           either single number range, e.g., '1', or range, e.g., '3->5'. Then
           update the start point to element + 1
        3. When the iteration finishes, check start point with upper to close
           out the last range, if any

        :type nums: List[int]
        :type lower: int
        :type upper: int
        :rtype: List[str]
        """
        ret = []
        start = lower

        for num in nums:
            if start == num - 1:
                ret.append(str(start))
            elif start < num - 1:
                ret.append('{}->{}'.format(start, num - 1))
            else:
                pass
            start = num + 1

        if start == upper:
            ret.append(str(start))
        elif start < upper:
            ret.append('{}->{}'.format(start, upper))
        else:
            pass
        return ret


def main():
    sol = Solution()
    assert sol.findMissingRanges([0, 1, 3, 50, 75], 0, 99) == ["2","4->49","51->74","76->99"]


if __name__ == '__main__':
    main()
