"""3Sum smaller
leetcode

Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
"""

class Solution(object):

    def threeSumSmaller(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        count = 0
        n = len(nums)
        for i in xrange(n - 2):
            head = i + 1
            tail = n - 1
            # Two Sum Smaller.
            while head < tail:
                if nums[i]+ nums[head] + nums[tail] < target:
                    # Any idx within (head, tail] will satisfy the condition.
                    count += tail - head
                    head += 1
                else:
                    tail -= 1

        return count


def main():
    sol = Solution()
    assert sol.threeSumSmaller([-2, 0, 1, 3], 2) == 2


if __name__ == '__main__':
    main()
