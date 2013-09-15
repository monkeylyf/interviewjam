/*Trailing_Zeros
careercup

Write an algorithm which computes the number of trailing zeros in n factorial
*/

public class cap_Trailing_Zeros {

	public static void main(String[] args) {
		System.out.println(trailingZeros(25));
		System.out.println(trailingZeros(26));
		System.out.println(trailingZeros(50));
		System.out.println(trailingZeros(125));
		System.out.println(trailingZeros(131));
	}

	public static int trailingZeros(int n) {
        // The idea behind this is counting the number of factor 5.
        // 10 = 2 * 5, and it's easy to notice that factors 2 is more than factors 5.
        // Decimal to Quinary.
		int base = 0;
		while (n > 5) {
			base += n / 5;
			n /= 5;
		}
		return base;
	}
}
