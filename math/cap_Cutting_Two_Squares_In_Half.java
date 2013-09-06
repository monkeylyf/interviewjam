/*Cutting_Two_Squares_In_Half
careercup

Given two squares on a two dimensional plane, find a line that would cut
these two squares in half
*/


public class cap_Cutting_Two_Squares_In_Half {

	// The first three questions you should ask is
	// 1. How to define a point in two dimensional plane.
	// 2. How to define a square in two dimensional plane.
	// 3. How to define a line in two dimensional plane.
	public static void main(String[] args) {
		Square s1 = new Square(-3, 3, -1, 1);
		Square s2 = new Square(1, -1, 4, -4);
		System.out.println(s1.lineCutInHalf(s2));
		Square s3 = new Square(-4, -1, -2, -3);
		System.out.println(s1.lineCutInHalf(s3));
	}	
}


// Definition of a square.
// 1. use upperLeft and lowerRight to define a square.
// 2. use center, radius, one of the corner point to define a square.
// 3. etc..
class Square {
	private Point upperLeft;
	private Point lowerRight;

	Square (double xUpperleft, double yUpperleft, double xLowerright, double yLowerright) {
		this.upperLeft = new Point(xUpperleft, yUpperleft);
		this.lowerRight = new Point(xLowerright, yLowerright);
	} // End of constructor.

	public Line lineCutInHalf(Square s) {
		double xThis = (upperLeft.x() + lowerRight.x()) / 2;
		double yThis = (upperLeft.y() + lowerRight.y()) / 2;
		double x = (s.upperLeft.x() + s.lowerRight.x()) / 2;
		double y = (s.upperLeft.y() + s.lowerRight.y()) / 2;

		if (x == xThis && y == yThis) {
			// Two center points oeverlapped. Any line on the center points will do.
			return new Line(x, y, x, y + 1); // (x, y+1) is a randome point.
		} else {
			return new Line(xThis, yThis, x, y);
		}
	}
}

// Definition of a point
class Point {
	private double x;
	private double y;

	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double x() {
		return this.x;	
	}

	public double y() {
		return this.y;
	}
}

// Definition of a line
class Line {
	// Line in form of a*x + b*y = c
	private double a;
	private double b;
	private double c;

	Line(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	Line(double x1, double y1, double x2, double y2) {
		if (x1 == x2 && y1 == y2) {
			throw new NumberFormatException("Input args are the same point.");
		}
		if (x1 == x2) {
			// Line in the form of x = c.
			this.a = 1;
			this.b = 0;
			this.c = x1;
		} else {
			// In form of a * x + y = c
			this.a = - (y1 - y2) / (x1 - x2);
			this.b = 1;
			this.c = this.a * x1 + y1;
		}
	}

	public String toString() {
		return String.format("%f * y + %f * x = %f", this.a, this.b, this.c);	
	}
}
