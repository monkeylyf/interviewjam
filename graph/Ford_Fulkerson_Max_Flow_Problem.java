/*Ford_Fulkerson_Max_Flow_Problem
Geeksforgeeks

Network flow.
Wiki link: http://en.wikipedia.org/wiki/Flow_network
*/

import java.util.*;


public class Ford_Fulkerson_Max_Flow_Problem {
	
	/*
	 * Residual Graph of a flow network is a graph which indicates additional
	 * possible flow. If there is a path from source to sink in residual graph,
	 * then it is possible to add flow. Every edge of a residual graph has a
	 * value called residual capacity which is equal to original capacity of the
	 * edge minus current flow. Residual capacity is basically the current
	 * capacity of the edge. Let us now talk about implementation details.
	 * Residual capacity is 0 if there is no edge between to vertices of
	 * residual graph. We can initialize the residual graph as original graph as
	 * there is no initial flow and initially residual capacity is equal to
	 * original capacity. To find an augmenting path, we can either do a BFS or
	 * DFS of the residual graph. We have used BFS in below implementation.
	 * Using BFS, we can find out if there is a path from source to sink. BFS
	 * also builds parent[] array. Using the parent[] array, we traverse through
	 * the found path and find possible flow through this path by finding
	 * minimum residual capacity along the path. We later add the found path
	 * flow to overall flow. The important thing is, we need to update residual
	 * capacities in the residual graph. We subtract path flow from all edges
	 * along the path and we add path flow along the reverse edges We need to
	 * add path flow along reverse edges because may later need to send flow in
	 * reverse direction.
	 */

	public static void main(String[] args) {
		Ford_Fulkerson case1 = new Ford_Fulkerson(new int[][] { {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
              });
		case1.max_flow(0, 5);
	}
}


class Ford_Fulkerson {
	private int[][] graph;
	private int V;

	// Constructor.
	Ford_Fulkerson(int[][] graph) {
		this.graph = graph;
		this.V = graph.length;
	}

	public void max_flow(int src, int dest) {
		int acc = 0, path_flow, i, j;
		int[] parents = new int[this.V];
		int[][] residualGraph = new int[this.V][this.V];	
		// Copy graph to residual graph.
		for (i = 0; i < this.V; ++i) {
			residualGraph[i] = Arrays.copyOfRange(this.graph[i], 0, this.V);
		}
	
		// Keep traversing the graph.
		while (this.bfs(residualGraph, src, dest, parents)) {
			// Backtracking the augmenting path from destination to source and find the min capacity.
			path_flow = Integer.MAX_VALUE;
			for (j = dest; j != src; j = parents[j]) {
				i = parents[j];
				System.out.print(i + " -> ");
				path_flow = Math.min(path_flow, this.graph[i][j]);
			}
			// 	
			for (j = dest; j != src; j = parents[j]) {
				i = parents[j];
				// add and substrack the min capacity to keep local equilibrium.
				residualGraph[i][j] -= path_flow; // Increase flow on forward edge.
				residualGraph[j][i] += path_flow; // Decrease flow on backwrd edge. Augmenting path found later might take reversed direction.
			}
			acc += path_flow;
		}
		System.out.println(acc);
	}

	// Either dfs or bfs works here. Check if destination is reachable from source.
	private boolean bfs(int[][] residualGraph, int src, int dest, int[] parents) {
		boolean[] visited = new boolean[this.V];
		int cur, i;
		Queue<Integer> next = new LinkedList<Integer>();
		next.offer(src);
		visited[src] = true;
		parents[src] = -1;
		
		while (!next.isEmpty()) {
			cur = next.poll();
			for (i = 0; i < this.V; ++i) {
				if (!visited[i] && residualGraph[cur][i] > 0) {
					next.offer(i);
					parents[i] = cur; // Backtracking.
					visited[i] = true;
				}
			}
		} 
		return visited[dest];
	}
	
	// Helper function
	public void printGraph() {
		for (int[] arr: this.graph) print(arr);
		System.out.println();
	}
	
	private void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
}
