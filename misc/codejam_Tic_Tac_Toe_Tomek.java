/*Tic-Tac-Toe-Tomek
codejam_2013_Qualificatin
https://code.google.com/codejam/contest/2270488/dashboard#s=p0
*/

import java.util.*;


class codejam_Tic_Tac_Toe_Tomek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, i, j;
        char[][] board = new char[4][4];
        String str;
        boolean hasEmptyCell;    
        T = sc.nextInt();
        for (t = 1; t <= T; ++t) {
            hasEmptyCell = false;
            for (i = 0; i < 4; ++i) {
                str = sc.next();
                for (j = 0; j < 4; ++j) {
                    board[i][j] = str.charAt(j);
                    if (board[i][j] == '.') {
                        hasEmptyCell = true; 
                    }
                }
            }
            solve(board, hasEmptyCell, t);
        }
    }

    public static void solve(char[][] board, boolean hasEmptyCell, int t) {
        System.out.print("Case #" + t + ": "); 
        HashSet<Character> row, col;
        int i, j;
        // check row.
        for (i = 0; i < 4; ++i) {
            row = new HashSet<Character>();
            col = new HashSet<Character>();
            for (j = 0; j < 4; ++j) {
                row.add(board[i][j]);
                col.add(board[j][i]);
            }
            if (hasWon(row)) {
                return;
            }
            if (hasWon(col)) {
                return;
            }
        }
        // check diagonal.
        row = new HashSet<Character>();
        for (i = 0; i < 4; ++i) {
            row.add(board[i][i]);
        }
        if (hasWon(row)) {
            return;
        }
        row = new HashSet<Character>();
        for (i = 0; i < 4; ++i) {
            row.add(board[i][3 - i]);
        }
        if (hasWon(row)) {
            return;
        }
        if (hasEmptyCell) {
            System.out.println("Game has not completed");
        } else {
            System.out.println("Draw");
        }
    }

    public static boolean hasWon(HashSet<Character> row) {
        if (row.size() == 2 && row.contains('T')) {
            if (row.contains('X')) {
                System.out.println("X won");
                return true;
            } else if (row.contains('O')) {
                System.out.println("O won");
                return true;
            }
        } else if (row.size() == 1) {
            if (row.contains('X')) {
                System.out.println("X won");
                return true;
            } else if (row.contains('O')) {
                System.out.println("O won");
                return true;
            }
        }
        return false;
    }
}
