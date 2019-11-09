import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Queue;
import java.util.Set;

public class HammerItBabe {

  private static final int[][] direction = {
    new int [] {0, 1, 0, -1},
    new int [] {1, 0, -1, 0}};

  public static void main(String[] args) {
    int[][] maze = new int[][]{
      new int[]{0, 0, 1, 1, 1, 1, 0, 1, 1, 1},
      new int[]{1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
      new int[]{1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
      new int[]{0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
      new int[]{1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
      new int[]{1, 0, 1, 0, 1, 1, 0, 1, 0, 0},
      new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
      new int[]{1, 0, 1, 1, 1, 1, 0, 0, 1, 1},
      new int[]{1, 1, 0, 0, 0, 0, 1, 0, 0, 1}};
    System.out.println(hammerIt(maze, new Point(0, 0), new Point(8, 8)));
  }

  public static List<Point> hammerIt(final int[][] maze, final Point start, final Point end) {
    final int n = maze.length;
    final int m = maze[0].length;
    final Set<Point> wallsFromStart = new HashSet<>();
    final boolean reachEndWithoutUsingHammer = color(maze, n, m, start, end, wallsFromStart);
    final Set<Point> commonWalls;
    if (!reachEndWithoutUsingHammer) {
      final Set<Point> wallsFromEnd = new HashSet<>();
      color(maze, n, m, end, start, wallsFromEnd);
      wallsFromEnd.retainAll(wallsFromStart);
      commonWalls = wallsFromEnd;
    } else {
      // If end is reachable from start without breaking wall.
      commonWalls = Collections.emptySet();
    }

    return getShortestPath(maze, n, m, start, end, commonWalls);
  }

  /**
   * BFS to color reachable area and find adjacent walls.
   *
   * Kids stuff.
   */
  private static boolean color(final int[][] maze, final int n, final int m,
      final Point start, final Point end, final Set<Point> walls) {
    final Queue<Point> queue = new LinkedList<>(Arrays.asList(start));
    boolean isEndReached = false;

    while (!queue.isEmpty() && !isEndReached) {
      final Point p = queue.remove();
      isEndReached = end.equals(p);
      final int x = p.x;
      final int y = p.y;
      maze[x][y] = -1;
      for (int i = 0; i < 4; ++i) {
        final int dx = x + direction[0][i];
        final int dy = y + direction[1][i];
        if (0 <= dx && dx < n && 0 <= dy && dy < m) {
          final int nextMove = maze[dx][dy];
          if (nextMove == -1) {
            continue;  // Already visited.
          } else if (nextMove == 0) {
            queue.add(new Point(dx, dy));
          } else if (nextMove == 1) {
            walls.add(new Point(dx, dy));
          }
        }
      }
    }
    return isEndReached;
  }

  /**
   * A slight variation of BFS to find short path from start to end.
   */
  private static List<Point> getShortestPath(final int[][] maze, final int n, final int m, final Point start,
      final Point end, final Set<Point> walls) {
    final List<Point> shortedPath = new ArrayList<>();
    final Map<Point, Point> backTrace = new HashMap<>();
    final Queue<Point> queue = new LinkedList<>(Arrays.asList(start));
    boolean isEndReached = false;

    while (!queue.isEmpty() && !isEndReached) {
      final Point p = queue.remove();
      isEndReached = end.equals(p);
      final int x = p.x;
      final int y = p.y;
      maze[x][y] = 0;
      for (int i = 0; i < 4; ++i) {
        final int dx = x + direction[0][i];
        final int dy = y + direction[1][i];
        if (0 <= dx && dx < n && 0 <= dy && dy < m) {
          final int nextMove = maze[dx][dy];
          if (nextMove == 0) {
            continue;  // Already visited.
          }
          final Point nextPoint = new Point(dx, dy);
          if ((nextMove == -1) || (nextMove == 1 && walls.contains(nextPoint))) {
            backTrace.put(nextPoint, p);
            queue.add(nextPoint);
          }
        }
      }
    }
    shortedPath.add(end);

    Point cur = end;
    while (backTrace.containsKey(cur)) {
      // FIXME: it's possible that the yielded path walks through wall more than once,
      // Need flag to make sure it only walks though the wall once.
      final Point nextStep = backTrace.get(cur);
      shortedPath.add(nextStep);
      cur = nextStep;
    }

    return shortedPath;
  }

  static class Point {

    private final int x;
    private final int y;

    Point(final int x, final int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int hashCode() {
      final int prime = 41;
      int result = 1;
      result = prime * result + this.x;
      result = prime * result + this.y;
      return result;
    }

    @Override
    public boolean equals(final Object that) {
      if (that == null) {
        return false;
      } else if (that instanceof Point) {
        final Point thatPoint = (Point) that;
        return thatPoint.x == this.x && thatPoint.y == this.y;
      } else {
        return false;
      }
    }

    @Override
    public String toString() {
      return "<" + this.x + ", " + this.y + ">";
    }
  }
}
