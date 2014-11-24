/**
 * codeforces_Inna_and_Dima.
 *
 * http://codeforces.com/contest/374/problem/C
 */

import java.util.HashMap;
import java.util.Map;


public class codeforces_Inna_and_Dima {

  private final int[][] delta = new int[][] {{-1, 0}, {1,  0}, {0,  -1}, {0,  1}};

  public static void main(String[] args) {
    codeforces_Inna_and_Dima solution = new codeforces_Inna_and_Dima();

    char[][] board;

    // Test case 1.
    board = new char[][] {"DI".toCharArray()};

    System.out.println(solution.solve(board));

    // Test case 2.
    board = new char[][] {"MA".toCharArray(),
                          "ID".toCharArray(),
                          };

    System.out.println(solution.solve(board));

    // Test case 3.
    board = new char[][] {"DIMAD".toCharArray(),
                          "DIMAI".toCharArray(),
                          "DIMAM".toCharArray(),
                          "DDMAA".toCharArray(),
                          "AAMID".toCharArray(),
                          };

    System.out.println(solution.solve(board));
  }

  public String solve(char[][] board) {
    int n = board.length;
    int m = board[0].length;
    int[][] count = new int[n][m];

    Map<Character, Character> path = buildPath();

    int max = -1;

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (board[i][j] == 'D') {
          int localCount = dfs(i, j, new boolean[n][m], board, path, count);
          if (localCount == Integer.MAX_VALUE) {
            return "Poor Inna";
          }

          max = Math.max(localCount, max);
        }
      }
    }

    return (max == 0) ? "Poor Dima" : Integer.toString(max);
  }

  private int dfs(int i, int j, boolean[][] visited, char[][] board,
                  Map<Character, Character> path, int[][] count) {
    if (visited[i][j]) {
      return Integer.MAX_VALUE;
    }

    if (board[i][j] == 'D') {
      visited[i][j] = true;
    }

    if (count[i][j] != 0) {
      return count[i][j];
    }

    int retval = (board[i][j] == 'A') ? 1 : 0;
    int max = 0;

    char nextChar = path.get(board[i][j]);

    for (int[] dxdy : this.delta) {
      int dx = dxdy[0];
      int dy = dxdy[1];

      if (i + dx >= 0 && i + dx < board.length &&
          j + dy >= 0 && j + dy < board[i].length &&
          board[i + dx][j + dy] == nextChar) {
        int num = dfs(i + dx, j + dy, visited, board, path, count);
        if (num == Integer.MAX_VALUE) {
          return num;
        } else {
          max = Math.max(max, num);
        }
      }
    }

    retval += max;

    if (board[i][j] == 'D') {
      count[i][j] = retval;
    }

    return retval;
  }

  private Map<Character, Character> buildPath() {
    Map<Character, Character> path = new HashMap<Character, Character>();

    path.put('D', 'I');
    path.put('I', 'M');
    path.put('M', 'A');
    path.put('A', 'D');

    return path;
  }
}
