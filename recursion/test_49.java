/*Write a method to generate the nth Fibonacci number*/

class test_49 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; ++i) System.out.println(Fibonacci(i));	
	}
	public static int Fibonacci(int n) {
		if (n <= 0) return 0;
		if (n == 1) return 1;
		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}
}
