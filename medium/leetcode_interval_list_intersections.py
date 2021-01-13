# https://leetcode.com/problems/interval-list-intersections/

from typing import List

class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        if not firstList or not secondList:
            return []

        n = len(firstList)
        m = len(secondList)
        i = 0
        j = 0
        res = []
        while i < n and j < m:
            print(i, j)
            s1, e1 = firstList[i]
            s2, e2 = secondList[j]
            max_s = max(s1, s2)
            min_e = min(e1, e2)
            if max_s <= min_e:
                res.append([max_s, min_e])
            if e1 > e2:
                j += 1
            else:
                i += 1

        return res


def main():
    sol = Solution()
    print(sol.intervalIntersection(
        [[0,2],[5,10],[13,23],[24,25]], [[1,5], [8,12],[15,24],[25,26]]))


if __name__ == '__main__':
    main()
