"""leetcode_Course_Schedule

https://leetcode.com/problems/course-schedule/

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to
first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it
possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have
finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have
finished course 0, and to take course 0 you should also have finished course 1.
So it is impossible.
"""


from collections import deque


class Solution:

    """Circle detection in directed graph.

    Note that the graph might have multiple sub-graph.
    """

    def canFinish(self, numCourses, prerequisites):
        """"""
        if not prerequisites:
            return True
        indegree = [0] * numCourses
        outdegree = [set() for _ in xrange(numCourses)]

        for a, b in prerequisites:
            if a not in outdegree[b]:
                outdegree[b].add(a)
                indegree[a] += 1

        queue = deque(i for i, val in enumerate(indegree) if val == 0)
        while queue:
            node = queue.popleft()
            for neighbor in outdegree[node]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    queue.append(neighbor)

        return not any(in_node for in_node in indegree)

    def canFinishTooComplicated(self, numCourses, prerequisites):
        """"""
        # Build adj list as graph.
        graph = {}

        for edge in prerequisites:
            node_to = edge[0]
            node_from = edge[1]
            graph.setdefault(node_from, []).append(node_to)

        # Cycle dection in DAG.
        return self.is_acyclic(graph, numCourses)

    def is_acyclic(self, graph, n):
        """Return whether a graph is acyclic.

        I might be overkilling this interview question here(might not) but it
        is a wonderful practice as in general graph topic, SCC and Toposort.

        The general idea to use scc/toposort to detect cyclic graph is:
        1. Get the toposort order of all nodes, including those in sub-graphs
        2. Transpose the graph
        3. Given the toposort order, if every node has no unchecked neighbors
           it points to, then it's an acyclic graph.

        :param graph: dict, adj list
        :param graph: int, number of nodes
        """
        def toposort(i, visited, stack, graph):
            """Toposort graph and push order in stack."""
            visited[i] = True
            for j in graph.get(i, []):
                if not visited[j]:
                    toposort(j, visited, stack, graph)
            stack.append(i)

        def transpose_graph(graph):
            """Return the transposed copy of a given graph.

            :parram graph: dict, adj list
            :parram return: dict, transposed graph in adj list
            """
            transposed = {}
            for from_node, to_nodes in graph.iteritems():
                for to_node in to_nodes:
                    transposed.setdefault(to_node, []).append(from_node)
            return transposed

        visited = [False] * n
        stack = []

        # Step 1.
        for i in xrange(n):
            if not visited[i]:
                toposort(i, visited, stack, graph)

        # Step 2.
        transposed = transpose_graph(graph)
        # Step 3.
        visited = [False] * n
        while stack:
            node = stack.pop()
            if not visited[node]:
                # Check node has no unvisited neighbors.
                to_nodes = transposed.get(node, [])
                for to_node in to_nodes:
                    if not visited[to_node]:
                        return False
                visited[node] = True
        return True


def main():
    sol = Solution()
    assert sol.canFinish(10, [[5,8],[3,5],[1,9],[4,5],[0,2],[1,9],[7,8],[4,9]])
    assert sol.canFinish(2, [[1, 0]])
    assert sol.canFinish(3, [[2, 0], [2, 1]])

    assert not sol.canFinish(2, [[1,0],[0,1]])
    assert not sol.canFinish(100, [[6,27],[83,9],[10,95],[48,67],[5,71],[18,72],[7,10],[92,4],[68,84],[6,41],[82,41],[18,54],[0,2],[1,2],[8,65],[47,85],[39,51],[13,78],[77,50],[70,56],[5,61],[26,56],[18,19],[35,49],[79,53],[40,22],[8,19],[60,56],[48,50],[20,70],[35,12],[99,85],[12,75],[2,36],[36,22],[21,15],[98,1],[34,94],[25,41],[65,17],[1,56],[43,96],[74,57],[19,62],[62,78],[50,86],[46,22],[10,13],[47,18],[20,66],[83,66],[51,47],[23,66],[87,42],[25,81],[60,81],[25,93],[35,89],[65,92],[87,39],[12,43],[75,73],[28,96],[47,55],[18,11],[29,58],[78,61],[62,75],[60,77],[13,46],[97,92],[4,64],[91,47],[58,66],[72,74],[28,17],[29,98],[53,66],[37,5],[38,12],[44,98],[24,31],[68,23],[86,52],[79,49],[32,25],[90,18],[16,57],[60,74],[81,73],[26,10],[54,26],[57,58],[46,47],[66,54],[52,25],[62,91],[6,72],[81,72],[50,35],[59,87],[21,3],[4,92],[70,12],[48,4],[9,23],[52,55],[43,59],[49,26],[25,90],[52,0],[55,8],[7,23],[97,41],[0,40],[69,47],[73,68],[10,6],[47,9],[64,24],[95,93],[79,66],[77,21],[80,69],[85,5],[24,48],[74,31],[80,76],[81,27],[71,94],[47,82],[3,24],[66,61],[52,13],[18,38],[1,35],[32,78],[7,58],[26,58],[64,47],[60,6],[62,5],[5,22],[60,54],[49,40],[11,56],[19,85],[65,58],[88,44],[86,58]])


if __name__ == '__main__':
    main()
