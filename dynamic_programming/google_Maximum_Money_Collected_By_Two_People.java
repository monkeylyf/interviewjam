/*Maximum_Money_Collected_By_Two_People
google

Given m x n matrix. Integers in grids represent that value of money. Two people
start from [m - 1][0] to [0][n - 1] while collecting monay on the paths. They
can only go up or go right. What's the maximum number of sum of the money
collected by these two people?

*/


class google_Maximum_Money_Collected_By_Two_People {
    public static void main(String[] args) {
        int[][] matrix = {{40, 40 , 0},
                          {50, 50, 50},
                          {0, 40, 40}};
        //System.out.println(maxMoneyOnePeople(matrix));
        System.out.println(maxMoneyTwoPeopleImproved(matrix));
    }
    // Let's first consider one people collecting money scenario.
    public static int maxMoneyOnePeople(int[][] matrix) {
        // Classic db problem.
        // C(x, y) = C(x + 1, y) + matrix(x, y) if y = 0
        //         = C(x, y - 1) + matrix(x, y) if x = m - 1
        //         = Math.max(C(x - 1, y) + C(x, y - 1)) + matrix(x, y)
        int m = matrix.length;
        int n = matrix[0].length;
        int[] track = new int[n];
        for (int i = 1; i < n; ++i) {
            track[i] = track[i - 1] + matrix[m - 1][i];
        }
        for (int i = m - 2; i >= 0; --i) {
            int[] next = new int[n];
            next[0] = track[0] + matrix[i][0];
            for (int j = 1; j < n; ++j) {
                next[j] = Math.max(next[j - 1] ,track[j]) + matrix[i][j];
            }
            track = next;
        }
        return track[n - 1];
    }
    public static int maxMoneyTwoPeople(int[][] matrix) {
        // Dynamic programming based.
        // Two people A and B
        // Four-dimension matrix track[i][j][h][k] represents the maximum money
        // two people can collect when one at (i, j) and another at (h, k).
        int m = matrix.length;
        int n = matrix[0].length;
        int[][][][] track = new int[m][n][m][n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                for (int h = m - 1; h >= 0; --h) {
                    for (int k = 0; k < n ; ++k) {
                        // Right now A is @(i, j), B is @(h, k).
                        // track[i][j][h][k] = max(track[i + 1][j][h][k],
                        //                         track[i][i - 1][h][k],
                        //                         track[i][j][h + 1][k],
                        //                         track[i][j][h][k - 1]))        Be careful with indexOfBoundary
                        //                     + matrix[i][j] if (i == h && j == k) Money can be collected by only one guy 
                        //                       matrix[i][j] + matrix[h][k] else 
                        int leftLeft = (j != 0 && k != 0) ? track[i][j - 1][h][k - 1] : 0;
                        int leftDown = (j != 0 && h != m - 1) ? track[i][j - 1][h + 1][k] : 0;
                        int downLeft = (i != m - 1 && k != 0) ? track[i + 1][j][h][k - 1] : 0;
                        int downDown = (i != m - 1 && h != m - 1) ? track[i + 1][j][h + 1][k] : 0;
                        track[i][j][h][k] = maxOfFour(leftLeft, leftDown, downLeft, downDown);
                        if (i == h && j == k) {
                            track[i][j][h][k] += matrix[i][j];
                        } else {
                            track[i][j][h][k] += matrix[h][k] + matrix[i][j];
                        }
                    }
                }
            }
        }
        return track[0][n - 1][0][n - 1];
    }
    public static int maxOfFour(int i, int j, int h, int k) {
        return Math.max(Math.max(i, j), Math.max(h, k));
    }
}
