# https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/

from typing import List

class Solution:
    def reconstructMatrix(self, upper: int, lower: int, colsum: List[int]) -> List[List[int]]:
        if upper + lower != sum(colsum):
            return []

        n = len(colsum)
        first_row = [0] * n
        second_row = [0] * n
        for i, val in enumerate(colsum):
            if val == 2:
                first_row[i] = 1
                second_row[i] = 1
                upper -= 1
                lower -= 1
            elif val == 1:
                if upper >= lower:
                    upper -= 1
                    first_row[i] = 1
                else:
                    lower -= 1
                    second_row[i] = 1
            else:
                pass
            if upper < 0 or lower < 0:
                return []

        return [first_row, second_row]


def main():
    sol = Solution()
    #print(sol.reconstructMatrix(2, 3, [2, 2, 1, 1]))
    #print(sol.reconstructMatrix(2, 1, [1, 1, 1]))
    #print(sol.reconstructMatrix(5, 5, [2,1,2,0,1,0,1,2,0,1]))
    print(sol.reconstructMatrix(9, 2, [0,1,2,0,0,0,0,0,2,1,2,1,2]))


if __name__ == '__main__':
    main()
