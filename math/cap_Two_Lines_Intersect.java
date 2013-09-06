/*Two_Lines_Intersect
careercup

Given two lines on a Cartesian plane, determine whether the two lines would
intersect
*/

public class cap_Two_Lines_Intersect {

	public static void main(String[] args) {
		// First you need to ask is what's the data structure of line or
		// how would you like to define it.
		// What if it's line segment?
	}
}


class MyLine {
	public double a;
	public double b;
	public double c;
	private epsilon = 0.000001;

	MyLine(double a, double b, double c) {
		// a*x + b*y = c
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public boolean intercept(MyLine line) {
		if (this.b == 0 && line.b == 0) {
			// Line in the form of x = k
			return Math.abs(this.c / this.a - line.c / line.a) < this.epsilon;
		} else {
			// Line in the form of y = ax + b, a could be 0.
			int thisSlope = this.a / this.b;
			int thatSlope = line.a / line.b;
			if (Math.abs(thisSlope - thatSlope) < this.epsilon) {
				// If slopes are equal, then compare projection on y axis.
				return (this.c / this.b - line.c / line.b) < this.epsilon;
			} else {
				// If slopes are different, then lines must intercept.
				return true;	
			}
		}
	}


}


// This is the answer provided by careercup 150.
// I don't think it handles the case of x = k.
class Line {
	public double epsilon = 0.000001;
	public double slope;
	public double yintercept;

	public Line(double s, double y) {
		this.slope = s;
		this.yintercept = y;
	}

	public boolean intercept(Line line) {
		return Math.abs(line.slope - slope) > epsilon || (Math.abs(line.slope - slope) < 
			epsilon && Math.abs(line.yintercept - yintercept) < epsilon)
	}
}
