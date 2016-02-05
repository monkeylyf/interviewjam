"""Reconstruct itinerary
leetcode

Given a list of airline tickets represented by pairs of departure and arrival
airports [from, to], reconstruct the itinerary in order. All of the tickets
belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that
has the smallest lexical order when read as a single string. For example, the
itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets may form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But
it is larger in lexical order.
"""

from collections import defaultdict

class Solution(object):
    def findItinerary(self, tickets):
        """Build graph and traversal.

        I need to admit that I didn't read the question carefully. It's assumed
        that the itinerary *always* starts from 'JFK' and I missed that.

        First a graph needs to be built in the form of adjacent list.
        Then, yy original approach was to find the starting point or points of
        the graph. In order to achieve that, indegree/outdegree diff is needed
        because there are two cases:
        1. The graph is kinda cyclic so i/o diff for all nodes are all 0. In
           this case we start with the airport with lexicographically smallest
           IATA code.
        2. The graph is guaranteed to have a valid itinerary so there *MUST* be
           one node with i/o diff as -1. This is the starting point.
        3. Traverse the graph with dfs.

        The code below handels more complicated cases. Might be over-caucious
        for this question but with more thorough thinking within it. ;)

        :type tickets: List[List[str]]
        :rtype: List[str]
        """
        def dfs(node, itinerary, visited, graph, n):
            """"""
            if n == 0:
                return True

            destinations = graph.get(node)
            if not destinations:
                return False

            dest_visited = visited[node]
            for i, destination in enumerate(destinations):
                if not dest_visited[i]:
                    itinerary.append(destination)
                    dest_visited[i] = True
                    if dfs(destination, itinerary, visited, graph, n - 1):
                        return True
                    dest_visited[i] = False
                    itinerary.pop()
            return False

        graph = defaultdict(list)
        in_out_diff = defaultdict(int)
        for departure, destination in tickets:
            graph[departure].append(destination)
            in_out_diff[destination] += 1
            in_out_diff[departure] -= 1

        roots = [i for i, j in in_out_diff.iteritems() if j == -1]
        if len(roots) == 0:
            root = min(graph.keys())
        elif len(roots) == 1:
            root = roots[0]
        else:
            raise ValueError('wtf')

        visited = {}
        root = 'JFK' # Ok, go with what the OJ wants.

        for departure, destinations in graph.iteritems():
            destinations.sort()
            visited[departure] = [False] * len(destinations)

        itinerary = [root]
        if not dfs(root, itinerary, visited, graph, len(tickets)):
            raise ValueError('wtf')
        return itinerary


def main():
    sol = Solution()
    tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    assert sol.findItinerary(tickets) == ["JFK","ATL","JFK","SFO","ATL","SFO"]

    tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
    assert sol.findItinerary(tickets) == ["JFK", "MUC", "LHR", "SFO", "SJC"]

    tickets = [["JFK","ATL"],["ATL","JFK"]]
    assert sol.findItinerary(tickets) == ['JFK', 'ATL', 'JFK']

    tickets = [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
    assert sol.findItinerary(tickets) == ["JFK","NRT","JFK","KUL"]




if __name__ == '__main__':
    main()
