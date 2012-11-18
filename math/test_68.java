/*Given a two dimensional graph with points on it, find a line which passes the
most number of points*/

import java.util.*;

class test_68 {
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
		linePassMostPoints(input, 9);
	}

	public static void linePassMostPoints(int[][] m, int n) {
		int largest = Integer.MIN_VALUE;
		String largestFunc = "FUCK ME";
		for (int i = 0; i < n - 1; ++i) {
			Hashtable<String, Integer> table = new Hashtable<String, Integer>();
			for (int j = i + 1; j < n; ++j) {
				System.out.println("Processing" + m[i][0] + ", "+ m[i][1] +", "+ m[j][0] + ", "+ m[j][1]);
				String func = getLineFunc(m[i][0], m[i][1], m[j][0], m[j][1]);
				System.out.println(func);
				if(!table.containsKey(func)) table.put(func, 2);
				else table.put(func, table.get(func) + 1);
			}
			Set set = table.keySet();
			Iterator itr = set.iterator();
			while (itr.hasNext()) {
				String func = (String) itr.next();
				if (table.get(func) > largest) {
					largest = table.get(func);
					largestFunc = func;
				}
			}
		}
		System.out.println("The function of line which passes the most number is " + largestFunc);
		System.out.println("The number is " + largest);
	}

	public static String getLineFunc(double x1, double y1, double x2, double y2) {
		if (x1 == x2) return "y = " + x1;
		double slope = Math.abs(y1 - y2) / Math.abs((x1 - x2));
		double yintercept = (x1 * y2 - x2 * y1) / Math.abs(x1 - x2);
		return "y = " + slope + "x + " + yintercept;
	}
}
