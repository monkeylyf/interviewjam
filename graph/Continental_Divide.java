/**
 * Continental_Divide.
 *
 * Given a geo map, represented as a two-dimension matrix with each
 * element as the height value,
 *
 * Define both left and upper borders adjacent to pacific ocean, and both
 * right and down boaders adjacent to atlantic ocean. Also define the
 * continental divide as a location, that have flows from itself to both
 * pacific ocean and atlantic ocean. At last, define a flow, think it as
 * water flow, that can only flow from a to b, where a and b are adjacent and
 * and geo[a] is no less than geo[b].
 *
 * Question: Find all qualified continental divides.
 *
 * A good candidate will ask about edge cases for upper-right corner
 * and down-left corner. Define it as you want it be to.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Continental_Divide {

  /**
   * The idea is pretty straight-forward.
   *
   * BFS from both of the borders and find the intersection of points
   * that can flow to both of the borders.
   */
  public static void main(String[] args) {
    Continental_Divide solution = new Continental_Divide();
    // Geo.
    int[][] geo = new int[][] {{3, 2, 6, 8, 1},
                               {7, 2, 3, 2, 1},
                               {4, 5, 4, 6, 8},
                               {2, 7, 5, 3, 5},
                               {1, 1, 1, 1, 1},
    };

    System.out.println(solution.solve(geo));
  }

  public List<Point> solve(int[][] geo) {
    int n = geo.length;
    int m = geo[0].length;

    // Find all points reachable to pacific ocean.
    Queue<Point> pacificBoader = new LinkedList<Point>();
    // Upper boader.
    for (int i = 0; i < m; ++i) {
      pacificBoader.add(new Point(0, i));
    }
    // Left boader. Left-down corner does not belong to pacific.
    for (int i = 0; i < n - 1; ++i) {
      pacificBoader.add(new Point(i, 0));
    }

    boolean[][] reachableToPacific = bfs(geo, pacificBoader);

    // Find all points reachable to atlantic ocean.
    Queue<Point> atlanticBoader = new LinkedList<Point>();
    // Down boader.
    for (int i = 0; i < m; ++i) {
      atlanticBoader.add(new Point(n - 1, i));
    }
    // Right boader. Upper-right corner does not belong to altlantic.
    for (int i = 1; i < n; ++i) {
      atlanticBoader.add(new Point(i, m - 1));
    }
    boolean[][] reachableToAtlantic = bfs(geo, atlanticBoader);

    return intersect(reachableToPacific, reachableToAtlantic);
  }

  /**
   * Find the set of points that can flow to both pacific and atlantic.
   */
  private List<Point> intersect(boolean[][] a, boolean[][] b) {
    List<Point> retval = new ArrayList<Point>();

    for (int i = 0; i < a.length; ++i) {
      for (int j = 0; j < a[i].length; ++j) {
        if (a[i][j] && b[i][j]) {
          retval.add(new Point(i, j));
        }
      }
    }

    return retval;
  }

  private boolean[][] bfs(int[][] geo, Queue<Point> q) {
    int n = geo.length;
    int m = geo[0].length;

    boolean[][] visited = new boolean[n][m];

    while (!q.isEmpty()) {
      Point p = q.poll();
      visited[p.x][p.y] = true;

      // Check uppper.
      if (p.x - 1 >= 0 && !visited[p.x - 1][p.y] && geo[p.x][p.y] <= geo[p.x - 1][p.y]) {
        q.add(new Point(p.x - 1, p.y));
      }
      // Check down.
      if (p.x + 1 < n && !visited[p.x + 1][p.y] && geo[p.x][p.y] <= geo[p.x + 1][p.y]) {
        q.add(new Point(p.x + 1, p.y));
      }
      // Check left.
      if (p.y - 1 >= 0 && !visited[p.x][p.y - 1] && geo[p.x][p.y] <= geo[p.x][p.y - 1]) {
        q.add(new Point(p.x, p.y - 1));
      }
      // Check right.
      if (p.y + 1 < m && !visited[p.x][p.y + 1] && geo[p.x][p.y] <= geo[p.x][p.y + 1]) {
        q.add(new Point(p.x, p.y + 1));
      }
    }

    return visited;
  }


  /**
   * Point class.
   */
  private static class Point {

    public final int x;
    public final int y;

    public Point(final int x, final int y) {
      this.x = x;
      this.y = y;
    }

    public String toString() {
      return "<" + this.x + ", " + this.y + ">";
    }
  }
}
