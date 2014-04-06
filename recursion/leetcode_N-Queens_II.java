/*N-Queens_II

Follow up for N-Queens problem.
Now, instead outputting board configurations, return the total number of
distinct solutions.
*/

import java.util.ArrayList;


public class leetcode_N-Queens_II {

    public static void main(String[] args) {
        System.out.println(totalNQueens(8));
    }

    public static int totalNQueens(int n) {
        ArrayList<int[]> all = new ArrayList<int[]>();
        int[] board = new int[n];
        placeQueen(0, n, board, all);
        return all.size();
    }

	// Backtracking.
    private static void placeQueen(int row, int n, int[] board, ArrayList<int[]> all) {
        if (row == n) {
            int[] tmp = new int[n];
            for (int i = 0; i < n; ++i) {
                tmp[i] = board[i];
            }
            all.add(tmp);
            board = new int[n];
        } else {
            for (int i = 0; i < n; ++i) {
                board[row] = i;
                if (check(row, board)) {
                    placeQueen(row + 1, n, board, all);
                }
            }
        }
    }

	// Check if the current Queen conflicts with others.
    private static boolean check(int row, int[] board) {
        for (int i = 0; i < row; ++i) {
            int diff = Math.abs(board[i] - board[row]);
            if (diff == 0 || diff == row - i) {
                return false;
            }
        }
        return true;
    }
}


/* Python Version
*Notes* this one is pretty much the same with NQueue.
There is a bit operation based solution but it will be overkill in an interview.

def totalNQueens(self, n):
    def backtrack(board, idx, cnt):
        if idx == len(board):
            cnt.append(0)
        else:
            for i in xrange(len(board)):
                board[idx] = i
                if self.isValid(board, idx):
                    backtrack(board, idx + 1, cnt)
                board[idx] = -1
    
    board = [ -1 ] * n
    cnt = []
    backtrack(board, 0, cnt)
    return len(cnt)

def isValid(self, board, idx):
    for i in xrange(idx):
        if board[idx] == board[i] or abs(idx - i) == abs(board[idx] - board[i]):
            return False
    return True
*/
