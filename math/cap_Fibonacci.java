/*cap_Fibonacci
careercup

Write a method to generate the nth Fibonacci number
*/

public class cap_Fibonacci {

	public static void main(String[] args) {
		//for (int i = 0; i < 10; ++i) System.out.println(Fibonacci(i));
		//for (int i = 0; i < 10; ++i) System.out.println(Fibo(i));
		for (int i = 0; i < 10; ++i) System.out.println(i + " " + Fib(i));
	}

	// O(n) time complexy.
    public static int Fib(int n) {
        // dp-based
        // fib(n)=fib(n-1)+fib(n-2)
        if (n <= 0) return 0;
        int dp1 = 0, dp2 = 1;
        while (--n > 0) {
            dp2 += dp1;
            dp1 = dp2 - dp1;
        }
        return dp2;
    }

    // Recursive. Exponential time complexity. A lot of duplicate calculations.
	public static int Fibonacci(int n) {
		if (n <= 0) return 0;
		if (n == 1) return 1;
		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}

	// O(log n) time complexity.
	// a(n) = p * a(n - 1) + q * a(n - 2)
	// Equation: ( a(n)  ) = ( p^2 + q    p) * ( a(n-2) )
	//             a(n-1)      p          q      a(n-3)
	// In this case of Fibonacci, q = p = 1
	// Then we have:
	// ( a(2n+1)) = (2 1)^n * ( a(1) )
	//   a(2n)       1 1        a(0)
	// a(1) = a(0) = 1
	// Finally we have:
	// ( a(2n+1)) = (2 1)^n * (1)
	//   a(2n)       1 1	   1
	// We need to calculate (2 1) ^ n in O(log n)time complexity  
	//						 1 1	
	public static int Fibo(int n) {
		if (n == 0 || n == 1) return 1;
		int k = n / 2;
		int[] val = new int[] {1, 0, 0, 1};  
		int[] m = new int[] {2, 1, 1, 1};
		while (k > 0) {
			if (k % 2 == 1) val = matrixMultiply(val, m);
			m  = matrixMultiply(m, m);
			k /= 2;
		}
		if (n % 2 == 1) return val[0] + val[1]; 
		return val[2] + val[3];
	}

	private static int[] matrixMultiply(int[] m, int[] n) {
		return new int[] {m[0] * n[0] + m[1] * n[2],
				  m[0] * n[1] + m[1] * n[3],
				  m[2] * n[0] + m[3] * n[2],
				  m[2] * n[1] + m[3] * n[3]};
	}
}
