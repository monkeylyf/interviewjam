# https://leetcode.com/problems/time-needed-to-inform-all-employees/

from typing import List

class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        if n <= 1:
            return 0
        mapping = [[] for _ in range(n)]
        for i, m in enumerate(manager):
            if m != -1:
                mapping[m].append(i)
        #print(mapping)
        #print(mapping[0])
        return self.nofity(headID, mapping, informTime)
        return 0

    def nofity(self, i, mapping, informTime):
        #print(i)
        child = mapping[i]
        if not child:
            return 0

        return informTime[i] + max(self.nofity(c, mapping, informTime) for c in child)


def main():
    sol = Solution()
    n = 15
    headID = 0
    manager = [-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6]
    informTime = [1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]
    print(sol.numOfMinutes(n, headID, manager, informTime) == 3)
    n = 4
    headID = 2
    manager = [3,3,-1,2]
    informTime = [0,0,162,914]
    print(sol.numOfMinutes(n, headID, manager, informTime) == 1076)
    n = 7
    headID = 6
    manager = [1,2,3,4,5,6,-1]
    informTime = [0,6,5,4,3,2,1]
    print(sol.numOfMinutes(n, headID, manager, informTime) == 21)


if __name__ == '__main__':
    main()
