/*Write a method to implement *, - , / operations You should use only the +
operator
*/

class test_66 {
	public static void main(String[] args) {
		System.out.println(flipInt(5));
		System.out.println(Multiply(5, 4));
		System.out.println(Multiply(-5, 4));
		System.out.println(Multiply(5, -4));
		System.out.println(Multiply(-5, -4));
		System.out.println(Minors(-5, -4));
		System.out.println(Devide(5, 4));
		System.out.println(Devide(12, 4));
		System.out.println(Devide(-3, -1));
		System.out.println(Devide(-3, 1));

	}

	public static int flipInt(int a) {
		int offset = a < 0 ? 1 : -1;
		int ret = 0;
		for (int i = a; a != 0; a += offset) ret += offset;
		return ret;
	}

	public static int Multiply(int a, int b) {
		int aa = Math.abs(a);
		int bb = Math.abs(b);
		int ret = 0;
		for (int i = aa; i > 0; --i) ret += bb;
		if ((a >= 0 && b >= 0) || (a < 0 && b < 0)) return ret;
		else return flipInt(ret);
	}

	public static int Minors(int a, int b) {return a + flipInt(b);}

	public static int Devide(int a, int b) {
		int aa = Math.abs(a);
		int bb = Math.abs(b);
		int ret = 0;
		while (aa >= bb) {
			ret += 1;
			aa += flipInt(bb);
		}
		if ((a >= 0 && b >= 0) || (a < 0 && b < 0)) return ret;
		else return flipInt(ret);
	}
}
