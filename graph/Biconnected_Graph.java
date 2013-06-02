import java.util.*;

public class Biconnected_Graph {
	/**
	 * An undirected graph is called Biconnected if there are two disjoint paths
	 * between any two vertices. 
	 * In a Biconnected Graph, there is a simple cycle
	 * through any two vertices. A connected graph is Biconnected if it is
	 * connected and doesn’t have any Articulation Point. We mainly need to
	 * check two things in a graph. 
	 * 1) The graph is connected.
	 * 2) There is not articulation point in graph.
	 * 
	 * */
	public static void main(String[] args) {
		BCGraph g1 = new BCGraph(2);
		g1.addEdge(0, 1);
		System.out.println(g1.isBC());
		BCGraph g2 = new BCGraph(5);
		g2.addEdge(1, 0);
		g2.addEdge(0, 2);
		g2.addEdge(2, 1);
		g2.addEdge(0, 3);
		g2.addEdge(3, 4);
		g2.addEdge(2, 4);
		System.out.println(g2.isBC());
		BCGraph g3 = new BCGraph(3);
		g3.addEdge(0, 1);
		g3.addEdge(1, 2);
		System.out.println(g3.isBC());
		BCGraph g4 = new BCGraph(5);
		g4.addEdge(1, 0);
		g4.addEdge(0, 2);
		g4.addEdge(2, 1);
		g4.addEdge(0, 3);
		g4.addEdge(3, 4);
		System.out.println(g4.isBC());
		BCGraph g5 = new BCGraph(3);
		g5.addEdge(0, 1);
		g5.addEdge(1, 2);
		g5.addEdge(2, 0);
		System.out.println(g5.isBC());
	}

}

class BCGraph {
	int V;
	ArrayList<ArrayList<Integer>> adj;
	int time;

	BCGraph(int V) {
		this.V = V;
		this.adj = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < this.V; ++i) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			this.adj.add(tmp);
		}
		this.time = 0;
	}

	public boolean isBCUtil(int u, boolean[] visited, int[] disc, int[] parent,
			int[] low) {
		visited[u] = true;
		disc[u] = low[u] = ++this.time;
		int kids = 0;

		for (int v : this.adj.get(u)) {
			if (!visited[v]) {
				parent[v] = u;
				++kids;

				if (isBCUtil(v, visited, disc, parent, low)) {
					return true;
				}

				low[u] = Math.min(low[u], low[v]);

				if (parent[u] == -1 && kids > 1) {
					return true;
				}
				if (parent[u] != -1 && low[v] >= disc[u]) {
					return true;
				}
			} else if (parent[u] != v) {
				low[u] = Math.min(low[u], disc[v]);
			}
		}
		return false;
	}

	public boolean isBC() {
		boolean[] visited = new boolean[this.V];
		int[] disc = new int[this.V];
		int[] parent = new int[this.V];
		int[] low = new int[this.V];

		Arrays.fill(disc, -1);

		if (!isBCUtil(0, visited, disc, parent, low)) {
			return false;
		}

		int i;
		for (i = 0; i < this.V; ++i) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}

	public void addEdge(int v, int w) {
		// add both directions.
		this.adj.get(v).add(w);
		this.adj.get(w).add(v);
	}
}
