/*Find_Min_STCut_In_Flow_Network
geeksforgeeks
*/

import java.util.*;

public class Find_Min_STCut_In_Flow_Network {

	/*
	 * In a flow network, an s-t cut is a cut that requires the source ‘s’ and
	 * the sink ‘t’ to be in different subsets, and it consists of edges going
	 * from the source’s side to the sink’s side. The capacity of an s-t cut is
	 * defined by the sum of capacity of each edge in the cut-set.
	 * Wiki: http://en.wikipedia.org/wiki/Cut_(graph_theory)
	 * Wiki: http://en.wikipedia.org/wiki/Max-flow_min-cut_theorem
	 */
	public static void main(String[] args) {
		// test case 1.
		int[][] graph = { { 0, 16, 13, 0, 0, 0 }, { 0, 0, 10, 12, 0, 0 },
				{ 0, 4, 0, 0, 14, 0 }, { 0, 0, 9, 0, 0, 20 },
				{ 0, 0, 0, 7, 0, 4 }, { 0, 0, 0, 0, 0, 0 } };
		System.out.println(minCut(graph, 0, 5));
	}

	public static int minCut(int[][] graph, int src, int dest) {
		int V = graph.length, acc = 0, u, v, flow_path;
		int[] parents = new int[V];
		// Copy graph to residual graph.
		int[][] residualGraph = new int[V][V];
		for (u = 0; u < V; ++u) {
			residualGraph[u] = Arrays.copyOfRange(graph[u], 0, V);
		}

		// Augment the flow while there is a path from source to sink.
		while (bfs(residualGraph, src, dest, parents)) {
			flow_path = Integer.MAX_VALUE;
			// backtracking.
			for (v = dest; v != src; v = parents[v]) {
				u = parents[v];
				flow_path = Math.min(flow_path, residualGraph[u][v]);
			}
			// updating residual graph.
			for (v = dest; v != src; v = parents[v]) {
				u = parents[v];
				residualGraph[u][v] -= flow_path;
				residualGraph[v][u] += flow_path;
			}
		}
		// Flow is maximum now, find vertices reachable from src.
		boolean[] visited = new boolean[V];
		dfs(residualGraph, src, visited);
		for (u = 0; u < V; ++u) {
			for (v = 0; v < V; ++v) {
				if (visited[u] && !visited[v] && graph[u][v] > 0) {
					System.out.println("Cut " + u + " - " + v);
					acc += graph[u][v];
				}
			}
		}
		return acc;
	}

	// Standard bfs to find out if there is a path from src to dest.
	public static boolean bfs(int[][] residualGraph, int src, int dest,
			int[] parents) {
		int V = residualGraph.length;
		boolean[] visited = new boolean[V];
		int cur, i;
		Queue<Integer> next = new LinkedList<Integer>();
		next.offer(src);
		visited[src] = true;
		parents[src] = -1;
		while (!next.isEmpty()) {
			cur = next.poll();
			for (i = 0; i < V; ++i) {
				if (!visited[i] && residualGraph[cur][i] > 0) {
					next.offer(i);
					parents[i] = cur; // Backtracking.
					visited[i] = true;
				}
			}
		}
		return visited[dest];
	}

	// Standard dfs.
	public static void dfs(int[][] residualGraph, int src, boolean[] visited) {
		visited[src] = true;
		for (int i = 0; i < residualGraph.length; ++i) {
			if (residualGraph[src][i] > 0 && !visited[i]) {
				dfs(residualGraph, i, visited);
			}
		}
	}
}
