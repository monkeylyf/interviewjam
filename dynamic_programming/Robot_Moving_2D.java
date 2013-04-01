/*Robot_Moving_2D

Given a two-dimension MxN grid and a robot sitting at upper-left(0, 0) wants
to move to lower-right (M - 1, N - 1). The robot can only move one step right
and one step down at one time. Given the cost function F(x, y) of taking each
step. What is the least cost moving from (0, 0) to (M, N)?

FOLLOWUP:
What is the path of min cost?
*/


import java.util.ArrayList;


class Robot_Moving_2D {

    // C(x, y) = Math.min(C(x+1,y) + Cost from (x+1,y) to (x,y), C(x,y-1) + Cost from (x,y-1) to (x,y))
    // The path can be easily reconstructed by finding the local min cost of each step taken reversely.
    public static void main(String args[]) {
        int[][] right = new int[][] {{0, 0, 1, 1, 1},
                                     {0, 1, 1, 1, 1},
                                     {0, 1, 0, 0, 1},
                                     {0, 1, 1, 1, 1},
                                     {0, 1, 1, 1, 0}};
        int[][] down = new int[][] {{0, 0, 0, 0, 1},
                                    {1, 0, 1, 1, 1},
                                    {1, 0, 1, 1, 1},
                                    {1, 1, 1, 0, 1},
                                    {1, 1, 1, 0, 1}};
        //myCost(right, down);
        myPath(right, down);
    }

    public static void myCost(int[][] right, int[][] down) {
        int[][] cost = new int[right.length][right[0].length];
        cost[0][0] = 0;
        for (int i = 1; i < right.length; ++i) {
            cost[0][i] = cost[0][i-1] + right[0][i]; // row 0.
        }
        for (int i = 1; i < down.length; ++i) {
            cost[i][0] = cost[i-1][0] + down[i][0]; // column 0.
        }
        for (int i = 1; i < right.length; ++i) {
            for (int j = 1; j < right[i].length; ++j) {
                cost[i][j] = Math.min(cost[i][j-1] + right[i][j], cost[i-1][j] + down[i][j]);
            }
        }
        System.out.println(cost[right.length - 1][right.length - 1]);
    }

    public static void myPath(int[][] right, int[][] down) {
        ArrayList<int[]> path = new ArrayList<int[]>();
        int[][] cost = new int[right.length][right[0].length];
        cost[0][0] = 0;
        for (int i = 1; i < right.length; ++i) {
            cost[0][i] = cost[0][i-1] + right[0][i]; // row 0.
        }

        for (int i = 1; i < down.length; ++i) {
            cost[i][0] = cost[i-1][0] + down[i][0]; // column 0.
        }

        for (int i = 1; i < right.length; ++i) {
            for (int j = 1; j < right[i].length; ++j) {
                cost[i][j] = Math.min(cost[i][j-1] + right[i][j], cost[i-1][j] + down[i][j]);
            }
        }

        for (int i = 0; i < cost.length; ++i) {
            for (int j = 0; j < cost.length; ++j) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println("");
        }

        int x = cost.length - 1;
        int y = cost[0].length - 1;
        path.add(new int[] {cost.length - 1, cost[0].length - 1});
        while (x != 0 && y != 0) {
            if (cost[x-1][y] + down[x][y] == cost[x][y]) {
                path.add(new int[] {x-- - 1, y});
            } else {
                path.add(new int[] {x, y-- -1});
            }
        }
        path.add(new int[] {0, 0});
        for (int i = path.size() - 1; i >= 0; --i) {
            System.out.println("(" + path.get(i)[0] + ", " + path.get(i)[1] + ")");
        }
    }
}
