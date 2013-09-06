/*Implement_Substraction_Times_Division_Without_Using_Add
careercup

Write a method to implement *, - , / operations You should use only the +
operator.
*/


public class cap_Implement_Substraction_Times_Division_Without_Using_Add {

	public static void main(String[] args) {
		// Test case 1.
		System.out.println(flipInt(5) == -5);
		// Test case 2.
		System.out.println(Times(5, 4) == 20);
		System.out.println(Times(-5, 4) == -20);
		System.out.println(Times(5, -4) == -20);
		System.out.println(Times(-5, -4) == 20);
		// Test case 3.
		System.out.println(Substraction(-5, -4) == -1);
		// Test case 4.
		System.out.println(Division(5, 4) == 1);
		System.out.println(Division(12, 4) == 3);
		System.out.println(Division(-3, -1) == 3);
		System.out.println(Division(-3, 1) == -3);
	}

	// Turn a to -a.
	public static int flipInt(int a) {
		int offset = a < 0 ? 1 : -1;
		int ret = 0;
		while (a != 0) {
			a += offset;
			ret += offset;
		}
		return ret;
	}

	public static int Times(int a, int b) {
		// Using aa as base and keep added b up while counting down aa.
		int bb = Math.abs(b), ret = 0;
		for (int aa = Math.abs(a); aa > 0; --aa) {
			ret += bb;
		}
		// Flip the ret if a * b is neg.
		return ((a >= 0 && b >= 0) || (a < 0 && b < 0)) ? ret : flipInt(ret);
	}

	public static int Substraction(int a, int b) {
		return a + flipInt(b);
	}

	public static int Division(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("Divider can not be zero.");	
		}
		int aa = Math.abs(a), bb = Math.abs(b), negB = flipInt(bb), ret = 0;
		while (aa >= bb) {
			ret += 1;
			aa += negB;
		}
		return ((a >= 0 && b >= 0) || (a < 0 && b < 0)) ? ret : flipInt(ret);
	}
}
