/*Add
careercup

Write a function that adds two numbers You should not use + or any arithmetic
operators
*/

public class cap_Add {

	public static void main(String[] args) {
		// Test case.
		System.out.println(add(123, 789) == 912);
		System.out.println(add(5, 7) == 12);
	}

	// Thought:
	// decimal addition is equivalent to binary addition, so we can take advantage of
	// binary operators given arithmetic operators prohibited.
	public static int add(int a, int b) {
		// The tricky part to how to approve that b will be 0 eventually?
		// Answer:
		// xor and and operation are mutually exclusive and so are their results.
		// Shift by one will eventually elimiate more 1's in b and it will converge.
		int xor;
		while (b != 0) {
			xor = a ^ b; // xor operation filters the different bit at the same position.
			b = (a & b) << 1; // and operation filters the same bit at the same position. Shift by 1 to add them up.
			a = xor;
		}
		return a;
	}
}
