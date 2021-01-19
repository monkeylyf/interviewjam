# https://leetcode.com/problems/k-closest-points-to-origin/

from typing import List

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        if k == len(points):
            return points

        points = [(x * x + y * y, x, y) for x, y in points]
        if k == 1:
            points.sort()
            _, x, y = points[0]
            return [[x, y]]
        res = self.quick_sort_var(points, k)
        return [[x, y] for _, x, y in res]

    def quick_sort_var(self, points, k):
        if not points:
            return []

        if len(points) == k:
            return points

        pivot = points[0][0]
        smaller = [p for p in points if p[0] < pivot]
        equal = [p for p in points if p[0] == pivot]
        len_smaller = len(smaller)
        len_equal = len(equal)
        if len_smaller + len_equal < k:
            bigger = [p for p in points if p[0] > pivot]
            return smaller + equal + self.quick_sort_var(bigger, k - len_smaller - len_equal)
        elif len_smaller + len_equal == k:
            return smaller + equal
        elif len_smaller == k:
            return smaller
        elif len_smaller < k:
            return smaller + equal[:k - len_smaller]
        else:
            return self.quick_sort_var(smaller, k)


def main():
    sol = Solution()
    print(sol.kClosest([[1,3],[-2,2]], 1))
    print(sol.kClosest([[3,3],[5,-1],[-2,4]], 2))
    print(sol.kClosest([[68,97],[34,-84],[60,100],[2,31],[-27,-38],[-73,-74],[-55,-39],[62,91],[62,92],[-57,-67]], 5))


if __name__ == '__main__':
    main()
