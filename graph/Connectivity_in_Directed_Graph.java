/*Connectivity_in_Directed_Graph

Given a directed graph, find out whether the graph is strongly connected or not.
A directed graph is strongly connected if there is a path between any two pair
of vertices.
*/

import java.util.*;

public class Connectivity_in_Directed_Graph {

	public static void main(String[] args) {
		CGraph g1 = new CGraph(5);
		g1.addEdge(0, 1);
	    g1.addEdge(1, 2);
	    g1.addEdge(2, 3);
	    g1.addEdge(3, 0);
	    g1.addEdge(2, 4);
	    g1.addEdge(4, 2);
		System.out.println(g1.isSC());
		CGraph g2 = new CGraph(4);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		System.out.println(g2.isSC());
	}	
}


class CGraph {
	int V;
	ArrayList<ArrayList<Integer>> adj;
	
	CGraph(int v) {
		this.V = v;
		this.adj = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp;
		for (int i = 0; i < this.V; ++i) {
			tmp = new ArrayList<Integer>();
			this.adj.add(tmp);
		}
	}

	public void addEdge(int v, int w) {
		// vertice v to vertic w.
		this.adj.get(v).add(w);
	}

	public void DFSUtil(int u, boolean[] visited) {
		visited[u] = true;
		for (int v : this.adj.get(u)) {
			if (!visited[v]) {
				DFSUtil(v, visited);	
			}
		}
	}

	public boolean isConnected(CGraph inst) {
		boolean[] visited = new boolean[this.V];
		inst.DFSUtil(0, visited);
		int i;
		for (i = 0; i < inst.V; ++i) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}

	public boolean isSC() {
		return isConnected(this.getTranspose()) && isConnected(this);
	}

	public CGraph getTranspose() {
		CGraph transposed = new CGraph(this.V);
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
}
