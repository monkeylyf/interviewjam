/*Update_Bit_Substring
careercup

You are given two 32-bit numbers, N and M, and two bit positions, i and j.
Write a method to set all bits between i and j in N equal to M (e g , M
becomes a substring of N located at i and starting at j)
EXAMPLE:
Input: N = 10000000000, M = 10101, i = 2, j = 6
Output: N = 10001010100
*/


public class cap_Update_Bit_Substring {

	public static void main(String[] args) {
		// m: 11000000111001
		// n: 1111011
		int m = 12345;
		int n = 123;
		String mBin = "11000000111001";
		String nBin = "1111011";
		System.out.println(updateBits(mBin, nBin, 2, 8));
		//myUpdateBits(412, 14, 4, 7);
	}
	
	// Making binary mask based on the value of i and j.
	// Use or operation to 'embeded' the substring.
	public static String updateBits(String n, String m, int i, int j) {
		int max = ~0;
		int nDeci = Integer.parseInt(n, 2);
		int mDeci = Integer.parseInt(m, 2);
		if (n.length() <= j || j < 0 || i < 0) {
			// Invalid i or j.
			return "0";
		}
		int left = max - ((1 << j) - 1);
		int right = ((1 << i) - 1);
		int mask = left | right; // 111111100000011.
		System.out.println(String.format("left: %s\nright: %s\nmast: %s", 
						   Integer.toBinaryString(max - ((1 << j) - 1)),
						   Integer.toBinaryString((1 << i) - 1),
						   Integer.toBinaryString(mask)));
		return Integer.toBinaryString((nDeci & mask) | (mDeci << i));
	}
}
