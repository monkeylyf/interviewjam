# https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/
class Solution:
    def findLexSmallestString(self, s: str, a: int, b: int) -> str:

        return self.dfs(s, a, b, set())

    def dfs(self, s, a, b, seen):
        if s in seen:
            return None

        seen.add(s)
        res = [s]
        by_add = self.add(s, a)
        min_by_add = self.dfs(by_add, a, b, seen)
        if min_by_add is not None:
            res.append(min_by_add)

        by_rotate = self.rotate(s, b)
        min_by_rotate = self.dfs(by_rotate, a, b, seen)
        if min_by_rotate is not None:
            res.append(min_by_rotate)

        return min(res)

    def add(self, s, a):
        res = []

        for i, c in enumerate(s):
            if i % 2 == 1:
                val = (int(c) + a) % 10
                res.append(str(val))
            else:
                res.append(c)
        return ''.join(res)

    def rotate(self, s, b):
        return s[-b:] + s[:-b]
