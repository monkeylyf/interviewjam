"""Meeting Rooms II
leetcode

Given an array of meeting time intervals consisting of start and end times
[[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
"""


import heapq

# Definition for an interval.
class Interval(object):

    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e


class Solution(object):

    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        intervals = [(i.start, i.end) for i in intervals]
        intervals.sort()
        num_of_rooms = 0
        overlapped = []
        for start, end in intervals:
            while overlapped and overlapped[0] <= start:
                heapq.heappop(overlapped)
            heapq.heappush(overlapped, end)
            num_of_rooms = max(num_of_rooms, len(overlapped))
        return num_of_rooms


def main():
    sol = Solution()
    intervals = [
        Interval(0, 30),
        Interval(5, 10),
        Interval(15, 20),
    ]
    assert sol.minMeetingRooms(intervals) == 2


if __name__ == '__main__':
    main()
