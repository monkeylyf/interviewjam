from collections import defaultdict, deque

class Solution(object):

    """Two take aways:
    1. What's the definition of a tree?
       https://en.wikipedia.org/wiki/Tree_(data_structure)#Definition
    2. How to detect cycle in a undirected graph? How about directed graph?
    """

    def validTreeRecursive(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: bool
        """
        mapping = defaultdict(list)
        for s, e in edges:
            mapping[s].append(e)
            mapping[e].append(s)

        visited = [False] * n
        if self.cyclic(0, -1, mapping, visited):
            return False
        else:
            return all(visited)

    def cyclic(self, node, parent, graph, visited):
        visited[node] = True
        for neighbor in graph.get(node, []):
            if neighbor != parent:
                if visited[neighbor]:
                    return True
                if self.cyclic(neighbor, node, graph, visited):
                    return True
        return False

    def validTree(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: bool
        """
        mapping = defaultdict(list)
        for s, e in edges:
            mapping[s].append(e)
            mapping[e].append(s)

        queue = deque([(0, -1)])
        visited = [False] * n
        while queue:
            node, parent = queue.popleft()
            if visited[node]:
                return False
            visited[node] = True

            for neighbor in mapping.get(node, []):
                if neighbor != parent:
                    queue.append((neighbor, node))

        return all(visited)


def main():
    sol = Solution()
    assert sol.validTree(5, [[0,1],[0,2],[2,3],[2,4]])
    assert not sol.validTree(5, [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]])


if __name__ == '__main__':
    main()
