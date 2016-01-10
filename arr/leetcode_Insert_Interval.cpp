/**
 * Copyright 2016
 * author: madarfacar
 *
 * leetcode insert interval
 */

#include <stdio.h>
#include <stdlib.h>
#include <vector>

using std::vector;


/**
 * Definition for an interval.
 */
struct Interval {
    int start;
    int end;
    Interval() : start(0), end(0) {}
    Interval(int s, int e) : start(s), end(e) {}
};


class Solution {
 public:
  vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
    int inserted_begin = -1;
    int inserted_end = -1;

    for (int i = 0; i < intervals.size(); ++i) {
      if (inserted_begin == -1 && newInterval.start <= intervals[i].end) {
        inserted_begin = i;
      }

      if (newInterval.end >= intervals[i].start) {
        inserted_end = i;
      }
    }

    if (inserted_begin == -1) {
      intervals.push_back(newInterval);
    } else if (inserted_end == -1) {
      intervals.insert(intervals.begin(), newInterval);
    } else {
      int merged_start = std::min(newInterval.start, intervals[inserted_begin].start);
      int merged_end = std::max(newInterval.end, intervals[inserted_end].end);
      Interval merged (merged_start, merged_end);

      intervals.erase(intervals.begin() + inserted_begin, intervals.begin() + inserted_end + 1);
      intervals.insert(intervals.begin() + inserted_begin, merged);
    }

    return intervals;
  }
};


int main() {
  Solution sol;
  vector<Interval> intervals {
    Interval (1, 2),
    Interval (3, 5),
    Interval (6, 7),
    Interval (8, 10),
    Interval (12, 16),
  };

  vector<Interval> inserted = sol.insert(intervals, Interval (4, 9));

  for (Interval interval : inserted) {
    printf("start: %d end: %d\n", interval.start, interval.end);
  }
}
