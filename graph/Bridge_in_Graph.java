/*Bridge_in_Graph

geeksforgeeks
http://www.geeksforgeeks.org/bridge-in-a-graph/
*/

import java.util.*;

public class Bridge_in_Graph {

		/*
		An edge in an undirected connected graph is a bridge iff removing it disconnects
		the graph. For a disconnected undirected graph, definition is similar, a bridge
		is an edge removing which increases number of connected components.
		*/
	public static void main(String[] args) {
		// test case 1
		BGraph g1 = new BGraph(5);
		g1.addEdge(1, 0);
	    g1.addEdge(0, 2);
	    g1.addEdge(2, 1);
	    g1.addEdge(0, 3);
	    g1.addEdge(3, 4);
	    g1.bridge();
	    // test case 2
	    BGraph g2 = new BGraph(5);
	    g2.addEdge(0, 1);
	    g2.addEdge(1, 2);
	    g2.addEdge(2, 3);
	    g2.bridge();
	    // test case 3
	    BGraph g3 = new BGraph(7);
	    g3.addEdge(0, 1);
	    g3.addEdge(1, 2);
	    g3.addEdge(2, 0);
	    g3.addEdge(1, 3);
	    g3.addEdge(1, 4);
	    g3.addEdge(1, 6);
	    g3.addEdge(3, 5);
	    g3.addEdge(4, 5);
	    g3.bridge();
	}
}


class BGraph {
	int V;
	ArrayList<ArrayList<Integer>> adj;
	int time;
	
	BGraph(int V) { // Constructor.
		this.V = V;
		this.adj = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp;
		for (int i = 0; i < this.V; ++i) {
			tmp = new ArrayList<Integer>();
			this.adj.add(tmp);
		}
		this.time = 0;
	} // End of constructor.
	
	public void bridgeUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent) {
		visited[u] = true;
		
		disc[u] = low[u] = ++this.time;
		
		for (int v : this.adj.get(u)) {
			if (!visited[v]) {
				parent[v] = u;
				
				bridgeUtil(v, visited, disc, low, parent);
				
				low[u] = Math.min(low[u], low[v]);
				
				if (low[v] > disc[u]) {
					System.out.println(u + "---" + v);
				}
			} else if (v != parent[u]) {
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}
	
	public void bridge() {
		boolean[] visited = new boolean[this.V];
		int[] disc = new int[this.V];
		int[] low = new int[this.V];
		int[] parent = new int[this.V];
		Arrays.fill(parent, -1);
		
		for (int i = 0; i < this.V; ++i) {
			if (!visited[i]) {
				bridgeUtil(i, visited, disc, low, parent);
			}
		}
		System.out.println("===========");
	}
	
	public void addEdge(int v, int w) {
		// Add both directions.
		this.adj.get(v).add(w);
		this.adj.get(w).add(v);
	}
}
