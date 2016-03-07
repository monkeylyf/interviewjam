#!/usr/bin/env python
# -*- coding: utf8 -*-

"""Self Crossing
leetcode

You are given an array x of n positive numbers. You start at point (0,0) and
moves x[0] metres to the north, then x[1] metres to the west, x[2] metres to
the south, x[3] metres to the east and so on. In other words, after each move
your direction changes counter-clockwise.

Write a one-pass algorithm with O(1) extra space to determine, if your path
crosses itself, or not.

Example 1:
Given x = [2, 1, 1, 2],
┌───┐
│   │
└───┼──>
    │

Return true (self crossing)
Example 2:
Given x = [1, 2, 3, 4],
┌──────┐
│      │
│
│
└────────────>

Return false (not self crossing)
Example 3:
Given x = [1, 1, 1, 1],
┌───┐
│   │
└───┼>

Return true (self crossing)
"""


class Solution(object):
    def isSelfCrossing(self, x):
        """Draw it to understand it better.

        A line might be crossed with forth/fifth/sixth previous one.
        How about seventh? It will be the forth again which will be covered
        by next iteration.

        :type x: List[int]
        :rtype: bool
        """
        i = 3
        while i < len(x):
            # Forth line crossed first line.
            if x[i - 3] >= x[i - 1] and x[i - 2] <= x[i]:
                return True
            # Fifth line crossed first line.
            elif i >= 4 and x[i - 3] == x[i - 1] and x[i - 2] <= x[i] + x[i - 4]:
                return True
            # Sixth line crossed first line.
            # -----
            # |   |
            # |   |
            # |   ----|
            # |       |
            # --------|
            elif i >= 5 and x[i - 4] <= x[i - 2] and \
               x[i] + x[i - 4] >= x[i - 2] and \
               x[x - 3] <= x[i - 1] + x[i - 5] and \
               x[i - 3] >= x[i - 1]:
                return True
            else:
                i += 1
        return False


def main():
    sol = Solution()
    assert sol.isSelfCrossing([2, 1, 1, 2])
    assert not sol.isSelfCrossing([1, 2, 3, 4])
    assert sol.isSelfCrossing([1, 1, 1, 1])


if __name__ == '__main__':
    main()
