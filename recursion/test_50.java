/*Imagine a robot sitting on the upper left hand corner of an NxN grid The robot can
only move in two directions: right and down. How many possible paths are there for the
robot?
FOLLOW UP
Imagine certain squares are “off limits”, such that the robot can not step on them.
Design an algorithm to get all possible paths for the robot*/

import java.util.*;



class test_50 {
	public static void main(String[] args) {
		System.out.println("Does this work?");
		Grid g = new Grid();
	}
}

class Grid {
	ArrayList<Point> cur_path = new ArrayList<Point>();

	public static boolean getPaths(int x, int y) {
		Point p = new Point(x, y);
		cur_path.add(p);
		if (x == 0 && y == 0) return true;
		boolean success = false;
		if (x >= 1 && is_free(x - 1, y)) {success = getPaths(x - 1, y);}
		if (!success && y >= 1 && is_free(x, y - 1)) {success = getPaths(x, y - 1);}
		if (!success) {cur_path.remove(p);}
	}

	public static is_free(int x, int y) {
		
	}
}

class Point {
	int x;
	int y;
	public Point(int xx, int yy) {
		x = xx;
		y = yy;
	}
}
