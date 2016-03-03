"""Smallest rectangle Enclosing Black Pixels
leetcode


An image is represented by a binary matrix with 0 as a white pixel and 1 as a
black pixel. The black pixels are connected, i.e., there is only one black
region. Pixels are connected horizontally and vertically. Given the location
(x, y) of one of the black pixels, return the area of the smallest
(axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.
"""


class Solution(object):
    def minArea(self, image, x, y):
        """
        :type image: List[List[str]]
        :type x: int
        :type y: int
        :rtype: int
        """
        # Find top and bottom boundaries.
        top = self.search_rows(image, 0, x, True)
        bottom = self.search_rows(image, x + 1, len(image), False)
        # Find left and right boundaries within top/bottom boundaries.
        left = self.search_columns(image, 0, y, top, bottom, True)
        right = self.search_columns(image, y + 1, len(image[0]), top, bottom, False)
        return (right - left) * (bottom - top)

    def search_rows(self, image, start, end, opt):
        while start < end:
            mid = (end - start) / 2 + start
            if ('1' in image[mid]) is opt:
                end = mid
            else:
                start = mid + 1
        return start

    def search_columns(self, image, start, end, top, bottom, opt):
        while start < end:
            mid = (start + end) / 2
            if any(image[k][mid] == '1' for k in xrange(top, bottom)) is opt:
                end = mid
            else:
                start = mid + 1
        return start


def main():
    sol = Solution()
    image = [
        '0010',
        '0110',
        '0100',
    ]
    assert sol.minArea(image, 0, 2) == 6


if __name__ == '__main__':
    main()
