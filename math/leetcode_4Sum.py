"""4Sum

Given an array S of n integers, are there elements a, b, c, and d in S such
that a + b + c + d = target? Find all unique quadruplets in the array which
gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order.
(ie, a <= b <= c <= d)
The solution set must not contain duplicate quadruplets.
For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

A solution set is:
(-1,  0, 0, 1)
(-2, -1, 1, 2)
(-2,  0, 0, 2)
"""


from collections import defaultdict


class Pair:

    __slots__ = ('sum', 'idx_a', 'idx_b')

    def __init__(self, a, b, idx_a, idx_b):
        self.sum = a + b
        self.idx_a = idx_a
        self.idx_b = idx_b

    def __cmp__(self, that):
        return self.sum - that.sum

    def overlap(self, that):
        return set([that.idx_a, that.idx_b]) & set([self.idx_a, self.idx_b])


class Solution:
    # @return a list of lists of length 4, [[val1,val2,val3,val4]]
    def fourSum(self, nums, target):
        if not nums or len(nums) <= 3:
            return []

        container = set()

        pair_sum = defaultdict(list)
        for i in xrange(len(nums)):
            for j in xrange(i + 1, len(nums)):
                pair = Pair(nums[i], nums[j], i, j)
                pair_sum[pair.sum].append(pair)

        group = []
        for s in sorted(pair_sum.keys()):
            group.append(pair_sum[s])

        head = 0
        tail = len(group) - 1
        while head <= tail:
            head_pairs = group[head]
            tail_pairs = group[tail]
            if head_pairs[0].sum + tail_pairs[0].sum == target:
                for quadlet in self.collect(head_pairs, tail_pairs, nums):
                    container.add(quadlet)
                head += 1
                tail -= 1
            elif head_pairs[0].sum + tail_pairs[0].sum > target:
                tail -= 1
            else:
                head += 1

        return [list(item) for item in container]

    def collect(self, head_pairs, tail_pairs, nums):
        for h in head_pairs:
            for t in tail_pairs:
                if not h.overlap(t):
                    quadlet = [nums[h.idx_a], nums[h.idx_b], nums[t.idx_a], nums[t.idx_b]]
                    yield tuple(sorted(quadlet))


def main():
    sol = Solution()
    nums = [1, 0, -1, 0, -2, 2]
    assert sol.fourSum(nums, 0) == [
        [-2, -1, 1, 2],
        [-1, 0, 0, 1],
        [-2, 0, 0, 2]
    ]


if __name__ == '__main__':
    main()
