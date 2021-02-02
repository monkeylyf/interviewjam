# https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/

from typing import List

class Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        def dfs(cur, arr, v, m, n):
            v.add(cur)
            arr.append(cur)

            if len(arr) == n:
                return True

            for neighbor in m[cur]:
                if neighbor not in v:
                    if dfs(neighbor, arr, v, m, n):
                        return True

            arr.pop()
            v.remove(cur)

        mapping = {}
        for i, j in adjacentPairs:
            ii = mapping.get(i)
            if ii is None:
                mapping[i] = [j]
            else:
                ii.append(j)

            jj = mapping.get(j)
            if jj is None:
                mapping[j] = [i]
            else:
                jj.append(i)
        source = None
        for source, neighbors in mapping.items():
            if len(neighbors) == 1:
                break
        if source is None:
            raise ValueError()

        visited = set()
        array = []
        dfs(source, array, visited, mapping, len(adjacentPairs) + 1)
        return array
