/*Insert_Interval

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
*/

import java.util.ArrayList;


class leetcode_Insert_Interval {
    public static void main(String[] args) {
    }
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int s = -1, e = -1;
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (s == -1 && cur.end >= newInterval.start) {
                // The first Interval with end larger than newInterval.start 
                s = i;
            }
            if (cur.start <= newInterval.end) {
                e = i;
            }
        }
        // Miss all the if on the loop above. Meaning newInterval.start is larger than any intervals.end.
        // Added to the end of array.
        if (s == -1) {
            intervals.add(newInterval);
            return intervals;
        }
        // Miss all the if on the loop alove. Meaning newInterval.end is is less than any intervals.start.
        // Added to the begining of array.
        if (e == -1) {
            intervals.add(0, newInterval);
            return intervals;
        }
        int newStart = Math.min(intervals.get(s).start, newInterval.start);
        int newEnd = Math.max(intervals.get(e).end, newInterval.end);
        intervals.subList(s, e + 1).clear();
        intervals.add(s, new Interval(start, end));
        return intervals;
    }
}


class Interval {
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }
    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
