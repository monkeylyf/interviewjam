/*Write a method to generate the nth Fibonacci number*/

class test_49 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; ++i) {
			System.out.println(Fibonacci(i));	
		}
		for (int i = 0; i < 10; ++i) {
			System.out.println(printFiboFor(i));	
		}
	}

	// My first draft.
	public static int Fibonacci(int n) {
		if (n <= 0) return 0;
		if (n == 1) return 1;
		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}

	// Iterate method.
	public static int printFiboFor(int n) {
		if (n <= 0) return 0;
		if (n == 1 | n == 2) return 1;
		int i = 1;
		int j = 1;
		int tmp;
		for (int k = n - 2; k >= 1; --k) {
			tmp = i + j;
			i = j;
			j = tmp;
		}
		return j;
	}
}
