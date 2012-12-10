/*Imagine a robot sitting on the upper left hand corner of an NxN grid. The
robot can only move in two directions: right and down. How many possible paths
are there for the robot?
FOLLOW UP
Imagine certain squares are “off limits”, such that the robot can not step
on them. Design an algorithm to get all possible paths for the robot.

Dynamic programming
C(x, y) = C(x - 1, y) + C(x, y - 1)
*/

import java.util.*;


class test_50 {
	public static void main(String[] args) {
       my(3, 3);
       ArrayList<int[]> ol = new ArrayList<int[]>();
       ol.add(new int[] {1,1});
       ol.add(new int[] {1,0});
       myOffLimits(3, 3, ol);
    }
    public static void my(int x, int y) {
        ArrayList<int[]> sol = new ArrayList<int[]>();
        int[] path = new int[x + y - 2];
        nextGrid(x - 1, y - 1, sol, path); // (x-1,y-1) is destination.
        System.out.println("Total # of possible paths are: " + sol.size());
    }
    public static void nextGrid(int x, int y, ArrayList<int[]> sol, int[] path) {
        if (x == 0 && y == 0) sol.add(path);
        else {
            if (x != 0) nextGrid(x - 1, y, sol, path);
            if (y != 0) nextGrid(x, y - 1, sol, path);
        }
    }
    // Followup.
    public static void myOffLimits(int x, int y, ArrayList<int[]> ol) {
        ArrayList<int[]> sol = new ArrayList<int[]>();
        int[] path = new int[x + y - 2];
        next(x - 1, y - 1, sol, path, ol); // (x-1,y-1) is destination.
        System.out.println("Total # of possible paths are: " + sol.size());
    }
    public static void next(int x, int y, ArrayList<int[]> sol, int[] path, ArrayList<int[]> ol) {
        if (x == 0 && y == 0) sol.add(path);
        else {
            if (isOffLimit(ol, x, y - 1) && y != 0) next(x, y - 1, sol, path, ol);      
            if (isOffLimit(ol, x - 1, y) && x != 0) next(x - 1, y, sol, path, ol);      
        }
    }
    public static boolean isOffLimit(ArrayList<int[]> arr, int x, int y) {
        for (int[] i : arr) if (i[0] == x && i[1] == y) return false;
        return true;
    }
}
