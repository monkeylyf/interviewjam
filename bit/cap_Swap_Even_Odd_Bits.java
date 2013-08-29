/*Swap_Even_Odd_Bits
careercup

Write a program to swap odd and even bits in an integer with as few instructions
as possible (e g , bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped,
etc)
*/

class cap_Swap_Even_Odd_Bits {

	public static void main(String[] args) {
		for (int i = 1; i < 20; ++i) {
			swapEvenOdd(i);
		}
	}

	public static void swapEvenOdd(int i) {
		// 0xaaaaaaaa => Repeat of 1010 (x8). A mask to extract all even bits.
		// 0x55555555 => Repeat of 0101 (x8). A mask to extract all odd bits.
		System.out.println(Integer.toBinaryString(i));
		// i & 0xaaaaaaaa left shifts by one then even bits become odd bits.
		// i & 0x55555555 right shifts by one then odd bits become even bits.
		// Use OR operation to merge.
		System.out.println(Integer.toBinaryString((i & 0xaaaaaaaa) >> 1 | (i & 0x55555555) << 1));
	}
}
