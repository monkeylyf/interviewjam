"""Course schedule II

leetcode

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to
first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, return the
ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them. If
it is impossible to finish all courses, return an empty array.

For example:
2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have
finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have
finished both courses 1 and 2. Both courses 1 and 2 should be taken after you
finished course 0. So one correct course order is [0,1,2,3]. Another correct
ordering is[0,2,1,3].
"""


class Solution:

    """99% based on leetcode_Course_Schedule.py. Seems the overkill is worthy."""

    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        # Build adj list as graph.
        graph = {}

        for edge in prerequisites:
            node_to = edge[0]
            node_from = edge[1]
            graph.setdefault(node_from, []).append(node_to)

        # Cycle dection in DAG.
        visited = [False] * numCourses

        return self.order(graph, numCourses)

    def order(self, graph, n):
        """Return order if there is one

        I might be overkilling this interview question here(might not) but it
        is a wonderful practice as in general graph topic, SCC and Toposort.

        The general idea to use scc/toposort to detect cyclic graph is:
        1. Get the toposort order of all nodes, including those in sub-graphs
        2. Transpose the graph
        3. Given the toposort order, if every node has no unchecked neighbors
           it points to, then it's an acyclic graph.

        :param graph: dict, adj list
        :param graph: int, number of nodes
        :param return: list, order of courses to take
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

        topo_order = stack[::-1]
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
                        return []
                visited[node] = True
        return topo_order


def main():
    sol = Solution()
    assert sol.findOrder(4, [[1, 0], [2, 0], [3, 1], [3, 2]]) == [0,2,1,3]


if __name__ == '__main__':
    main()
