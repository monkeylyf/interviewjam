# https://leetcode.com/problems/employee-importance

# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        mapping = {}

        for e in employees:
            mapping[e.id] = (e.importance, e.subordinates)

        return self._getImportance(id, mapping)

    def _getImportance(self, id, mapping):
        imp, directories = mapping[id]
        total = 0
        for i in directories:
            total += self._getImportance(i, mapping)
        return total + imp
