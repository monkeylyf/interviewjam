/**
 * Word_Search.
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * For example,
 * Given board =
 *
 * [
 * ["ABCE"],
 * ["SFCS"],
 * ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */


public class leetcode_Word_Search {

  public static void main(String[] args) {
	char[][] board = new char[][] {
      "ABCE".toCharArray(),
      "SFCS".toCharArray(),
      "ADEE".toCharArray()
    };
	System.out.println(exist(board, "ABCCED"));
  }

  public static boolean exist(char[][] board, String word) {
	int n = board.length;
	int m = board[0].length;

	boolean[][] visited = new boolean[n][m];

	for (int i = 0; i < n; ++i) {
	  for (int j = 0; j < m; ++j) {
		if (dfs(i, j, word, visited, board, n, m)) {
		  return true;
		}
	  }
	}

	return false;
  }

  public static boolean dfs(int i, int j, String word, boolean[][] visited, char[][] board, int n, int m) {
	if (word.length() == 0) {
	  return true;
	} else if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || word.charAt(0) != board[i][j]) {
	  return false;
	} else {
	  visited[i][j] = true;
	  if (dfs(i + 1, j, word.substring(1), visited, board, n, m)) {
		return true;
	  }
	  if (dfs(i - 1, j, word.substring(1), visited, board, n, m)) {
		return true;
	  }
	  if (dfs(i, j + 1, word.substring(1), visited, board, n, m)) {
		return true;
	  }
	  if (dfs(i, j - 1, word.substring(1), visited, board, n, m)) {
		return true;
	  }
	  visited[i][j] = false;
	  return false;
	}
  }
}

/* Python Version
FYI leetcode OJ for python, the input format is totally fucked up.

def exist(self, board, word):
    def dfs(i, j, word):
        if not word:
            return True
        elif i >= n or i < 0 or j >= m or j < 0 or visited[i][j] or board[i][0][j] != word[0]:
            return False
        else:
            visited[i][j] = True
            if dfs(i + 1, j, word[1:]):
                return True
            if dfs(i - 1, j, word[1:]):
                return True
            if dfs(i, j + 1, word[1:]):
                return True
            if dfs(i, j - 1, word[1:]):
                return True
            visited[i][j] = False
            return False

    n = len(board)
    m = len(board[0][0])
    visited = [ [False for _ in xrange(m) ] for _ in xrange(n) ]

    for i in xrange(n):
        for j in xrange(m):
            if dfs(i, j, word):
                return True

    return False
*/
