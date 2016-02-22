"""Meeting rooms
leetcode

Given an array of meeting time intervals consisting of start and end times
[[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.
"""


# Definition for an interval.
class Interval(object):

    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e


class Solution(object):
    def canAttendMeetings(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: bool
        """
        tuples = sorted((item.start, item.end) for item in intervals)

        for i in xrange(1, len(intervals)):
            if tuples[i][0] < tuples[i - 1][1]:
                return False
        return True


def main():
    sol = Solution()
    assert sol.canAttendMeetings([])


if __name__ == '__main__':
    main()
