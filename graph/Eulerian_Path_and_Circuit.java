/*Eulerian_Path_and_Circuit
geeksforgeeks

http://en.wikipedia.org/wiki/Eulerian_path

Eulerian Cycle: An undirected graph has Eulerian cycle if following two
conditions are true.
a) All vertices with non-zero degree are connected. We don’t care about vertices
with zero degree because they don’t belong to Eulerian Cycle or Path (we only
consider all edges).
b)All vertices have even degree.

Eulerian Path: An undirected graph has Eulerian Path if following two
conditions are true.
a) Same as condition (a) for Eulerian Cycle
b) If zero or two vertices have odd degree and all other vertices have even
degree. Note that only one vertex with odd degree is not possible in an
undirected graph (sum of all degrees is always even in an undirected
graph)

Note that a graph with no edges is considered Eulerian because there are
no edges to traverse.
*/

import java.util.*;


public class Eulerian_Path_and_Circuit {

    /**
     */
    public static void main(String[] args) {
        //test case 1.
        EGraph g1 = new EGraph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        testHelper(g1.isEulerian());
        
        //test case 2.
        EGraph g2 = new EGraph(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        g2.addEdge(4, 0);
        testHelper(g2.isEulerian());
        //test case 3.
        EGraph g3 = new EGraph(5);
        g3.addEdge(1, 0);
        g3.addEdge(0, 2);
        g3.addEdge(2, 1);
        g3.addEdge(0, 3);
        g3.addEdge(3, 4);
        g3.addEdge(1, 3);
        testHelper(g3.isEulerian());
        // test case 4.
        EGraph g4 = new EGraph(3);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(2, 0);
        testHelper(g4.isEulerian());
        // test case 5.
        EGraph g5 = new EGraph(5);
        testHelper(g5.isEulerian());
    }
    
    public static void testHelper(int res) {
        if (res == 0) {
            System.out.println("Graph is not Eulerian\n");
        } else if (res == 1) {
            System.out.println("Graph has a Euler path\n");
        } else {
            System.out.println("Graph has a Euler cycle\n");
        }
    }

}


class EGraph {
    int V;
    ArrayList<ArrayList<Integer>> adj;
    
    EGraph(int v) {
        this.V = v;
        this.adj = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> init;
        for (int i = 0; i < v; ++i) {
            init = new ArrayList<Integer>();
            this.adj.add(init);
        }
    }
    
    public void addEdge(int v, int w) {
        this.adj.get(v).add(w);
        this.adj.get(w).add(v);
    }
    
    public int isEulerian() {
        if (!isConnected()) {
            return 0;
        }
        
        int odd = 0, i;
        for (i = 0; i < this.V; ++i) {
            if (this.adj.get(i).size() % 2 == 1) {
                ++odd;
            }
        }
        if (odd > 2) {
            return 0;
        }
		// If odd count is 2, then semi-eulerian.
		// If odd count is 0, then eulerian
		// Note that odd count can never be 1 for undirected graph
        return (odd == 2) ? 1 : 2;
    }
    
    public boolean isConnected() {
        int i;
        for (i = 0; i < this.V; ++i) {
            if (this.adj.get(i).size() != 0) {
                break;
            }
        }
        if (i == this.V) {
            // Definition of Eulerian Path: graph with no edges fits the definition.
            return true;
        }
        boolean[] visited = new boolean[this.V];
        dfs(i, visited);
        for (i = 0; i < this.V; ++i) {
            if (visited[i] == false && this.adj.get(i).size() != 0) {
                // if a vertex is not visited and it has edges, then 
                // this graph is not connected.
                return false;
            }
        }
        return true;
    }
    
    public void dfs(int i, boolean[] visited) {
        visited[i] = true;
        for (int j : this.adj.get(i)) {
            if (!visited[j]) {
                dfs(j, visited);
            }
        }
    }
}
