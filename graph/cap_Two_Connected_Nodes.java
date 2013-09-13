/*Two_Connected_Nodes
careercup

Given a directed graph, design an algorithm to find out whether there is a
route between two nodes
*/

import java.util.*;


public class cap_Two_Connected_Nodes {

	/*
	 * The idea is dfs. Let'e assume that it directed graph for straight example.
	 */

	public static void main(String[] args) {

		// test case 1.
		TCNGraph g1 = new TCNGraph(4);
		g1.addEdge(0, 1);
		g1.addEdge(1, 2);
		g1.addEdge(2, 1);
		g1.addEdge(3, 2);
		System.out.println(g1.isConnected(3, 1));
		System.out.println(g1.isConnected(1, 3));
	}
}


class TCNGraph {
	int V;
	ArrayList<ArrayList<Integer>> adj;

	public TCNGraph(int v) {
		this.V = v;
		this.adj = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp;
		for (int i = 0; i < this.V; ++i) {
			tmp = new ArrayList<Integer>();
			this.adj.add(tmp);
		}
	}

	public void addEdge(int v, int w) {
		this.adj.get(v).add(w);
	}

	public boolean dfs(int root, int target, boolean[] visited) {
		visited[root] = true;
		for (int v : this.adj.get(root)) {
			if (v == target || (!visited[v] && dfs(v, target, visited))) {
				return true;
			}
		}
		return false;
	}

	public boolean isConnected(int a, int b) {
		boolean[] visited = new boolean[this.V];
		return dfs(a, b, visited);
	}
}
