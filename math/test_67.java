/*Given two squares on a two dimensional plane, find a line that would cut
these two squares in half*/

class test_67 {
	public static void main(String[] args) {
		Square s1 = new Square(-3, 3, -1, 1);
		Square s2 = new Square(1, -1, 4, -4);
		for (double i : s1.lineCutInHalf(s2)) System.out.println(i);

		Square s3 = new Square(-4, -1, -2, -3);
		for (double i : s1.lineCutInHalf(s3)) System.out.println(i);
	}	
}


class Square {
	public Point upperleft = new Point();
	public Point lowerright = new Point();
	public Square (double xUpperleft, double yUpperleft, double xLowerright, double yLowerright) {
		upperleft.x = xUpperleft;
		upperleft.y = yUpperleft;
		lowerright.x = xLowerright;
		lowerright.y = yLowerright;
	}

	public double[] lineCutInHalf(Square s) {
		double xThis = (upperleft.x + lowerright.x) / 2;
		double yThis = (upperleft.y + lowerright.y) / 2;
		double x = (s.upperleft.x + s.lowerright.x) / 2;
		double y = (s.upperleft.y + s.lowerright.y) / 2;

		if (x == xThis && y == yThis) return new double[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
		else if (x == xThis) return new double[] {Integer.MAX_VALUE, x};
		double slope = (yThis - y) / (xThis - x);
		double yintercept = (xThis * y - yThis * x) / (xThis - x);
		return new double[] {slope, yintercept};
	}
}

class Point {
	public double x;
	public double y;
}
