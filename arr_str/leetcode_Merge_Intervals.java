/*Merge_Intervals

Given a collection of intervals, merge all overlapping intervals.
For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

import java.util.ArrayList;


class leetcode_Merge_Intervals {
    public static void main(String[] args) {
    }
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            return res;
        }
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); ++i) {
            insert(res, intervals.get(i));
        }
        return res;
    }
    public void insert(ArrayList<Interval> intervals, Interval newInterval) {
        int s = -1, e = -1;
        for (int i = 0; i < intervals.size(); i++) {
            if (s == -1 && intervals.get(i).end >= newInterval.start) {
                s = i;
            }
            if (intervals.get(i).start <= newInterval.end) {
                e = i;
            }
        }
        if (s == -1) {
            intervals.add(newInterval);
        } else if (e == -1) {
            intervals.add(0, newInterval);
        } else {
            int start = Math.min(intervals.get(s).start, newInterval.start);
            int end = Math.max(intervals.get(e).end, newInterval.end);
            intervals.subList(s, e + 1).clear();
            intervals.add(s, new Interval(start, end));
        }
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
