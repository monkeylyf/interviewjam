# https://leetcode.com/problems/subrectangle-queries/

class SubrectangleQueriesSpaceEfficient:

    def __init__(self, rectangle: List[List[int]]):
        self.rectangle = rectangle

    def updateSubrectangle(self, row1: int, col1: int, row2: int, col2: int, newValue: int) -> None:
        for i in range(row1, row2 + 1):
            for j in range(col1, col2 + 1):
                self.rectangle[i][j] = newValue

    def getValue(self, row: int, col: int) -> int:
        return self.rectangle[row][col]


class SubrectangleQueries:

    def __init__(self, rectangle: List[List[int]]):
        self.rectangle = rectangle
        self.updated = []

    def updateSubrectangle(self, row1: int, col1: int, row2: int, col2: int, newValue: int) -> None:
        self.updated.append((row1, col1, row2, col2, newValue))

    def getValue(self, row: int, col: int) -> int:
        for (row1, col1, row2, col2, newValue) in reversed(self.updated):
            if row1 <= row and row <= row2 and col1 <= col and col <= col2:
                return newValue
        return self.rectangle[row][col]
