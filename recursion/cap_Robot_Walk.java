/*Robot_Walk
careercup

Imagine a robot sitting on the upper left hand corner of an NxN grid. The
robot can only move in two directions: right and down. How many possible paths
are there for the robot?
FOLLOW UP
Imagine certain squares are “off limits”, such that the robot can not step
on them. Design an algorithm to get all possible paths for the robot.

Dynamic programming
C(x, y) = C(x - 1, y) + C(x, y - 1)
*/

import java.util.*;


public class cap_Robot_Walk {

	/**
	 * If all possible paths are asked for, do recursions.
	 * If how manay different paths are there, dp will do.
	 */

	public static void main(String[] args) {
		// Test case for walk.
		//walk(3, 3);
		// Test case for 
		ArrayList<int[]> ol = new ArrayList<int[]>();
		ol.add(new int[] {1,1});
		ol.add(new int[] {1,0});
		walkOffLimits(3, 3, ol);
    }

	public static void walk(int x, int y) {
		ArrayList<String> path = new ArrayList<String>();
		ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
		nextGrid(x - 1, y - 1, path, all);
		for (ArrayList<String> shit : all) {
			System.out.println(shit);
		}
	}

    public static void nextGrid(int x, int y, ArrayList<String> path, ArrayList<ArrayList<String>> all) {
		path.add("<" + x + ", " + y + ">");
        if (x == 0 && y == 0) {
			all.add(new ArrayList<String>(path));
        } else {
            if (x != 0) {
				nextGrid(x - 1, y, path, all);
			}
            if (y != 0) {
				nextGrid(x, y - 1, path, all);
			}
        }
		path.remove(path.size() - 1);
    }

    // Followup. With off-limits.
    public static void walkOffLimits(int x, int y, ArrayList<int[]> offLimits) {
		ArrayList<String> path = new ArrayList<String>();
		ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
		next(x - 1, y - 1, path, all, offLimits);
		for (ArrayList<String> shit : all) {
			System.out.println(shit);
		}
    }

    public static void next(int x, int y, ArrayList<String> path, ArrayList<ArrayList<String>> all,
							ArrayList<int[]> offLimits) {
		if (isOffLimit(offLimits, x, y)) {
			return;	 // If (0, 0) is one of the offLimits then you will have empty result.
		}
		path.add("<" + x + ", " + y + ">");
        if (x == 0 && y == 0) {
			all.add(new ArrayList<String>(path));
        } else {
            if (x != 0) {
				next(x - 1, y, path, all, offLimits);
			}
            if (y != 0) {
				next(x, y - 1, path, all, offLimits);
			}
        }
		path.remove(path.size() - 1);
    }

	// Return if (x, y) belongs to one of the offlimits.
    public static boolean isOffLimit(ArrayList<int[]> arr, int x, int y) {
        for (int[] point : arr) {
			if (point[0] == x && point[1] == y) {
				return true;
			}
		}
        return false;
    }
}
