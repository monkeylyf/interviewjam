/*Max_Number_Of_Edge_Disjoint_Paths_Between_Two_Vertices
geeksforgeeks

Given a directed graph and two vertices in it, source ‘s’ and destination
‘t’, find out the maximum number of edge disjoint paths from s to t. Two
paths are said edge disjoint if they don’t share any edge.

http://www.geeksforgeeks.org/find-edge-disjoint-paths-two-vertices/
*/

import java.util.*;


public class Max_Number_Of_Edge_Disjoint_Paths_Between_Two_Vertices {

	/**
	 * The solution is based on max flow problem.
	 * Use residual graph to track every available path from source to sink
	 * and augment residual graph.
	 */
	
	public static void main(String[] args) {
		// Test case 1.
		int[][] graph = new int[][]
		  { {0, 1, 1, 1, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 1, 0},
			{0, 0, 0, 0, 0, 0, 1, 0},
			{0, 0, 1, 0, 0, 0, 0, 1},
			{0, 1, 0, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 1, 0, 1},
			{0, 0, 0, 0, 0, 0, 0, 0}};
		int s = 0, t = 7;
		solve(graph, s, t);
	}

	public static void solve(int[][] graph, int s, int t) {
		int n = graph.length;
		int[] parent = new int[n];
		int u, v;

		int rGraph[][] = new int[n][n];
		// Copy graph.
		for (u = 0; u < n; ++u) {
			for (v = 0; v < n; ++v) {
				rGraph[u][v] = graph[u][v];	
			}	
		}

		int maxFlow = 0, pathFlow;

		while (bfs(rGraph, s, t, parent)) {
			pathFlow = Integer.MAX_VALUE;
			for (v = t; v != s; v = parent[v]) {
				u = parent[v];
				// This is overkill since it's not a real flow graph.
				// Capacity is always 1.
				pathFlow = Math.min(pathFlow, rGraph[u][v]);
			}

			for (v = t; v !=s; v = parent[v]) {
				u = parent[v];
				rGraph[u][v] -= pathFlow;
				rGraph[v][u] += pathFlow;
				System.out.print(v + "<-");
			}
			System.out.println(s);

			maxFlow += pathFlow; // Accumulate paths.
		}
		System.out.println(maxFlow);
	}

	// Helper function to do dfs.
	// Return boolean if there is a path available from source to sink.
	// Modify parent to track the path.
	private static boolean bfs(int[][] graph, int s, int t, int parent[]) {
		int n = graph.length;
		boolean[] visited = new boolean[n];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s] = true;
		int vertice;

		while (!q.isEmpty()) {
			vertice = q.poll();

			for (int i = 0; i < n; ++i) {
				if (!visited[i] && graph[vertice][i] > 0) {
					q.add(i);
					parent[i] = vertice;
					visited[i] = true;
				}	
			}
		}

		return visited[t] == true;
	}
}
