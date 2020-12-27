# https://leetcode.com/problems/check-array-formation-through-concatenation

from typing import List


class Solution:
    def canFormArray(self, arr: List[int], pieces: List[List[int]]) -> bool:
        mapping = {x[0]: x for x in pieces}
        res = []

        for num in arr:
            res.extend(mapping.get(num, []))

        return res == arr

    def canFormArrayNotSoGood(self, arr: List[int], pieces: List[List[int]]) -> bool:
        n = len(arr)
        m = sum(len(piece) for piece in pieces)

        if n != m:
            return False
        else:
            # It is interesting that having an extra set indicating used pieces,
            # neither speed this up nor save any memory benchmarked by OJ.
            return self._canForm(0, arr, pieces)

    def _canForm(self, index: int, arr: List[int], pieces: List[List[int]]) -> bool:
        if index == len(arr):
            return True

        for (i, piece) in enumerate(pieces):
            n = len(piece)
            if piece == arr[index:index + n]:
                can = self._canForm(index + n, arr, pieces[:i] + pieces[i + 1:])
                if can:
                    return True
        return False


def main():
    sol = Solution()
    arr = [75,1,60,91,84,55,5,39,19,52,38,66,14,17,49]
    pieces = [[60],[52,38],[66],[39],[19],[1],[84,55],[17],[14],[49],[91],[5],[75]]
    print(sol.canFormArray(arr, pieces))


if __name__ == '__main__':
    main()
