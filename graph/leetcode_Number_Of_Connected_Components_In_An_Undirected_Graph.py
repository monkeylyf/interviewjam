class Solution(object):
    def countComponents(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: int
        """
        visited = [False] * n
        mapping = {}
        for i, j in edges:
            mapping.setdefault(i, []).append(j)
            mapping.setdefault(j, []).append(i)

        count = 0
        for i in xrange(n):
            if not visited[i]:
                self.dfs(visited, i, mapping)
                count += 1
        return count

    def dfs(self, visited, i, mapping):
        visited[i] = True
        for j in mapping.get(i, []):
            if not visited[j]:
                self.dfs(visited, j, mapping)

