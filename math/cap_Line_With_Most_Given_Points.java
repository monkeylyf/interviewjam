/*Line_With_Most_Given_Points
careercup

Given a two dimensional graph with points on it, find a line which passes the
most number of points
*/

import java.util.*;


class cap_Line_With_Most_Given_Points {

	public static void main(String[] args) {
		int[][] input = {{1,1},
				 {0,1},
				 {-10,1},
				 {0,0},
				 {2,2},
				 {3,4},
				 {3,0},
				 {3,3},
				 {0,-2},
				 {5,0},
				 };
		linePassMostPoints(input);
	}

	// HashMap<Line Function, # of points on this line>
	public static void linePassMostPoints(int[][] m) {
		int largest = Integer.MIN_VALUE, n = m.length, i, j;
		HashMap<String, Integer> map;
		String ret = "", func;
		for (i = 0; i < n; ++i) {
			map = new HashMap<String, Integer>();
			for (j = i + 1; j < n; ++j) {
				//System.out.println("Processing" + m[i][0] + ", "+ m[i][1] +", "+ m[j][0] + ", "+ m[j][1]);
				func = getLineFunc(m[i][0], m[i][1], m[j][0], m[j][1]);
				//System.out.println(func);
				if (!map.containsKey(func)) {
					map.put(func, 2);
				} else {
					map.put(func, map.get(func) + 1);
				}
			}
			for (String key: map.keySet()) {
				if (map.get(key) > largest) {
					largest = map.get(key);
					ret = key;
				}
			}
		}
		System.out.println("The function of line which passes the most number is " + ret);
		System.out.println("The number is " + largest);
	}

	public static String getLineFunc(double x1, double y1, double x2, double y2) {
		if (x1 == x2) {
			return "y = " + x1;
		}
		double slope = Math.abs(y1 - y2) / Math.abs((x1 - x2));
		double yintercept = (x1 * y2 - x2 * y1) / Math.abs(x1 - x2);
		return "y = " + slope + "x + " + yintercept;
	}
}
