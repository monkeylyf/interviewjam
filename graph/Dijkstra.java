/*Dijkstra
geeksforgeeks

Shortest Path Alogorithm.
*/

import java.util.*;

public class Dijkstra {

	public static void main(String[] args) {
		int[][] graph = {
				{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 0, 10, 0, 2, 0, 0},
                {0, 0, 0, 14, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
               };
		dijkstra(graph, 0);
	}
	
	public static void dijkstra(int[][] graph, int src) {
		int dim = graph.length;
		boolean[] sptSet = new boolean[dim]; // sptSet[i] represents is i has been treated as local min
		int[] dist = new int[dim]; // dijkstra status.
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		
		int count, v, u;
		
		for (count = 0; count < dim - 1; ++count) {
			u = minDistance(dist, sptSet); // Get the min dist of cur status.
			sptSet[u] = true; // Mark as visited.
			for (v = 0; v < dim; ++v) {
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE &&
						dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v]; // update local min
				}
			}
		}
		// stdout results.	
		System.out.println("Vertes  Distance from Source");
		for (int i = 0; i < dim; ++i) {
			System.out.println(i + "\t\t" + dist[i]);
		}
	}

	// Given the cur dijkstra status. Find the min distance of cur status.
	public static int minDistance(int[] dist, boolean[] sptSet) {
		int min = Integer.MAX_VALUE, min_index = 0, v;
		for (v = 0; v < dist.length; ++v) {
			if (!sptSet[v] && dist[v] < min) {
				min = dist[v];
				min_index = v;
			}
		}
		return min_index;
	}
}
