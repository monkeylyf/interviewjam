"""Triangle
leetcode

Given a triangle, find the minimum path sum from top to bottom. Each step you
may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is
the total number of rows in the triangle.
"""


class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        if not triangle:
            return 0
        for i, row in enumerate(triangle):
            if i == 0:
                dp = row
            else:
                n = len(row)
                nx = [0] * n
                for i in xrange(n):
                    if i == 0:
                        nx[i] = dp[i] + row[i]
                    elif i == n - 1:
                        nx[i] = dp[i - 1] + row[i]
                    else:
                        nx[i] = min(dp[i - 1], dp[i]) + row[i]
                dp = nx
        return min(dp)


def main():
    sol = Solution()
    triangle = [
        [2],
        [3, 4],
        [6, 5, 7],
        [4, 1, 8, 3]
    ]
    assert sol.minimumTotal(triangle) == 1


if __name__ == '__main__':
    main()
