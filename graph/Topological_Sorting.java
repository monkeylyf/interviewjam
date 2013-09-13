/*Topological Sorting
geeksforgeeks

http://www.geeksforgeeks.org/topological-sorting/
*/

import java.util.*;

public class Topological_Sorting {

	public static void main(String[] args) {
		// Test case 1.
		Graph graph = new Graph(6);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.topologySort();
		// Test case 2.
		Graph g = new Graph(8);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 7);
		graph.addEdge(3, 5);
		graph.addEdge(3, 6);
		graph.addEdge(3, 7);
		graph.addEdge(4, 6);
		g.topologySort();
	}
}


class Graph {
	int V;
	ArrayList<ArrayList<Integer>> adj;
	
	Graph(int V) { // Constructor.
		this.V = V;
		this.adj = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < V; ++i) {
			ArrayList<Integer> dummy = new ArrayList<Integer>();
			this.adj.add(dummy);
		}
	}
	
	public void topologySort() {
		Stack<Integer> s = new Stack<Integer>();
		boolean[] visited = new boolean[this.V];
		for (int i = this.V - 1; i >= 0; --i) { // Iteration order doesn't matter here.
			if (!visited[i]) {
				next(i, visited, s);
			}
		}
		// stdout order.
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
		System.out.println();
	}
	
	private void next(int i, boolean[] visited, Stack<Integer> s) {
		visited[i] = true;
		//System.out.println("Seting node " + i + " as visited");
		
		for (int v : this.adj.get(i)) {
			// for each node, keep dfs util there is not next unvisited node.
			// That's the last we want to print. All push it to stack.
			if (!visited[v]) {
				next(v, visited, s);
			}
		}
		
		//System.out.println("Putting node " + i + " into stack");
		s.push(i);
	}
 	
	public void addEdge(int v, int w) {
		this.adj.get(v).add(w);
	}
	
	public String toString() {
		return this.adj.toString();
	}
}
