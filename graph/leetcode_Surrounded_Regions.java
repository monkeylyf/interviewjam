/**
 * Surrounded_Regions.

 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;


class leetcode_Surrounded_Regions {

  public static void main(String[] args) {
  }

  public static void main(String[] args) {
    char[][] board = new char[][] {{'O','O','O','O','O','O'},
      {'O','X','X','X','X','O'},
      {'O','X','O','O','X','O'},
      {'O','X','O','O','X','O'},
      {'O','X','X','X','X','O'},
      {'O','O','O','O','O','O'}};
    print(board);
    solve(board);
    print(board);
    solve(new char[][] {});
  }

  public static void print(char[][] board) {
    for (int i = 0; i < board.length; ++i) {
      for (int j = 0; j < board[i].length; ++j) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solve(char[][] board) {
    if (board == null || board.length == 0) {
      return;
    }
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < n; ++i) {
      dfs(board, 0, i);
      dfs(board, m - 1, i);
    }
    for (int i = 1; i < m - 1; ++i) {
      dfs(board, i, 0);
      dfs(board, i, n - 1);
    }
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        } else if (board[i][j] == 'B') {
          board[i][j] = 'O';
        }
      }
    }
  }

  public static void bfs(char[][] board, int i, int j) {
    if (board[i][j] != 'O') {
      return;
    }
    int m = board.length;
    int n = board[0].length;
    Queue<int[]> unvisited = new LinkedList<int[]>();
    Queue<int[]> nextToVisit = new LinkedList<int[]>();
    unvisited.add(new int[] {i, j});
    while (!unvisited.isEmpty()) {
      int[] point = unvisited.remove();
      int x = point[0];
      int y = point[1];
      if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
        board[x][y] = 'B'; // Mark border-related 'O' to 'B'
        nextToVisit.add(new int[] {x + 1, y});
        nextToVisit.add(new int[] {x - 1, y});
        nextToVisit.add(new int[] {x, y + 1});
        nextToVisit.add(new int[] {x, y - 1});
      }
      if (unvisited.isEmpty()) { // Switch to next depth.
        unvisited = nextToVisit;
        nextToVisit = new LinkedList<int[]>();
      }
    }
  }

  public static void dfs(char[][] board, int x, int y) {
    if (board[x][y] !=  'O')
      return;
    int m = board.length;
    int n = board[0].length;
    Stack<int[]> stack = new Stack<int[]>(); // Recurvsion stack is limited on leetcode. Use heap space to mock stack.
    stack.push(new int[]{x,y});
    while (stack.size() != 0) {
      x = stack.peek()[0];
      y = stack.peek()[1];
      stack.pop();
      if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
        continue;
      }
      board[x][y] = 'B';
      stack.push(new int[]{ x - 1, y});
      stack.push(new int[]{ x + 1, y});
      stack.push(new int[]{ x, y + 1});
      stack.push(new int[]{ x, y - 1});
    }
  }
}


/* Python Version
(The input is list of strings which is pain in the neck since str in python in immutable
so a str has to been converted into list then you can change char in it and they have to
be converted back to str after that. Darn.)

def solve(self, board):
    # Nested function.
    def bfs(i, j):
        if board[i][j] == 'X':
            return

        pipe = [(i, j)]

        while pipe:
            (x, y) = pipe.pop()
            if x >= 0 and x < n and y >= 0 and y < m and board[x][y] == 'O':
                arr = list(board[x])
                arr[y] = 'M' # Marked
                board[x] = ''.join(arr)
                pipe.append((x - 1, y))
                pipe.append((x, y - 1))
                pipe.append((x + 1, y))
                pipe.append((x, y + 1))

    if not board or len(board) <= 1:
        return
    (n, m) = (len(board), len(board[0]))

    for i in xrange(n):
        bfs(i, 0)
        bfs(i, m - 1)

    for i in xrange(m):
        bfs(0, i)
        bfs(n - 1, i)

    for i in xrange(n):
        arr = list(board[i])
        for j in xrange(m):
            if arr[j] == 'M':
                arr[j] = 'O'
            elif arr[j] == 'O':
                arr[j] = 'X'
        board[i] = ''.join(arr)
*/
