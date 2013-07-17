/*Is_Two_Line_Segments_Intersect
geeksforgeeks

Solution 1:
This solution is no-brainer and based on analytic geometry.
Calculate the function for both line segments.
Assume they are lines instead of line segments. Find out if they have
intersection. If yes, find out if the intersection point is on either of
segments.

Downside of this solution:
Comlexity: edge case like x = 3 when finding the function representation of
both line segments.
Loss of precision: Unless you use fraction to represent slode, using float type
might cause loss of precsiona and inaccuracy factor has to been introduced in.
Heavy code: might take more than 150 lines of Java code. Or more.

The solution introduced below is more elegant and way less code needed.

Post link: http://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/
Check the example of general/special cases
*/


public class Is_Two_Line_Segments_Intersect {

	/**
	 * Given two line segments (p1, q1) and (p2, q2), find if the given line
	 * segments intersect with each other.
	 */

	static final int COLINEAR = 0;
	static final int CLOCKWISE = 1;
	static final int COUNTERCLOCKWISE = 2;
	
	public static void main(String[] args) {
		//test case 1.
		Point p1 = new Point(1, 1);
		Point p2 = new Point(1, 2);
		Point q1 = new Point(10, 1);
		Point q2 = new Point(10, 2);
		System.out.println(isIntersected(p1, q1, p2, q2)); // False
		// test case 2. 
		p1 = new Point(10, 0);
		p2 = new Point(0, 0);
		q1 = new Point(0, 10);
		q2 = new Point(10, 10);
		System.out.println(isIntersected(p1, q1, p2, q2)); // True
		// test case 3.
		p1 = new Point(-5, -5);
		p2 = new Point(1, 1);
		q1 = new Point(0, 0);
		q2 = new Point(10, 10);
		System.out.println(isIntersected(p1, q1, p2, q2)); // False
		// test case 4.
		p1 = new Point(10, 0);
		p2 = new Point(5, 5);
		q1 = new Point(10, 10);
		q2 = new Point(1000000, 5);
		System.out.println(isIntersected(p1, q1, p2, q2)); // True
		// test case 5.
		p1 = new Point(0, 0);
		p2 = new Point(5, 5);
		q1 = new Point(0, 10);
		q2 = new Point(1000000, 5);
		System.out.println(isIntersected(p1, q1, p2, q2)); // False
	}

	// The main function that returns true if line segment 'p1q1'
	// and 'p2q2' intersect.
	public static boolean isIntersected(Point p1, Point q1, Point p2, Point q2) {
		int o1 = orientation(p1, q1, p2);
	    int o2 = orientation(p1, q1, q2);
	    int o3 = orientation(p2, q2, p1);
	    int o4 = orientation(p2, q2, q1);
	   
		//System.out.println(o1 + "|"+ o2 +"|"+ o3 +"|"+ o4);
	    if (o1 != o2 && o3 != o4) {
			// General case. If two sets of orientation are different
			// they are intersected.
	    	return true;
		// There is colinear type, check if the third point in on the line segment.
	    } else if (o1 == 0 && isOnSegment(p1, p2, q1)) {
	    	return true;
	    } else if (o2 == 0 && isOnSegment(p1, q2, q1)) {
	    	return true;
	    } else if (o3 == 0 && isOnSegment(p2, q2, p1)) {
	    	return true;
	    } else if (o4 == 0 && isOnSegment(p2, q1, q2)) {
	    	return true;
	    } else {
			// Other cases are all non-intersected.
	    	return false;
	    }
	}
	
	// Given three colinear points p, q, r, the function checks if
	// point q lies on line segment 'pr'
	public static boolean isOnSegment(Point p, Point q, Point r) {
		// Prerequisite: p-q and q-r are COLLINEAR.
		return q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
				q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y);
	}

	// Return the orientation type of point p, q, r.
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
	}
}
