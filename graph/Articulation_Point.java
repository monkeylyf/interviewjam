import java.util.*;


class Articulation_Point {

	/**
	 * A vertex in an undirected connected graph is an articulation point (or
	 * cut vertex) iff removing it (and edges through it) disconnects the graph.
	 * Articulation points represent vulnerabilities in a connected network –
	 * single points whose failure would split the network into 2 or more
	 * disconnected components. They are useful for designing reliable networks.
	 */

	/**
	 * No brainer: A simple approach is to one by one remove all vertices and
	 * see if removal of a vertex causes disconnected graph. Following are steps
	 * of simple approach for connected graph.
	 * 
	 * 1) For every vertex v, do following …..a) Remove v from graph ..…b) See
	 * if the graph remains connected (We can either use BFS or DFS) …..c) Add v
	 * back to the graph
	 * 
	 * Time complexity of above method is O(V*(V+E)) for a graph represented
	 * using adjacency list.
	 */
	public static void main(String[] args) {
		APGraph g1 = new APGraph(5);
		// 1 -- 0 -- 3
		// |   /     |
		// | /       |
		// 2         4
		g1.addEdge(1, 0);
	    g1.addEdge(0, 2);
	    g1.addEdge(2, 1);
	    g1.addEdge(0, 3);
	    g1.addEdge(3, 4);
	    g1.AP();
	    //
	    APGraph g2 = new APGraph(5);
	    g2.addEdge(0, 1);
	    g2.addEdge(1, 2);
	    g2.addEdge(2, 3);
	    g2.AP();
	    //
	    APGraph g3 = new APGraph(7);
	    g3.addEdge(0, 1);
	    g3.addEdge(1, 2);
	    g3.addEdge(2, 0);
	    g3.addEdge(1, 3);
	    g3.addEdge(1, 4);
	    g3.addEdge(1, 6);
	    g3.addEdge(3, 5);
	    g3.addEdge(4, 5);
	    g3.AP();
	}
}


class APGraph {
	int V;
	ArrayList<ArrayList<Integer>> adj;
	int time;

	APGraph(int V) { // Constructor.
		this.V = V;
		this.adj = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp;
		for (int i = 0; i < V; ++i) { // Init adj list.
			tmp = new ArrayList<Integer>();
			this.adj.add(tmp);
		}
		this.time = 0; // dfs #.
	}
	
	public void APUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent, boolean[] ap) {
		int children = 0;
		visited[u] = true;
		disc[u] = low[u] = ++this.time;
		
		for (int v : this.adj.get(u)) {
			if (!visited[v]) {
				// Pre-order.
				children += 1;
				parent[v] = u;

				APUtil(v, visited, disc, low, parent, ap);

			    // Post-order.
				low[u] = Math.min(low[u], low[v]);

				if (parent[u] == -1 && children > 1) {
					ap[u] = true;
				}
				if (parent[u] != -1 && low[v] >= disc[u]) {
					ap[u] = true;
				}
			} else if (v != parent[u]) {
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}
	
	public void AP() {
		/* :param boolean[] visited:
		 * :param boolean[] ap: Store articulation points.
		 * :param int[] disc: Stores discovery times of visited vertices.
		 * :param int[] low: is the lowest dfs# of any vertex that is either
		                     in the dfs subtree rooted at v (including v itself) or 
							 connected to a vertex in that subtree by a back edge.
		 * :param int[] parent: Stores parent vertices in DFS tree.
		 */

		boolean[] visited = new boolean[this.V];
		boolean[] ap = new boolean[this.V];
		int[] disc = new int[this.V];
		int[] low = new int[this.V];
		int[] parent = new int[this.V];

		Arrays.fill(parent, -1);
		int i;
		// Call the recursive helper function to find articulation points
	    // in DFS tree rooted with vertex 'i'.
		for (i = 0; i < this.V; ++i) {
			if (!visited[i]) {
				APUtil(i, visited, disc, low, parent, ap);
			}
		}
		// stdout AP node.
		for (i = 0; i < this.V; ++i) {
			if (ap[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public void addEdge(int v, int w) {
		// Undirected graph. Add both directions.
		this.adj.get(v).add(w);
		this.adj.get(w).add(v);
	}
}
