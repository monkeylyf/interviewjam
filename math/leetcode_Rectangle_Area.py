"""Rectangle area
leetcode

Find the total area covered by two rectilinear rectangles in a 2D plane.
Each rectangle is defined by its bottom left corner and top right corner as
shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
"""


class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        """((A, B), (C, D)), ((E, F), (G, H)).

        Covered area = area of rectangle A + area of rectangle B - overlapped area

        To calculate the overlapped area, the overlapped line segment is needed in
        terms of x/y axis.

        :type A: int
        :type B: int
        :type C: int
        :type D: int
        :type E: int
        :type F: int
        :type G: int
        :type H: int
        :rtype: int
        """
        def overlap(a, b, c, d):
            """Calculate the overlapped line segment of two line in 1D space."""
            if a > c:
                a, b, c, d = c, d, a, b
            if c < b:
                return min(b - c, d - c)
            else:
                return 0

        area1 = (C - A) * (D - B)
        area2 = (G - E) * (H - F)
        overlapped_area = overlap(A, C, E, G) * overlap(F, H, B, D)
        return area1 + area2 - overlapped_area


def main():
    sol = Solution()
    assert sol.computeArea(-2, -2, 2, 2, -2, -2, 2, 2) == 16
    assert sol.computeArea(0, 0, 0, 0, -1, -1, 1, 1) == 4


if __name__ == '__main__':
    main()
