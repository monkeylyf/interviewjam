/**
 * Minimum_Distance_Sum_To_K_Points_In_Maze.
 *
 * Given a maze, represented as a matrix (1: wall, 0: path) and k points, find
 * the point that the sum of distances from this point to k points is minimum.
 *
 * If there are more than one point, find all of them.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Minimum_Distance_Sum_To_K_Points_In_Maze {

  private int[][] maze;
  private int n;
  private int m;

  private int[][] sum;
  private boolean[][] visited;

  public static void main(String[] args) {
    Minimum_Distance_Sum_To_K_Points_In_Maze solution = new Minimum_Distance_Sum_To_K_Points_In_Maze();
    // Maze.
    int[][] maze = new int[][] {{1, 1, 1, 1, 1, 1},
                                {1, 0, 1, 0, 0, 1},
                                {1, 0, 0, 0, 0, 1},
                                {1, 1, 1, 0, 0, 1},
                                {1, 0, 0, 0, 1, 1},
                                {1, 1, 1, 0, 0, 1},
                                {1, 0, 0, 0, 0, 1},
                                {1, 1, 1, 1, 1, 1},
    };
    // k points.
    List<Point> points = new ArrayList<Point>();
    Collections.addAll(points, new Point(1, 1), new Point(5, 4), new Point(6, 1));
    System.out.println(solution.solve(maze, points));
  }

  public List<Point> solve(int[][] maze, List<Point> points) {
    this.maze = maze;
    this.n = maze.length;
    this.m = maze[0].length;

    this.sum = new int[this.n][this.m];
    this.visited = new boolean[this.n][this.m];

    for (Point p : points) {
      this.visited = new boolean[this.n][this.m];
      bfs(p);
      printMatrix(this.sum);
      System.out.println("------------");
      // Reset visited.
    }

    return pointsWithMinimumVal(this.sum);
  }

  private List<Point> pointsWithMinimumVal(int[][] sum) {
    List<Point> ret = new ArrayList<Point>();

    int localMin = Integer.MAX_VALUE;

    for (int i = 0; i < this.n; ++i) {
      for (int j = 0; j < this.m; ++j) {
        if (sum[i][j] == 0) {
          continue;
        }
        if (sum[i][j] == localMin) {
          ret.add(new Point(i, j));
        } else if (sum[i][j] < localMin) {
          localMin = sum[i][j];
          ret = new ArrayList<Point>();
          ret.add(new Point(i, j));
        } else {
          continue;
        }
      }
    }

    return ret;
  }

  private void bfs(Point start) {
    Queue<Point> curLvl = new LinkedList<Point>();
    curLvl.add(start);

    Queue<Point> nextLvl = new LinkedList<Point>();

    int lvl = 0;

    while (!curLvl.isEmpty()) {
      Point p = curLvl.poll();

      this.visited[p.x][p.y] = true;

      // Accumulate the distance from starting point.
      this.sum[p.x][p.y] += lvl;

      // Go up.
      if (p.x - 1 >= 0 && !this.visited[p.x - 1][p.y] && this.maze[p.x - 1][p.y] != 1) {
        nextLvl.add(new Point(p.x - 1, p.y));
      }
      // Go down.
      if (p.x + 1 < this.n && !this.visited[p.x + 1][p.y] && this.maze[p.x + 1][p.y] != 1) {
        nextLvl.add(new Point(p.x + 1, p.y));
      }
      // Go left.
      if (p.y - 1 >= 0 && !this.visited[p.x][p.y - 1] && this.maze[p.x][p.y - 1] != 1) {
        nextLvl.add(new Point(p.x, p.y - 1));
      }
      // Go right.
      if (p.y + 1 < this.m && !this.visited[p.x][p.y + 1] && this.maze[p.x][p.y + 1] != 1) {
        nextLvl.add(new Point(p.x, p.y + 1));
      }

      // Next level.
      if (curLvl.isEmpty()) {
        lvl += 1;
        curLvl = nextLvl;
        nextLvl = new LinkedList<Point>();
      }
    }
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


  /**
   * helper function.
   */
  private void printMatrix(int[][] matrix) {
    for (int[] arr : matrix) {
      for (int obj : arr) {
        System.out.print(obj + " ");
      }
      System.out.println();
    }
  }
}
