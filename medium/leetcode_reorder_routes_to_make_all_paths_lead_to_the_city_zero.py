# https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
from typing import List

class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        if not connections:
            return 0
        reversed_mapping = [[] for _ in range(n)]  # Reversed reversed_mapping.
        mapping = [[] for _ in range(n)]  # Reversed reversed_mapping.
        for source, dest in connections:
            reversed_mapping[dest].append(source)
            mapping[source].append(dest)

        queue = [0]
        visited = [False] * n
        ops = 0
        while queue:
            city = queue.pop()
            visited[city] = True

            for neighbor in reversed_mapping[city]:
                if not visited[neighbor]:
                    queue.append(neighbor)
            for neighbor in mapping[city]:
                if not visited[neighbor]:
                    ops += 1
                    queue.append(neighbor)
        return ops

    def minReorderSlow(self, n: int, connections: List[List[int]]) -> int:
        if not connections:
            return 0

        reversed_mapping = [[] for _ in range(n)]  # Reversed reversed_mapping.
        mapping = [[] for _ in range(n)]  # Reversed reversed_mapping.
        for source, dest in connections:
            reversed_mapping[dest].append(source)
            mapping[source].append(dest)
        #print(reversed_mapping)

        # Filter out cities that can reach city zero without changing any edges
        queue = [0]
        visited = [False] * n
        while queue:
            city = queue.pop()
            visited[city] = True

            for neighbor in reversed_mapping[city]:
                if not visited[neighbor]:
                    queue.append(neighbor)

        not_visited = [i for i, v in enumerate(visited) if not v]
        count = 0
        k = 1
        #print(not_visited)
        while not_visited:
            for i in not_visited:
                #print(i)
                for d in reversed_mapping[i]:
                    if visited[d]:
                        #print('reverse edge between', i, d)
                        count += 1
                        visited[i] = True
            for i in range(n):
                for d in mapping[i]:
                    if visited[d]:
                        visited[i] = True
                        #print('reverse edge between', i, d)
                        break

            not_visited = [i for i, v in enumerate(visited) if not v]
            #print(not_visited)
            k += 1
        return count


def main():
    sol = Solution()
    n = 6
    connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
    print(sol.minReorder(n, connections) == 3)
    n = 5
    connections = [[1,0],[1,2],[3,2],[3,4]]
    print(sol.minReorder(n, connections) == 2)
    n = 3
    connections = [[1,0],[2,0]]
    print(sol.minReorder(n, connections) == 0)


if __name__ == '__main__':
    main()
