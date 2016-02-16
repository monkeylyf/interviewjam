"""Best meeting point
leetcode

A group of two or more people wants to meet and minimize the total travel
distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home
of someone in the group. The distance is calculated using Manhattan Distance,
where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of
2+2+2=6 is minimal. So return 6.
"""


class Solution(object):
    def minTotalDistance(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        x_values = []
        y_values = []

        for i, row in enumerate(grid):
            for j , val in enumerate(row):
                if val == 1:
                    x_values.append(i)
                    y_values.append(j)

        x_values.sort()
        y_values.sort()

        if x_values:
            return self.get_min_dist(x_values) + self.get_min_dist(y_values)
        else:
            return -1

    def get_min_dist(self, arr):
        """https://en.wikipedia.org/wiki/Median_absolute_deviation."""
        n = len(arr)
        mid = n / 2
        if n % 2 == 0:
            median = (arr[mid - 1] + arr[mid]) / 2
        else:
            median = arr[mid]
        #print arr
        #print median, median * n, sum(arr)
        dist = 0
        for i in arr:
            dist += abs(i - median)
        return dist


def main():
    sol = Solution()
    assert sol.minTotalDistance([[0,0,0,1,0,1,0,0,0,1,1,0]]) == 11


if __name__ == '__main__':
    main()
