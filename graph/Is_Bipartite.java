/*Is_Bipartite
geeksforgeeks

http://en.wikipedia.org/wiki/Graph_coloring
http://en.wikipedia.org/wiki/Bipartite_graph
*/

import java.util.*;

public class Is_Bipartite {

	/*
	 * A Bipartite Graph is a graph whose vertices can be divided into two
	 * independent sets, U and V such that every edge (u, v) either connects a
	 * vertex from U to V or a vertex from V to U. In other words, for every edge
	 * (u, v), either u belongs to U and v to V, or u belongs to V and v to U. We
	 * can also say that there is no edge that connects vertices of same set.
	 */

	// static final var to identify.
	static final int WHITE = 0;
	static final int BLACK = 1;
	static final int UNVISITED = -1;

	static final int SOURCE = 0; // Assuming bfs start with source 0.
	
	public static void main(String[] args) {
		// test case 1.
		int[][] G = new int[][] {
				{0, 1, 0, 1},
		        {1, 0, 1, 0},
		        {0, 1, 0, 1},
		        {1, 0, 1, 0}
		    };
		System.out.println(isBipartite(G, 0));
	}
	
	public static boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int colorArr[] = new int[n]; // Mark node with BLACK/WHITE/UNVISITED.
		Arrays.fill(colorArr, UNVISITED);
		colorArr[SOURCE] = BLACK;
		
		// bfs queue.
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(SOURCE);
		
		int cur, i;
		// bfs.
		while (!q.isEmpty()) {
			cur = q.poll();
			for (i = 0; i < n; ++i) {
				if (graph[cur][i] > 0 && colorArr[i] == UNVISITED) {
					colorArr[i] = (colorArr[cur] == BLACK) ? WHITE : BLACK;
					q.add(i);
				} else if (graph[cur][i] > 0 && colorArr[cur] == colorArr[i]) {
					// If there is an edge between i and cur and they are marked with
					// the same color, then it's not a bipartite.
					return false;
				}
			}
		}
		return true;
	}
}
