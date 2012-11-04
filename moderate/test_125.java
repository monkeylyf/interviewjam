/*Write an algorithm which computes the number of trailing zeros in n factorial*/

class test_125 {
	public static void main(String[] args) {
		System.out.println(trailingZeros(25));
		System.out.println(trailingZeros(26));
		System.out.println(trailingZeros(50));
		System.out.println(trailingZeros(125));
		System.out.println(trailingZeros(131));
	}

	public static int trailingZeros(int n) {
		int base = 0;
		while (n / 5 != 0) {
			base += n / 5;
			n /= 5;
		}
		return base;
	}
}
