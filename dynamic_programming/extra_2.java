/*Given a two-dimension MxN grid and a robot sitting at upper-left(0, 0) wants
to move to lower-right (M - 1, N - 1). The robot can only move one step right
and one step down at one time. Given the cost function F(x, y) of taking each
step. What is the least cost moving from (0, 0) to (M, N)?

FOLLOWUP:
What is the path of min cost?*/

class extra_2 {
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
        myCost(right, down);
    }
    public static void myCost(int[][] right, int[][] down) {
        System.out.println("The min cost is: " +nextCost(right, down, down.length-1, down[0].length-1));
    }
    public static int nextCost(int[][] right, int[][] down, int x, int y) {
        if (x == 0 & y == 0) return 0;
        else {
            if (x == 0) return nextCost(right, down, x, y - 1) + right[x][y];
            if (y == 0) return nextCost(right, down, x - 1, y) + down[x][y];
            return Math.min(nextCost(right, down, x - 1, y) + down[x][y],
                            nextCost(right, down, x, y - 1) + right[x][y]);
        }
    }
    public static void myPath(int[][] right, int[][] down) {
    
    }
}
