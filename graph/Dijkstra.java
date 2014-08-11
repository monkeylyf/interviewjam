/**
 * Dijkstra.
 *
 * http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
 */

import java.util.Arrays;

public class Dijkstra {

  public static void main(String[] args) {
    test();
  }

  private static void test() {
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
    int len = graph.length;
    // visited[i] represents is i has been treated as local min.
    boolean[] visited = new boolean[len];

    // Init dist.
    int[] dist = new int[len];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    for (int count = 0; count < len - 1; ++count) {
      // Get the min dist of cur status.
      int u = minDistance(dist, visited);
      visited[u] = true;

      /*
       * Not sure this part of code will be hit or not.
       * Reason: in method minDistance the if condition "... && dist[v] < min"
       * will never be true if dist[v] == MAX_VALUE because init value of min
       * itself is MAX_VALUE.
       *
       * if (dist[u] == Integer.MAX_VALUE) {
       *   continue;
       * }
       */

      // If we've known the cost from src to u, update if from src to u then
      // to v costs less than known dist[u].
      for (int v = 0; v < len; ++v) {
        if (!visited[v] && graph[u][v] != 0) {
          // update local min.
          dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
        }
      }
    }

    System.out.println("Vertes Distance from Source " + src);
    for (int i = 0; i < len; ++i) {
      System.out.println(i + "\t\t" + dist[i]);
    }
  }

  /**
   * Given the cur dijkstra status, find the min distance of cur status.
   */
  public static int minDistance(int[] dist, boolean[] visited) {
    int min = Integer.MAX_VALUE;
    int min_index = 0;

    for (int v = 0; v < dist.length; ++v) {
      if (!visited[v] && dist[v] < min) {
        min = dist[v];
        min_index = v;
      }
    }

    return min_index;
  }
}
