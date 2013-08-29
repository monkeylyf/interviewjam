/*Number_Of_Bits_Changed_When_Converting_Numbers
careercup

Write a function to determine the number of bits required to convert integer A
to integer B.
Input:31, 14
Output:2
*/

class cap_Number_Of_Bits_Changed_When_Converting_Numbers {

	public static void main(String[] args) {
		int a, b;
		// test case.
		a = 213;
		b = 189;
		System.out.println(String.format("a: %s\nb: %s",
						   Integer.toBinaryString(a),
						   Integer.toBinaryString(b)));
		System.out.println(bitSwapRequired(a, b));
	}

	public static int bitSwapRequired(int a, int b) {
		return Integer.bitCount(a | b) - Integer.bitCount(a & b);
	}
}
