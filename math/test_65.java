/*Given two lines on a Cartesian plane, determine whether the two lines would
intersect*/

public class Line {
	public double epsilon = 0.000001;
	public double slope;
	public double yintercept;

	public Line(double s, double y) {
		slope = s;
		yintercept = y;
	}

	public boolean intercept(Line line) {
		return Math.abs(line.slope - slope) > epsilon || (Math.abs(line.slope - slope) < 
			epsilon && Math.abs(line.yintercept - yintercept) < epsilon)
	}
}
