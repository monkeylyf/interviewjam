/*You are given two 32-bit numbers, N and M, and two bit positions, i and j Write a method
to set all bits between i and j in N equal to M (e g , M becomes a substring of N located
at i and starting at j)
EXAMPLE:
Input: N = 10000000000, M = 10101, i = 2, j = 6
Output: N = 10001010100
*/

class test_28 {
	public static void main(String[] args) {
		int m = 12345;
		int n = 123;
		myUpdateBits(m, n, 2, 8);
		myUpdateBits(412, 14, 4, 7);
	}

	public static int updateBits(int n, int m, int i, int j) {
		int max = ~0;
		if (Integer.toBinaryString(m).length() != Math.abs(j - i) + 1) return 0;
		System.out.println(Integer.toBinaryString(max - ((1 << j) - 1)));
		System.out.println(Integer.toBinaryString(((1 << i) - 1)));
		int left = max - ((1 << j) - 1);
		int right = ((1 << j) - 1);
		int mask = left | right;
		System.out.println(Integer.toBinaryString(mask));

		return (n & mask) | (m << i);
	}

	public static void myUpdateBits(int n, int m, int i, int j) {
		System.out.println("Input i is " + i);
		System.out.println("Input j is " + j);
		if (Integer.toBinaryString(m).length() != j - i + 1) {
			System.out.println("Position do not match!!!");
		}
		int max = ~0;
		int n1 = max - ((1 << j + 1 ) - 1) + (int)Math.pow(2, i) - 1;
		int m1 = m << i;
		int result = (n & n1) | m1;
		System.out.println("Answer is " + Integer.toBinaryString(result));
		System.out.println("Input n is " + Integer.toBinaryString(n));
		System.out.println("Input m is " + Integer.toBinaryString(m));
	}
}
