/*Is_Point_Inside_Polygon_Jarvis
geeksforgeeks

Given a polygon and a point ‘p’, find if ‘p’ lies inside the polygon or
not. The points lying on the border are considered inside.

Jarvis march/algorithm: http://en.wikipedia.org/wiki/Gift_wrapping_algorithm

Graham scan: ./Is_Point_Inside_Polygon_Graham_Scan.java
*/


public class Is_Point_Inside_Polygon_Jarvis {

	/*
	 * Given the Is_Two_Line_Segments_Intersect function, we can
	 * implement this easily.
	 */
	static final int COLINEAR = 0;
	static final int CLOCKWISE = 1;
	static final int COUNTERCLOCKWISE = 2;

	static final int INFINITE = 100000;
	
	public static void main(String[] args) {
		//test case 1.
		Point[] polygon1 = new Point[] {new Point(0, 0), new Point(10, 0), new Point(10, 10), new Point(0, 10)};
		Point p = new Point(20, 20);
		System.out.println(isPointInsidePolygon(polygon1, p));
		// test case 2.
		p = new Point(5, 5);
		System.out.println(isPointInsidePolygon(polygon1, p)); // True
		// test case 3.
		polygon1 = new Point[] {new Point(0, 0), new Point(5, 5), new Point(5, 0)};
		p = new Point(3, 3);
		System.out.println(isPointInsidePolygon(polygon1, p));
		// test case 4.
		p = new Point(5, 1);
		System.out.println(isPointInsidePolygon(polygon1, p));
		// test case 5.
		p = new Point(8, 1);
		System.out.println(isPointInsidePolygon(polygon1, p));
		// test case 6.
		p = new Point(-1, 10);
		System.out.println(isPointInsidePolygon(polygon1, p));
	}

	public static boolean isPointInsidePolygon(Point[] polygon, Point p) {
		int n = polygon.length;
		if (n < 3) {
			return false; // Less than three points can not form a polygon.	
		}
		// An imaginary point which falls outside of the polygon(far far way).
		Point farAway = new Point(INFINITE, p.y);
		int count = 0, i = 0;
		Point next;
		for (i = 0; i < n; ++i) {
			next = polygon[(i + 1) % n];
			if (isIntersected(polygon[i], next, p, farAway)) {
				if (orientation(polygon[i], p, next) == COLINEAR)	{
					return isOnSegment(polygon[i], p, next);
				}
				++count;
			}
		}
		return count % 2 == 1;
	}
	
	public static boolean isIntersected(Point p1, Point q1, Point p2, Point q2) {
		int o1 = orientation(p1, q1, p2);
	    int o2 = orientation(p1, q1, q2);
	    int o3 = orientation(p2, q2, p1);
	    int o4 = orientation(p2, q2, q1);
	    
	    if (o1 != o2 && o3 != o4) {
	    	return true;
	    } else if (o1 == 0 && isOnSegment(p1, p2, q1)) {
	    	return true;
	    } else if (o2 == 0 && isOnSegment(p1, q2, q1)) {
	    	return true;
	    } else if (o3 == 0 && isOnSegment(p2, q2, p1)) {
	    	return true;
	    } else if (o4 == 0 && isOnSegment(p2, q1, q2)) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	
	// Given three colinear points p, q, r, the function checks if
	// point q lies on line segment 'pr'
	public static boolean isOnSegment(Point p, Point q, Point r) {
		// Prerequisite: p-q and q-r are COLINEAR.
		return q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
				q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y);
	}
	
	public static int orientation(Point p, Point q, Point r) {
		int slope_diff = (p.y - q.y) * (q.x - r.x) - (q.y - r.y) * (p.x - q.x);
		if (slope_diff == 0) {
			return COLINEAR;
		} else if (slope_diff > 0) {
			return CLOCKWISE;
		} else {
			return COUNTERCLOCKWISE;
		}
	}
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "<" + this.x + ", " + this.y + ">";
		}
	}
}
