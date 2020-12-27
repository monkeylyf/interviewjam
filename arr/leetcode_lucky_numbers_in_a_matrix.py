# https://leetcode.com/problems/lucky-numbers-in-a-matrix/

from typing import List


class Solution:
    def luckyNumbers (self, matrix: List[List[int]]) -> List[int]:
        # Since every number is distinct, the value itself is its identity.
        min_in_row = {min(row) for row in matrix}
        max_in_column = set()

        n = len(matrix)
        m = len(matrix[0])

        for i in range(m):
            min_value = max(matrix[j][i] for j in range(n))
            max_in_column.add(min_value)


        return list(min_in_row & max_in_column)


def main():
    sol = Solution()
    print(sol.luckyNumbers([[7, 8], [1, 2]]))


if __name__ == '__main__':
    main()
