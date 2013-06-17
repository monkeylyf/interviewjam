#
# Hexagon
#
# The map of the Hexagon circuit consists of hexagon elements. The first element
# in the center is marked as 1, and continuing in a clockwise spiral, the other
# elements are marked in ascending order up to infinity. On the map, you can
# move (connect) through the adjoining edges of the hexagon elemets. For
# example, the distance between elements 6 and 19 is two moves and the distance
# between 2 and 9 is one move. Find the distance between any two elements.

import sys

class Node:
    
    def __init__(self, val):
        self.val = val
        self.adj = []

    def __str__(self):
        return '{{{0}}}'.format(self.val)

class Hexagon:
    
    def __init__(self, root_val):
        self.root = Node(root_val)
        self.layer = 1
        self.debug = False
        self.node_num = 1
        self.max_node = None
        self.all_node = [self.root]

    def connect(self, a, b):
        # add edge to undirected graph.
        if self.debug:
            print 'connecting node:{0} with node:{1}'.format(a.val, b.val)
        a.adj.append(b)
        b.adj.append(a)

    def build_graph(self, node_num):
        def calc_layer(node_num):
            # Given number of nodes we need to build the graph, calc the which layer
            # the last node lies in
            # :param node_num: int

            # Start from layer two.
            total_layer = 1
            next_layer = 6
            total_node = 1
            while node_num >= next_layer:
                total_layer += 1
                node_num -= next_layer
                total_node += next_layer
                next_layer += 6
            return total_layer if node_num == 0 else total_layer + 1, total_node

        total_layer, self.node_num = calc_layer(node_num - 1)
        self.layer = total_layer
        if self.debug:
            print 'total layer:{0}'.format(total_layer)
        
        cur_layer = 2
        last = [self.root]
        start = 2
        end = 8
        while cur_layer <= total_layer:
            if self.debug:
                print 'Start creating nodes at layer {0}'.format(cur_layer)
            next = []
            if cur_layer == 2:
                for i in range(2, 8):
                    new_node = Node(i)
                    next.append(new_node)
                    self.connect(new_node, self.root)
                    if i == node_num:
                        self.max_node = new_node
            else:
                start = end
                end = start + (cur_layer - 1) * 6
                index = 1
                last_index = -1
                for i in range(start, end):
                    new_node = Node(i)
                    next.append(new_node)
                    if index % (cur_layer - 1) != 0:
                        self.connect(new_node, last[last_index])
                        self.connect(new_node, last[last_index + 1])
                        last_index += 1
                    else:
                        self.connect(new_node, last[last_index])

                    if i == node_num:
                        self.max_node = new_node
                    index += 1
            # skew all nodes in cur outer layer.
            if self.debug:
                print 'Start skewing cur layer'
            for i in range(len(next)):
                self.connect(next[ i - 1 ], next[i])

            cur_layer += 1
            self.all_node += next
            last = next

    def dfs(self, dest):
        def dfs_util(visited, cur, dest, cur_dist, dist):
            if self.debug:
                print 'visiting cur node: {0}, kids size: {1}'.format(cur, len(cur.adj))
            visited[cur.val] = True
            cur_dist += 1 
            if cur.val == dest:
                if self.debug:
                    print 'reach desination {0} with distance travelled {1}'.format(dest, cur_dist)
                dist[0] = min(dist[0], cur_dist) if dist[0] != 0 else cur_dist
                return
            for k in cur.adj:
                if not visited[k.val]:
                    dfs_util(visited, k, dest, cur_dist, dist)
        visited = [ False for _ in range(self.node_num + 1) ]
        dist = [0, ]
        dfs_util(visited, self.max_node, dest, 0,  dist)
        return dist[0] - 1

    def is_connected(self, node_a, node_b):
        for node in node_a.adj:
            if node is node_b:
                return True
        return False

    def min_distance(self, dist, visited):
        local_min = sys.maxint
        for i in range(len(dist)):
            if not visited[i] and dist[i] < local_min:
                ret = i
                local_min = dist[i]
        return ret

    def dijkstra(self):
        dim = len(self.all_node)
        visited = [False] * dim
        dist = [ sys.maxint ] * dim
        dist[self.max_node.val - 1] = 0

        for _ in range(dim - 1):
            u = self.min_distance(dist, visited)
            visited[u] = True
            for v in range(dim):
                if not visited[v] and self.is_connected(self.all_node[u], self.all_node[v]) and \
                    dist[u] != sys.maxint and dist[u] + 1 < dist[v]:
                    dist[v] = dist[u] + 1
        if self.debug:
            print 'Vertes  Distance from source:{0}'.format(self.max_node.val)
            for node in self.all_node:
                print '{0}\t\t{1}'.format(node.val, dist[node.val - 1])
        return dist


def checkio(data):
    a, b = data
    hexagon_inst = Hexagon(1)
    hexagon_inst.build_graph(max(a, b))
    dist = hexagon_inst.dijkstra()
    return dist[min(a, b) - 1]


def main():
    assert checkio([2, 9]) == 1, "First"
    assert checkio([9, 2]) == 1, "Reverse First"
    assert checkio([6, 19]) == 2, "Second, short way"
    assert checkio([5, 11]) == 3, "Third"
    assert checkio([13, 15]) == 2, "Fourth, One row"
    assert checkio([11, 17]) == 4, "Fifth, One more test"


if __name__ == '__main__':
    main();
