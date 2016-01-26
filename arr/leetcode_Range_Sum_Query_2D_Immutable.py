"""Range sum query 2D immutable
leetcode

[
    [3, 0, 1, 4, 2],
    [5, 6, 3, 2, 1],
    [1, 2, 0, 1, 5],
    [4, 1, 0, 1, 7],
    [1, 0, 3, 0, 5],
]


Given a 2D matrix matrix, find the sum of the elements inside the rectangle
defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1)
and (row2, col2) = (4, 3), which contains sum = 8.
"""


class NumMatrix(object):
    def __init__(self, matrix):
        """initialize your data structure here.

        :type matrix: List[List[int]]
        """
        self.matrix = matrix
        for row in matrix:
            for i in xrange(len(row) - 1):
                row[i + 1] += row[i]

    def sumRegion(self, row1, col1, row2, col2):
        """sum of elements matrix[(row1,col1)..(row2,col2)], inclusive.

        :type row1: int
        :type col1: int
        :type row2: int
        :type col2: int
        :rtype: int
        """
        s = 0
        for i in xrange(row1, row2 + 1):
            if col1 == 0:
                s += self.matrix[i][col2]
            else:
                s += self.matrix[i][col2] - self.matrix[i][col1 - 1]
        return s


def main():
    # Your NumMatrix object will be instantiated and called as such:
    matrix = [
        [3, 0, 1, 4, 2],
        [5, 6, 3, 2, 1],
        [1, 2, 0, 1, 5],
        [4, 1, 0, 1, 7],
        [1, 0, 3, 0, 5],
    ]
    numMatrix = NumMatrix(matrix)
    assert numMatrix.sumRegion(2, 1, 4, 3) == 8
    assert numMatrix.sumRegion(1, 1, 2, 2) == 11
    assert numMatrix.sumRegion(1, 2, 2, 4) == 12



if __name__ == '__main__':
    main()
