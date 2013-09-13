/*Stringly_Conncted_Components

Wiki for Kosaraju's algorithm::
http://en.wikipedia.org/wiki/Kosaraju%27s_algorithm
*/

import java.util.*;

public class Strongly_Connected_Components {

	/**
	 * A directed graph is strongly connected if there is a path between all
	 * pairs of vertices. A strongly connected component (SCC) of a directed
	 * graph is a maximal strongly connected subgraph.
	 */
	public static void main(String[] args) {
		SCCGraph g = new SCCGraph(5);
		// 1 --> 0 ---> 3
		// ^   /        |
		// |  / 	    |
		// | /		    \/
		// 2<	    	4
	    g.addEdge(1, 0);
	    g.addEdge(0, 2);
	    g.addEdge(2, 1);
	    g.addEdge(0, 3);
	    g.addEdge(3, 4);
	    g.printSCC();
	}
}

class SCCGraph {
	int V;
	ArrayList<ArrayList<Integer>> adj; // Use adjacency list to represent a graph.

	SCCGraph(int V) { // Constructor.
		this.V = V;
		this.adj = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp;
		for (int i = 0; i < V; ++i) {
			tmp = new ArrayList<Integer>();
			this.adj.add(tmp);
		}
	}

	public void printSCC() {
		boolean[] visited = new boolean[this.V];
		Stack<Integer> s = new Stack<Integer>();
		int i, v;
		// 
		for (i = 0; i < V; ++i) {
			if (!visited[i]) {
				fillOrder(i, visited, s);
			}
		}
		// System.out.println(s);
		// stdout: [1, 2, 4, 3, 0]

		//  1 <-- 0 <--- 3
		//  |   ^        ^
		//  |  /         |
		// \/ /          | 
		//  2            4
		

		// The points of reversing graph is that a reversed SCC
		// is still a SCC.
		// http://www.geeksforgeeks.org/strongly-connected-components/
		SCCGraph reversed = this.getTranspose();
		visited = new boolean[this.V];
		while (!s.isEmpty()) {
			v = s.pop();
			
			if (!visited[v]) {
				reversed.dfs(v, visited);
				// STDOUT SCC group by group.
				System.out.println();
			}
		}
	}
	
	// Helper function to add a edge to graph.
	public void addEdge(int v, int w) {
		this.adj.get(v).add(w);
	}

	// Fills Stack with vertices (in increasing order of finishing times)
	// The top element of stack has the maximum finishing time
	public void fillOrder(int v, boolean[] visited, Stack<Integer> s) {
		visited[v] = true;

		for (int i : this.adj.get(v)) {
			if (!visited[i]) { // Go on with unvisited node.
				fillOrder(i, visited, s);
			}
		}
		// After recursion is over, push itself into the stack.
		// Which mean first seen, last pushed.
		s.add(v);
	}

	// Create the reversed version of cur Graph.
	public SCCGraph getTranspose() {
		SCCGraph transposed = new SCCGraph(this.V);
		int i, j;
		ArrayList<Integer> arr;
		for (i = 0; i < this.V; ++i) {
			arr = this.adj.get(i);
			for (j = 0; j < arr.size(); ++j) {
				// In original graph node i point to node j,
				// then in reversed graph node j points to i.
				transposed.addEdge(arr.get(j), i);
			}
		}
		return transposed;
	}

	// No-brainer dfs.
	public void dfs(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print("<" + v + "> ");

		for (int i : this.adj.get(v)) {
			if (!visited[i]) {
				dfs(i, visited);
			}
		}
	}
}
