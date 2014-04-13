/*Line_With_Most_Given_Points
careercup

Given a two dimensional graph with points on it, find a line which passes the
most number of points


Mark as duplicated to leetcode: Max Points on a Line
*/

import java.util.*;


public class leetcode_Max_Points_On_A_Line.java {

  public static void main(String[] args) {
	Point[] points;
	points = new Point[] { new Point(0, 0), new Point(1, 1), new Point(1, -1) };
	maxPoints(points);

	points = new Point[] { new Point(0, 0), new Point(1, 1), new Point(0, 0) };
	maxPoints(points);

	points = new Point[] { new Point(2, 3), new Point(3, 3), new Point(-5, 3) };
	maxPoints(points);

	points = new Point[] { new Point(-4, 1), new Point(-7, 7), new Point(-1, 5), new Point(9, -25) };
	maxPoints(points);
  }

  public static int maxPoints(Point[] points) {
	int ret = 0, n = points.length, i, j, same, x, y, g, max;
	String key;
	HashMap<String, Integer> count;
	for (i = 0; i < n; ++i) {
	  count = new HashMap<String, Integer>();
	  same = 1;
	  max = 0;
	  for (j = i + 1; j < n; ++j) {
		x = points[i].x - points[j].x;
		y = points[i].y - points[j].y;
		g = gcd(x, y);
		if (g == 0) {
		  ++same;
		  continue;
		}
		key = x / g + " " + y / g;
		if (!count.containsKey(key)) {
		  count.put(key, 1);
		} else {
		  count.put(key, count.get(key) + 1);
		}
		max = Math.max(max, count.get(key));
	  }
	  ret = Math.max(ret, max + same);
	}
	System.out.println("The number is " + ret);
	return ret;
  }

  // Greatest common dividor.
  public static int gcd(int a, int b) {
	return (a != 0) ? (a / Math.abs(a)) * Math.abs(gcd(b % a, a)) : b;
  }

  // The solution below did not pass the OJ
  // 1. Use y = ax + b to represent a line is not good enough. Why?
  // 2. How to handle duplicate point, for example, {0, 0}, {0, 0}, {1, 1}
  public static String getLineFunc(Point a, Point b) {
	if (a.x == b.x && a.y ==b.y) {
	  return "Same";
	} else if (a.y == b.y) {
	  return "y = " + b.y;
	} else if (a.x == b.x) {
	  return "y = " + a.x;
	} else {
	  double slope = (a.y - b.y) / (a.x - b.x);
	  double yintercept = (a.x * b.y - b.x * a.y) / (a.x - b.x);
	  return "y = " + slope + "x + " + yintercept;
	}
  }

  // HashMap<Line Function, # of points on this line>
  public static void linePassMostPoints(Point[] points) {
	int largest = Integer.MIN_VALUE, n = points.length, i, j;
	HashMap<String, Integer> map;
	String ret = "", func;
	for (i = 0; i < n; ++i) {
	  map = new HashMap<String, Integer>();
	  for (j = i + 1; j < n; ++j) {
		//System.out.println("Processing" + m[i][0] + ", "+ m[i][1] +", "+ m[j][0] + ", "+ m[j][1]);
		func = getLineFunc(points[i], points[j]);
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

  static class Point {

	int x;
	int y;

	Point() {
	  x = 0;
	  y = 0;
	}

	Point(int a, int b) {
	  x = a;
	  y = b;
	}

	public String toString() {
	  return "<" + this.x + ", " + this.y + ">";
	}
  }
}


/* Python Version 
def maxPoints(self, points):
    Max = 0
    for i in xrange(len(points)):
        count = collections.defaultdict(int)
        same_points = 1
        localMax = 0
        for j in xrange(i + 1, len(points)):
            # Calc uniq key to represent line function.
            dx = points[i].x - points[j].x
            dy = points[i].y - points[j].y
			# Make sure dx / gcd > 0 when gcd != 0
            gcd = self.gcd(dx, dy)
            gcd = gcd if dx * dy > 0 else -gcd
            if gcd == 0:
                same_points += 1
			else:
            	key = '{0}:{1}'.format(dx / gcd, dy / gcd)
            	count[key] += 1
				# Update localMax.
            	localMax = max(localMax, count[key])
        Max = max(Max, same_points + localMax)
    return Max

def gcd(self, a, b):
    return self.gcd(b % a, a) if a != 0 else b
*/
