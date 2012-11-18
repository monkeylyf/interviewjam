/*Write a program to swap odd and even bits in an integer with as few instructions as
possible (e g , bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc)*/

class test_33 {
	public static void main(String[] args) {
		for (int i = 1; i < 20; ++i) swapEvenOdd(i);
	}

	public static void swapEvenOdd(int i) {
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString((i & 0xaaaaaaaa) >> 1 | (i & 0x55555555) << 1));
	}
}
