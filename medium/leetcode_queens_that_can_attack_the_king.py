# https://leetcode.com/problems/queens-that-can-attack-the-king/

from typing import List

class Solution:
    def queensAttacktheKing(self, queens: List[List[int]], king: List[int]) -> List[List[int]]:
        q = {(i, j) for i, j in queens}
        res = []
        # Check horizontal/vertical.
        for dx, dy in ((0, 1), (1, 0), (0, -1), (-1, 0), (-1, -1), (1, 1), (-1, 1), (1, -1)):
            i, j = king
            is_in_or_found = True
            while is_in_or_found:
                i += dx
                j += dy
                if 0 <= i and i < 8 and 0 <= j and j < 8:
                    if (i, j) in q:
                        res.append([i, j])
                        is_in_or_found = False
                else:
                    is_in_or_found = False

        return res


def main():
    sol = Solution()
    queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]]
    king = [0,0]
    print(sol.queensAttacktheKing(queens, king))


if __name__ == '__main__':
    main()
