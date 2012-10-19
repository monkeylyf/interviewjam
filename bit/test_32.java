/*Write a function to determine the number of bits required to convert integer A to integer B
Input:31, 14
Output:2
*/

class test_32 {
	public static void main(String[] args) {
		bitSwapRequired(213, 189);
	}

	public static int bitSwapRequired(int a, int b) {
		int swap = 0;
		String str = Integer.toBinaryString((a | b) - (a & b));
		System.out.println(Integer.bitCount((a | b) - (a & b)));
		return Integer.bitCount((a | b) - (a & b));
	}
}
