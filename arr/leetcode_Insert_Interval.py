"""Insert Interval
leetcode

Given a set of non-overlapping intervals, insert a new interval into the
intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their
start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as
[1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
"""


# Definition for an interval.
class Interval(object):

    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

    def __repr__(self):
        return '[{}, {}]'.format(self.start, self.end)


class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[Interval]
        :type newInterval: Interval
        :rtype: List[Interval]
        """
        start = -1
        end = -1

        for i, intv in enumerate(intervals):
            if start == -1 and intv.end >= newInterval.start:
                start = i
            if intv.start <= newInterval.end:
                end = i
        #print start, end
        if start == -1:
            intervals.append(newInterval)
        elif end == -1:
            intervals.insert(0, newInterval)
        else:
            newInterval.start = min(newInterval.start, intervals[start].start)
            newInterval.end = max(newInterval.end, intervals[end].end)
            intervals = intervals[:start] + [newInterval] + intervals[end + 1:]
        return intervals


def main():
    sol = Solution()
    intervals = [
        Interval(1, 3),
        Interval(6, 9),
    ]
    print sol.insert(intervals, Interval(2, 5))


if __name__ == '__main__':
    main()
